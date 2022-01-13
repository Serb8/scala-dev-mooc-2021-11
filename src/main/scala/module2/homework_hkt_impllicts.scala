package module2

object homework_hkt_impllicts{

  /**
   *
   * Доработать сигнатуру tupleF и реализовать его
   * По итогу должны быть возможны подобные вызовы
   *   val r1 = println(tupleF(optA, optB))
   *   val r2 = println(tupleF(list1, list2))
   *
   */


  trait Bindable[F[_], A] {
    def map[B](c: F[A])(f: A => B): F[B]
    def flatMap[B](c: F[A])(f: A => F[B]): F[B]
  }

  object Bindable {
    implicit val optionInt: Bindable[Option, Int] = new Bindable[Option, Int] {
      override def map[B](opt: Option[Int])(f: Int => B): Option[B] = opt.map(f)

      override def flatMap[B](opt: Option[Int])(f: Int => Option[B]): Option[B] = opt.flatMap(f)
    }

    implicit val listInt: Bindable[List, Int] = new Bindable[List, Int] {
      override def map[B](list: List[Int])(f: Int => B): List[B] = list.map(f)

      override def flatMap[B](list: List[Int])(f: Int => List[B]): List[B] = list.flatMap(f)
    }

    //    def from[F[_], A]: Bindable[F[_], A] = new Bindable[F[_], A] {
    //      override def map[B](opt: F[A])(f: Int => B): F[B] = opt.map(f)
    //      override def flatMap[B](opt: F[A])(f: Int => F[B]): F[B] = opt.flatMap(f)
    //    }
  }

  def tupleF[F[_], A, B](fa: F[A], fb: F[B])(implicit m: Bindable[F, A], k: Bindable[F, B]): F[(A, B)] =
    m.flatMap(fa)(a => k.map(fb)(b => (a, b)))

  implicit class BindableOps[F[_], A, B](fa: F[A]) {
    def tupleF(fb: F[B])(implicit m: Bindable[F, A], k: Bindable[F, B]): F[(A, B)] = m.flatMap(fa)(a => k.map(fb)(b => (a, b)))
  }


  //  implicit def optToBindable[A](opt: Option[A]): Bindable[Option, A] = new Bindable[Option, A] {
  //    def map[B](f: A => B): Option[B] = opt.map(f)
  //    def flatMap[B](f: A => Option[B]): Option[B] = opt.flatMap(f)
  //  }
  //
  //  implicit def listToBindable[A](opt: List[A]): Bindable[List, A] = new Bindable[List, A] {
  //    def map[B](f: A => B): List[B] = opt.map(f)
  //    def flatMap[B](f: A => List[B]): List[B] = opt.flatMap(f)
  //  }



  val optA: Option[Int] = Some(1)
  val optB: Option[Int] = Some(2)

  val list1 = List(1, 2, 3)
  val list2 = List(4, 5, 6)

  val r1 = println(tupleF(optA, optB))
  val r2 = println(tupleF(list1, list2))

  val r3 = println(optA tupleF optB)
  val r4 = println(list1 tupleF list2)
}