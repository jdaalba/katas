package com.jdaalba

object RomanEncoder {

  val numbers: List[(String, Int)] = List(
    ("M", 1_000),
    ("CM", 900),
    ("D", 500),
    ("CD", 400),
    ("C", 100),
    ("XC", 90),
    ("L", 50),
    ("XL", 40),
    ("X", 10),
    ("IX", 9),
    ("V", 5),
    ("IV", 4),
    ("I", 1)
  )

  def apply(inp: Int): String = numbers.find {
    case (_, v) => inp >= v
  }.map {
    case (romanNumber, arabicNumber) => romanNumber + RomanEncoder(inp - arabicNumber)
  }.getOrElse("")
}
