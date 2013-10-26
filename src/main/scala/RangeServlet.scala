package com.gastove.the_range

import org.scalatra._
import scalate.ScalateSupport
import com.gastove.the_range.models._
import com.gastove.the_range.config._
import collection.JavaConversions._

class RangeServlet extends TheRangeStack {

  before() {
    contentType = "text/html"
  }

  get("/") {
    jade("/home", "avatarURL" -> Gravatar.url)

  }

  get("/themakingof/?") {
    jade("/makingOf", "avatarURL" -> Gravatar.url)
  }


}
