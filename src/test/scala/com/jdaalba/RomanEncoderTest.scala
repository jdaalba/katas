package com.jdaalba

import org.scalatest.flatspec.AnyFlatSpec

class RomanEncoderTest extends AnyFlatSpec {


  it should "pass basic tests" in {
    val testCases = List( //arabic, expected
      (1, "I"),
      (3, "III"),
      (4, "IV"),
      (6, "VI"),
      (14, "XIV"),
      (21, "XXI"),
      (89, "LXXXIX"),
      (91, "XCI"),
      (984, "CMLXXXIV"),
      (1000, "M"),
      (1666, "MDCLXVI"),
      (1889, "MDCCCLXXXIX"),
      (1989, "MCMLXXXIX"),
      (2008, "MMVIII")
    )

    testCases.foreach {
      case (arabic, expected) => assertResult(expected, "\nInput:\n  arabic = $arabic") {
        RomanEncoder(arabic)
      }
    }
  }
}
