package com.jdaalba

import org.scalatest.flatspec.AnyFlatSpec

class RomanDecoderTest extends AnyFlatSpec {


  "decode" should "pass basic tests" in {
    val testCases = List( //roman, expected
      ("I", 1),
      ("III", 3),
      ("IV", 4),
      ("XXI", 21),
      ("MDCLXVI", 1666),
      ("MCMXC", 1990),
      ("MMVIII", 2008)
    )

    testCases.foreach {
      case (roman, expected) => assertResult(expected, s"\nInput\n  roman = $roman") {
        RomanDecoder(roman)
      }
    }
  }

}
