package com.gastove.the_range

import org.scalatra._
import scalate.ScalateSupport
import twitter4j.{Twitter, TwitterException, Status}
import com.gastove.the_range.models._
import com.gastove.the_range.config._
import collection.JavaConversions._

class RangeServlet extends TheRangeStack {

  get("/") {
    contentType = "text/html"
    val avatarURL = "http://www.gravatar.com/avatar/" + 
      Md5.hash("gastove@gmail.com") +
      "?size=160"

    jade("/home", "layout" -> "/WEB-INF/layouts/_calavera.jade", "avatarURL" -> avatarURL)

  }
  
  get("/twistory") {
    val tweetList = TweetSet.getHomeTimelineList
    val printable = tweetList.map{ status => status.getUser.getName + ":" + status.getText + "\n" }.toList
    <html>
      <body>
      {printable}
      </body>
    </html>
   // tweetList.map{ status =>
   //   println(status.getUser.getName + ":" + status.getText)
   // }
  }

}
