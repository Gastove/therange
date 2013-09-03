package com.gastove.the_range

import org.scalatra._
import scalate.ScalateSupport
import com.gastove.the_range.models.apass._
import com.gastove.the_range.models._
import com.gastove.the_range.config._

/*
 *
 * Problem statement:
 *     Get all the possible passwords for an Android Shape Password System
 * Parameters:
 *   -- An Android password UI has 9 dots.
 *   -- A password can start at any dot; it must connect to an adjacent dot.
 *   -- Once a dot is used, it cannot be used again.
 *   -- A valid password contains at least 4 dots.
 *
 * So a process:
 *   -- Map function over all dots
 *   -- Once length of solution hits 4, return a solution but also keep recursing.
 *
*/

class PrototypeServlet extends TheRangeStack {

  before () {
    contentType = "text/html"
  }

  get("/") {
    <html>
      <body>
      Is this thing on?
      </body>
    </html>
  }

  get("/gen-passes/?") {

    def findPath(nodes: List[AndroidNode], path: AndroidPath): List[AndroidPath] = {
      nodes.flatMap{ node =>
        val newPath = path.addToPath(node)
        val remainingNodes = nodes.filter{
          node => !newPath.contains(node)
        }
        if (newPath.length >= 9) List(newPath)
        else if (newPath.length >= 4) findPath(remainingNodes, newPath) ++ List(newPath)
        else findPath(remainingNodes, newPath)
      }
    }

    val grid = NodeGrid.generateGrid
    val paths = findPath(grid, new EmptyPath)

    jade(
      "/androidPasswords",
      "tableHeaders" -> List("Passwords"),
      "tableData" -> paths,
      "avatarURL" -> Gravatar.url
    )
  }
}
