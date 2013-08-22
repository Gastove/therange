package com.gastove.the_range

import org.scalatra._
import scalate.ScalateSupport
import twitter4j.{Twitter, TwitterException, Status}
import com.gastove.the_range.models._
import com.gastove.the_range.config._
import collection.JavaConversions._

class RangeServlet extends TheRangeStack {

  val calaveraPath = "/WEB-INF/layouts/_calavera.jade"
  val avatarURL = "http://www.gravatar.com/avatar/" +
    Md5.hash("gastove@gmail.com") +
    "?size=160"

  before() {
    contentType = "text/html"
  }

  get("/*") {
    jade("/home", "layout" -> calaveraPath, "avatarURL" -> avatarURL)

  }

  get("/themakingof/?") {
    jade("/makingOf", "layout" -> calaveraPath, "avatarURL" -> avatarURL)
  }

  get("/about/?") {
    jade("/about", "layout" -> calaveraPath, "avatarURL" -> avatarURL)
  }

  get("/about/:subsection") {
    val incoming = params.getOrElse("subsection", redirect("/about"))
    val section: String = incoming match{
      case incoming:String if (incoming != "") => incoming
      case _ => "/about"
    }
    jade(section, "layout" -> calaveraPath, "avatarURL" -> avatarURL)
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
