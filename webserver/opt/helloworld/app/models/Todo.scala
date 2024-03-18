package models

import slick.jdbc.JdbcProfile
import slick.jdbc.MySQLProfile._

import profile.api._

trait SlickTables {

  val profile: JdbcProfile = MySQLProfile

  val db = Database.forConfig("default")

  object Todos extends TableDefinition(db, "todos") {
    def id = column("id", O.AutoInc)
    def title = column("title", O.String)
    def description = column("description", O.String)
    def isDone = column("is_done", O.Boolean)
    def createdAt = column("created_at", O.Timestamp)
    def updatedAt = column("updated_at", O.Timestamp)

    def * = id ~ title ~ description ~ isDone ~ createdAt ~ updatedAt

    def autoIncPK: PrimaryKey = id.primaryKey
  }
}
