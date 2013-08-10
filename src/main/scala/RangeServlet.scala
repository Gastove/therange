package com.gastove.the_range

import org.scalatra._
import scalate.ScalateSupport
import twitter4j.{Twitter, TwitterException, Status}
import com.gastove.the_range.models._
import collection.JavaConversions._

class RangeServlet extends TheRangeStack {
  val thing = System.getenv("TWITTER_ACCESS_TOKEN")
  val message = "wut" + thing
  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        {println(message)}
      </body>
    </html>
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
