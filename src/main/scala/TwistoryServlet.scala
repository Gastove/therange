package com.gastove.the_range

import org.scalatra._
import scalate.ScalateSupport
import com.gastove.the_range.models._
import com.gastove.the_range.config._
import twitter4j.{Twitter, TwitterException, Status}

class TwistoryServlet extends TheRangeStack {

  before() {
    contentType = "text/html"
  }

  get("/show_raw") {
    //val tweetList = TweetSet.getHomeTimelineList
    val tweetList = TweetSet.getOwnTimelineList
    val printable = tweetList.map{ status => List(status.getUser.getName, status.getText) }.toList
    jade(
      "/table"
        , "layout" -> "WEB-INF/templates/layouts/bare.jade"
        , "tableHeaders" -> List("User", "Tweet Body")
        , "tableData" -> printable
    )
  }

}
