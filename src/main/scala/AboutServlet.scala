package com.gastove.the_range

import org.scalatra._
import scalate.ScalateSupport
import com.gastove.the_range.config.Gravatar

class AboutServlet extends TheRangeStack {

  before() {
    contentType = "text/html"
  }

  get("/") {
    jade("/about", "avatarURL" -> Gravatar.url)
  }

}
