package futures

import HomeworksUtils.TaskSyntax

import scala.:+
import scala.concurrent.{ExecutionContext, Future, blocking}
import scala.util.{Failure, Success}

object task_futures_sequence {

  /**
   * В данном задании Вам предлагается реализовать функцию fullSequence,
   * похожую на Future.sequence, но в отличии от нее,
   * возвращающую все успешные и не успешные результаты.
   * Возвращаемое тип функции - кортеж из двух списков,
   * в левом хранятся результаты успешных выполнений,
   * в правово результаты неуспешных выполнений.
   * Не допускается использование методов объекта Await и мутабельных переменных var
   */
  /**
   * @param futures список асинхронных задач
   * @return асинхронную задачу с кортежом из двух списков
   */
  def fullSequence[A](futures: List[Future[A]])
                     (implicit ex: ExecutionContext): Future[(List[A], List[Throwable])] = {
    futures.foldLeft(Future((List[A](), List[Throwable]()))) {
      (r, f) => {
        r.flatMap {
          acc => f.transformWith{
            case Success(value) => Future(acc._1 :+ value, acc._2)
            case Failure(exception) => Future(acc._1, acc._2 :+ exception)
          }
        }
      }
    }
  }
}
