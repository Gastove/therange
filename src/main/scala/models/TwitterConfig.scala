
package com.gastove.the_range.models

import twitter4j.conf.ConfigurationBuilder

object TwitterConfig {

  val config = buildConfigObject()

  def buildConfigObject() = {
    val cbuild = new ConfigurationBuilder()
    cbuild.setDebugEnabled(true)
      .setOAuthConsumerKey(System.getenv("TWITTER_CONSUMER_KEY"))
      .setOAuthConsumerSecret(System.getenv("TWITTER_CONSUMER_SECRET"))
      .setOAuthAccessToken(System.getenv("TWITTER_ACCESS_TOKEN"))
      .setOAuthAccessTokenSecret(System.getenv("TWITTER_ACCESS_SECRET"))
      .build
  }

}
