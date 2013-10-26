package com.gastove.the_range.models

//import com.gastove.the_range.config.TwitterConfig
import twitter4j.{TwitterFactory, Paging}
import collection.JavaConversions._

object TweetSet extends TwitterInstance {

  def getHomeTimelineList() = {
    twitter.getHomeTimeline.toList
  }

  def getUserTimeline(user: String, start: Int = 1, stop: Int = 100) = {
    val paging = new Paging(start, stop)
    twitter.getUserTimeline(user, paging)
  }

  def getCompleteTimelineForUser(user: String) = {

  }

  def getOwnTimeline() = {
    getUserTimeline("Gastove")
  }

  def getOwnTimelineList = getOwnTimeline.toList


}
