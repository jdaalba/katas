package com.jdaalba

import org.scalatest.flatspec.AnyFlatSpec

class LinkedListsTest extends AnyFlatSpec {

  behavior of "LinkedListsTest"

  they should "stringify a linked list" in {
    assertResult("null")(LinkedLists stringify List())
    assertResult("1 -> null")(LinkedLists stringify  List(1))
    assertResult("1 -> 2 -> 3 -> null")(LinkedLists stringify  List(1, 2, 3))
  }

  they should "parse a linked list" in {
    assertResult(Nil)(LinkedLists parse "null")
    assertResult(List(1))(LinkedLists parse "1 -> null")
    assertResult(List(1, 2, 3))(LinkedLists parse "1 -> 2 -> 3 -> null")
  }

}
