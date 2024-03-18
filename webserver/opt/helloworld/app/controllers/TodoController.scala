package controllers

import javax.inject.{Inject, Singleton}
import models.TodoServiceImpl
import play.api.mvc.{Action, AnyContent, Controller, Results}
import scala.concurrent.Future

@Singleton
class TodoController @Inject()(todoService: TodoServiceImpl)
  extends Controller {

  def listTodos: Action[AnyContent] = Action.async {
    todoService.findAll.map { todos =>
      Ok(Json.toJson(todos))
    }
  }
}
