package com.gastove.the_range

import org.scalatra._
import scalate.ScalateSupport

class RangeServlet extends TheRangeStack {

  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        Say <a href="hello-scalate">hello to Scalate</a>.
      </body>
    </html>
  }
  
}
