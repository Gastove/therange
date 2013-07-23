
package com.gastove.the_range.models

import twitter4j.TwitterFactory

// Returns a configured Twitter Instance

trait TwitterInstance {
  val twitter = new TwitterFactory(TwitterConfig.config).getInstance
}
