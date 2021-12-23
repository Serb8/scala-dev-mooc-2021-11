var text = "There are numbers inm text - from 0 to 9"

var textList = text.split(' ')

val intStringNumerics: Map[String, String] = Map(
  "0" -> "zero",
  "1" -> "one",
  "2" -> "two",
  "3" -> "three",
  "4" -> "four",
  "5" -> "five",
  "6" -> "six",
  "7" -> "seven",
  "8" -> "eight",
  "9" -> "nine"
)

val x = refArrayOps(textList)
  .flatMap((el: _root_.scala.Predef.String) =>
    intStringNumerics
      .withFilter { case (int, string) => el.matches("\\d").&&(el.==(int)) }
      .map({ case (int, string) => string })
  )

val transformedList = text.split(' ').map(el =>
  if(el.matches("\\d")) {
    intStringNumerics
      .withFilter{case (int, _) => el == int}
      .map({ case (_, string) => string })
      .head
  }
  else el
).mkString(" ")

var forResult = for {
  el <- text.split(' ')
  (intRepresentation, stringRepresentation) <- intStringNumerics
} yield {
  if (el.matches("\\d") && el == intRepresentation) {
    stringRepresentation
  }
  else el
}

forResult.distinct






