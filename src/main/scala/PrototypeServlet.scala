package com.gastove.the_range

import org.scalatra._
import scalate.ScalateSupport
import com.gastove.the_range.models.apass._
import com.gastove.the_range.config._

// Problem statement:
//     Get all the possible passwords for an Android Shape Password System
// Parameters:
//   -- An Android password UI has 9 dots.
//   -- A password can start at any dot; it must connect to an adjacent dot.
//   -- Once a dot is used, it cannot be used again.
//   -- A valid password contains at least 4 dots.
//
// So a process:
//   -- Map function over all dots
//   -- Once length of solution hits 4, return a solution but also keep recursing.
//
// Notes
//   -- add each remaining dot to function.

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
    val generator = NodeFactory.genNode _
    val nodes = (1 to 9).toList.map(generator(_)).toList
  }

  get("/problem-space") {
    def calcCombos(start: Int, maxDepth: Int, curDepth: Int = 1): Int = {
      if (maxDepth > curDepth && maxDepth > 0) start * calcCombos(start - 1, maxDepth, curDepth + 1)
      else start
    }

    val space = (4 to 9).toList.map{ x => (x, calcCombos(9, x)) }.toMap

    <html>
      <body>
      Problem space is this big: <br />
      <ol>
      <li>Four dot combos: { space(4) }</li>
      <li>Five dot combos: { space(5) }</li>
      <li>Six dot combos: { space(6) }</li>
      <li>Seven dot combos: { space(7) }</li>
      <li>Eight dot combos: { space(8) }</li>
      <li>Nine dot combos: { space(9) }</li>
      </ol>
      <br />
      Total problems: { space.foldLeft(0){ case (a, (k, v)) => a + v } }
      </body>
    </html>
  }

}
