package com.jdaalba

object LinkedLists {

  def stringify(ints: List[Int]): String = ints match {
    case Nil => "null"
    case i :: is => s"$i -> ${LinkedLists stringify is}"
  }

  def parse(inp: String): List[Int] = inp match {
    case "null" => Nil
    case s"$n -> $ns" => n.toInt :: parse(ns)
  }
}
