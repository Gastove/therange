
package com.gastove.the_range.config

import twitter4j.conf.ConfigurationBuilder

object TwitterConfig {

  def getConfigs() {
    val cbuild = new ConfigurationBuilder
    cbuild.setDebugEnabled(true)
      .setOAuthConsumerKey(System.getenv("TWITTER_CONSUMER_KEY"))
      .setOAuthConsumerSecret(System.getenv("TWITTER_CONSUMER_SECRET"))
      .setOAuthAccessToken(System.getenv("TWITTER_ACCESS_TOKEN"))
      .setOAuthAccessTokenSecret(System.getenv("TWITTER_ACCESS_SECRET"))
  }

}
