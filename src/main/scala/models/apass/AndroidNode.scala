package com.gastove.the_range.models.apass

// Node Factory. Given an ID, returns the correct node.

object NodeFactory {

  def genNode(id: Int): AndroidNode = {
    id match {
      case 1 | 3 | 7 | 9 => new CornerNode(id)
      case 2 | 4 | 6 | 8 => new EdgeNode(id)
      case 5 => new CenterNode(id)
    }
  }

}

// Node classes
abstract class AndroidNode(val id: Int) {

  val alignment: String = position
  val canReach = neighbors

  // Implement in concrete classes
  def position(): String

  // Boolean, can this node reach a given other node?
  def reachable(node: AndroidNode): Boolean = {
    node match {
      case CenterNode(id) => true
      case _ :Any => canReach.contains(node.id)
    }
  }

  def allBut(x: Int): List[Int] =
    (1 to 9).toList.filter(y => y != x)

  // Find this node's neighbors.
  def neighbors(): List[Int] = {
    this.alignment match {
      case "center" => allBut(5)
      case "horizontal-top" => allBut(8)
      case "horizontal-bottom" => allBut(2)
      case "vertical-left" => allBut(6)
      case "vertical-bottom" => allBut(4)
      case "upper-left" => List(5, id + 3, id + 1)
      case "upper-right" => List(5, id + 3, id - 1)
      case "lower-left" => List(5, id - 3, id + 1)
      case "lower-right" => List(5, id - 3, id - 1)
      case _ => List(0) //Error case, hopefully.
    }
  }
}

case class CenterNode(override val id: Int) extends AndroidNode(id) {

  def position(): String = return "center"

}

case class EdgeNode(override val id: Int) extends AndroidNode(id) {

  def position(): String =  {
    this.id match {
      case 2 => "horizontal-top"
      case 8 => "horizontal-bottom"
      case 4 => "vertical-left"
      case 6 => "vertical-right"
    }
  }

}

case class CornerNode(override val id: Int) extends AndroidNode(id) {

  def position(): String = {
    this.id match {
      case 1 => "ul"
      case 3 => "ur"
      case 7 => "ll"
      case 9 => "lr"
    }
  }

}
