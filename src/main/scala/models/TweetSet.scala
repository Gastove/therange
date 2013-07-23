
package com.gastove.the_range.models

//import com.gastove.the_range.config.TwitterConfig
import twitter4j.TwitterFactory
import collection.JavaConversions._

object TweetSet extends TwitterInstance {
  
  def getHomeTimelineList() = {
    twitter.getHomeTimeline.toList
  }

//   def getSetupTwitterObject() = {
//     val cbuild = new ConfigurationBuilder
//     cbuild.setDebugEnabled(true)
//       .setOAuthConsumerKey(System.getenv("TWITTER_CONSUMER_KEY"))
//       .setOAuthConsumerSecret(System.getenv("TWITTER_CONSUMER_SECRET"))
//       .setOAuthAccessToken(System.getenv("TWITTER_ACCESS_TOKEN"))
//       .setOAuthAccessTokenSecret(System.getenv("TWITTER_ACCESS_SECRET"))
// //    val config = TwitterConfig.getConfigs
//     val fac = new TwitterFactory(cbuild.build)
//     fac.getInstance
//   }

}
