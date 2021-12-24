case class Auto(mark: String, model: String)

/**
 * Хотим узнать какие машины можно обслужить учитывая этих двух дилеров
 * Реализуйте метод который примет две коллекции (два источника) и вернёт объединенный список уникальный значений
 **/
def intersectionAuto(dealerOne: Iterable[Auto], dealerTwo: Iterable[Auto]): Iterable[Auto] = {
  dealerOne.toSet ++ dealerTwo
}

val dealerOne = Vector(Auto("BMW", "i3"), Auto("Mazda", "X5"))
val dealerTwo = Seq(Auto("BMW", "i3"), Auto("Mazda", "X5"), Auto("Opel", "Astra"))


intersectionAuto(dealerOne, dealerTwo)

/**
   * Хотим узнать какие машины обслуживается в первом дилеромском центре, но не обслуживаются во втором
   * Реализуйте метод который примет две коллекции (два источника)
   * и вернёт уникальный список машин обслуживающихся в первом дилерском центре и не обслуживающимся во втором
   **/
  def filterAllLeftDealerAutoWithoutRight(dealerOne: Iterable[Auto], dealerTwo: Iterable[Auto]): Iterable[Auto] = {
    dealerOne.toSet.diff(dealerTwo.toSet)
  }


filterAllLeftDealerAutoWithoutRight(dealerTwo, dealerOne)
