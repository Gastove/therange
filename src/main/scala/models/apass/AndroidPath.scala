package com.gastove.the_range.models.apass

abstract class AndroidPath {

  val path: List[AndroidNode]
  def isEmpty(): Boolean
  def length(): Int
  def addToPath(
    candidateNode: AndroidNode): AndroidPath
  def toString(): String

}

class EmptyPath extends AndroidPath {

  val path: List[AndroidNode] = List()
  def isEmpty() = true
  def length(): Int = 0
  def addToPath(
    candidateNode: AndroidNode): AndroidPath =
    new Path(List(candidateNode))
  override def toString(): String = "<Empty Path>"

}

class Path(val path: List[AndroidNode]) extends AndroidPath {

  def length(): Int = this.path.length

  def isEmpty(): Boolean = false

  def addToPath(
    candidateNode: AndroidNode): Path = {
    if(isValid(candidateNode)) new Path(candidateNode +: this.path)
    else this
  }

  // Check to be sure an added node is valid.
  def isValid(node: AndroidNode): Boolean = {

    // Initialize local variables.
    val activeNode = this.path.head
    val neighbors = activeNode.neighbors
    val activeNeighbors = neighbors.filter{ node => !this.path.contains(node) }

    // Local helper function set
    def bridgeNode(): Int = {
      def sharedNeighbors(): List[AndroidNode] = {
        activeNode.neighbors.intersect(node.neighbors)
      }

      def aligned(): Int = {
        def inLine(int_1: Int, int_2: Int): Boolean = {
          ((int_1 == int_2 + 2) || (int_1 == int_2 - 2))
        }

        if (inLine(node.x, activeNode.x) && node.y == activeNode.y) 1 // horizontal
        else if (inLine(node.y, activeNode.y) && node.x == activeNode.x) 2 // vertical
        else if (inLine(node.x, activeNode.x) && inLine(node.y, activeNode.y)) 3 // diagonal
        else 0 // failure case
      }

      aligned // call the alignment helper function

    }

    // Do the actual work.
    if (activeNeighbors.contains(node) || this.isEmpty) true
    else {
      bridgeNode match {
        case 0 => false
        case 1 => this.path.contains(AndroidNode(2, activeNode.y))
        case 2 => this.path.contains(AndroidNode(activeNode.x, 2))
        case 3 => this.path.contains(AndroidNode(2, 2))
      }
    }
  }

  override def toString(): String = {
    this.path.reverse.mkString("->")
  }

}
