package com.jdaalba

import scala.util.matching.Regex

object BowlingParser {

  def totalScore(game: String): Int = sumRolls(game.split(" ").map(mapFrame).toList)

  def sumRolls(rollList: List[Frame]): Int = rollList match {
    case Open(r1, r2) :: rs => r1 + r2 + sumRolls(rs)
    case (_: Spare) :: (o: Open) :: rs => 10 + o.r1 + sumRolls(o :: rs)
    case (_: Spare) :: Spare(r) :: rs => 10 + r + sumRolls(Spare(r) :: rs)
    case (_: Spare) :: Strike :: rs => 20 + sumRolls(Strike :: rs)
    case List(Bonus(r1, r2, r3)) => r1 + r2 + r3
    case Strike :: Open(r1, r2) :: rs => 10 + r1 + r2 + sumRolls(Open(r1, r2) :: rs)
    case Strike :: (s: Spare) :: rs => 20 + sumRolls(s :: rs)
    case Strike :: Strike :: Strike :: rs => 30 + sumRolls(Strike :: Strike :: rs)
    case Nil => 0
  }

  def sumTwo(rolls: List[Frame]): Int = ???

  val open: Regex = "(\\d)(\\d)".r
  val spare: Regex = "(\\d)/".r
  val bonus: Regex = "(\\d)/(\\d)".r
  val strike: Regex = "X".r

  def mapFrame(inp: String): Frame = inp match {
    case open(r1, r2) => Open(r1.toInt, r2.toInt)
    case spare(r) => Spare(r.toInt)
    case bonus(r1, r3) => Bonus(r1.toInt, 10 - r1.toInt, r3.toInt)
    case strike() => Strike
  }
}

sealed trait Frame

case class Open(r1: Int, r2: Int) extends Frame

case class Spare(r: Int) extends Frame

case class Bonus(r1: Int, r2: Int, r3: Int) extends Frame

case object Strike extends Frame
