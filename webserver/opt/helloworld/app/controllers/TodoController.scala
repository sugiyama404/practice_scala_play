package controllers

import javax.inject.{Inject, Singleton}
import models.Todo
import play.api.data.Form
import play.api.mvc._
import play.api.libs.json._

@Singleton
class TodoController @Inject()  (cc: ControllerComponents)
    extends AbstractController(cc) {

  def listTodos: Action[AnyContent] = Action { Ok(Json.toJson(Todo.findAll)(Writes.list(Writes.of[Todo])))}

  def getTodo(id: Long): Action[AnyContent] = Action {
    Todo.findById(id).map { todo =>
      Ok(Json.toJson(todo))
    }.getOrElse(NotFound)
  }

  def createTodo: Action[AnyContent] = Action(Parser.json) { request =>
    val todo = request.body.as[Todo]
    Todo.create(todo)
    Ok(Json.toJson(todo))
  }

  def updateTodo(id: Long): Action[AnyContent] = Action(Parser.json) { request =>
    val todo = request.body.as[Todo]
    Todo.update(todo)
    Ok(Json.toJson(todo))
  }

  def deleteTodo(id: Long): Action[AnyContent] = Action {
    Todo.delete(id)
    Ok(Json.toJson("Todo deleted"))
  }
}
