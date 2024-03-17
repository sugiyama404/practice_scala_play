package models

import javax.persistence._


@Entity
case class Todo(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  id: Long,
  title: String,
  description: String,
  isDone: Boolean,
  createdAt: java.sql.Timestamp,
  updatedAt: java.sql.Timestamp
)

object Todo {
  def findAll: List[Todo] = {
    DB.withConnection { implicit c =>
      val records = SQL("SELECT * FROM todos")().map {
        row =>
          Todo(
            row[Int]("id").toLong,
            row[String]("title"),
            row[String]("description"),
            row[Boolean]("is_done"),
            new Timestamp(row[Long]("created_at").toLong),
            new Timestamp(row[Long]("updated_at").toLong)
          )
      }
      records.toList
    }
  }
  def findById(id: Long): Option[Todo] = {

    DB.withConnection { implicit c =>
      SQL("SELECT * FROM todos WHERE id = $id").bind(id).asOpt[Todo] {
        row =>
          Todo(
            row[Int]("id").toLong,
            row[String]("title"),
            row[String]("description"),
            row[Boolean]("is_done"),
            new Timestamp(row[Long]("created_at").toLong),
            new Timestamp(row[Long]("updated_at").toLong)
          )
      }
    }
  }
  def create(todo: Todo): Todo = {

    DB.withConnection { implicit c =>
      SQL("""
        INSERT INTO todos (title, description, is_done, created_at, updated_at)
        VALUES ($title, $description, $is_done, $createdAt, $updatedAt)
      """).bind(
        todo.title,
        todo.description,
        todo.is_done,
        new Timestamp(todo.createdAt.getTime),
        new Timestamp(todo.updatedAt.getTime)
      ).execute()

      todo.copy(id = SQL("SELECT LAST_INSERT_ID()").as[Long].head)
    }
  }
  def update(todo: Todo): Todo = {

    DB.withConnection { implicit c =>
      SQL("""
        UPDATE todos
        SET title = $title, description = $description, is_done = $is_done, updated_at = $updatedAt
        WHERE id = $id
      """).bind(
        todo.id,
        todo.title,
        todo.description,
        todo.is_done,
        new Timestamp(todo.updatedAt.getTime)
      ).execute()

      todo
    }
  }
  def delete(id: Long): Unit = {

    DB.withConnection { implicit c =>
      SQL("DELETE FROM todos WHERE id = $id").bind(id).execute()
    }
  }

}
