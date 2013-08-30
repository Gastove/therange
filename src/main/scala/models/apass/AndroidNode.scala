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

  // Find this node's neighbors.
  def neighbors(): List[Int] = {
    this.alignment match {
      case "center" => 1 to 9 toList
      case "horizontal" => List(id - 1, id + 1)
      case "vertical" => List(id -3, id + 3)
      case "ul" => List(id + 3, id + 1)
      case "ur" => List(id + 3, id - 1)
      case "ll" => List(id - 3, id + 1)
      case "lr" => List(id - 3, id - 1)
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
      case 2 | 8 => "horizontal"
      case 4 | 6 => "vertical"
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
