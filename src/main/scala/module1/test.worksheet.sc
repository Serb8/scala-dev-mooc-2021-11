import java.io.PrintStream

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

var x = for {
  el <- textList
  (int, string) <- intStringNumerics
  if el.matches("\\d") && el == int
} yield string





