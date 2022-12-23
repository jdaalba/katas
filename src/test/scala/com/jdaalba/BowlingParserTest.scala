package com.jdaalba

import org.scalatest.flatspec.AnyFlatSpec

class BowlingParserTest extends AnyFlatSpec {

  behavior of "BowlingParserTest"

  they should " calculate totalScore right" in {
    assertResult(20)(BowlingParser totalScore "11 11 11 11 11 11 11 11 11 11")
    assertResult(29)(BowlingParser totalScore "11 11 11 11 11 11 11 11 1/ 11")
    assertResult(29)(BowlingParser totalScore "11 11 11 11 11 11 11 11 11 1/1")
    assertResult(38)(BowlingParser totalScore "11 11 11 11 11 11 1/ 1/ 11 11")
    //assertResult(109)(BowlingParser totalScore "45 9/ 5/ 72 34 18 22 90 8/ 9/1")
    //assertResult(187)(BowlingParser totalScore "X 9/ 5/ 72 X X X 90 8/ 9/X")
    assertResult(122)(BowlingParser totalScore "X 42 06 X 8/ 2/ X 62 X 12")
    /*assertResult(300)(BowlingParser totalScore "X X X X X X X X X XXX")
    assertResult(290)(BowlingParser totalScore "X X X X X X X X X XX0")
    assertResult(284)(BowlingParser totalScore "X X X X X X X X X X46")
    assertResult(31)(BowlingParser totalScore "11 11 11 11 11 11 11 11 11 X12")*/
  }
}
