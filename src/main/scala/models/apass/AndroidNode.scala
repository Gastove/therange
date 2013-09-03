package com.gastove.the_range.models.apass

case class AndroidNode(x: Int, y: Int) {

  lazy val neighbors = getAdjacentNodes

  override def toString(): String = "<" + this.x + "," + this.y + ">"

  def getAdjacentNodes(): List[AndroidNode]= {

    def inRange(param: Int): Boolean = { (param > 0 && param < 4) }

    (-1 to 1)
      .toList
      .flatMap{
      xMod => (-1 to 1)
        .toList
        .map{
        yMod => AndroidNode(this.x + xMod, this.y + yMod)
      }
    }
      .filter{ node => (inRange(node.x) && inRange(node.y)) && node != this }
  }

}

// Grid Generator
object NodeGrid {

  def generateGrid(): List[AndroidNode] = {
    (1 to 3).toList.flatMap{ x => (1 to 3).toList.map{y => AndroidNode(x, y)}}
  }

}
