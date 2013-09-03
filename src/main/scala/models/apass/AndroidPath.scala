package com.gastove.the_range.models.apass

import scala.math.abs

abstract class AndroidPath {

  val path: List[AndroidNode]
  def isEmpty(): Boolean
  def length(): Int
  def contains(node: AndroidNode): Boolean
  def addToPath(
    candidateNode: AndroidNode): AndroidPath
  def toString(): String

}

class EmptyPath extends AndroidPath {

  val path: List[AndroidNode] = List()
  def isEmpty() = true
  def length(): Int = 0
  def contains(node: AndroidNode): Boolean = false
  def addToPath(
    candidateNode: AndroidNode): AndroidPath =
    new Path(List(candidateNode))
  override def toString(): String = "<Empty Path>"

}

class Path(val path: List[AndroidNode]) extends AndroidPath {

  def length(): Int = this.path.length

  def isEmpty(): Boolean = false

  def contains(node: AndroidNode): Boolean = this.path.contains(node)

  def addToPath(
    candidateNode: AndroidNode): Path = {

    if (this.path.head.neighbors.contains(candidateNode))
      new Path(candidateNode +: this.path)
    else {
      val interstitial = getInterstitialNode(candidateNode)
      if (this.path.contains(interstitial))
        new Path(candidateNode +: this.path)
      else
        new Path(candidateNode +: interstitial +: this.path)
    }
  }

  def getInterstitialNode(candidateNode: AndroidNode): AndroidNode = {
    this.path.head - candidateNode
  }

  override def toString(): String = {
    this.path.reverse.mkString("->")
  }

}
