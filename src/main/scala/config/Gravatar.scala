package com.gastove.the_range.config

object Gravatar {

  val url = "http://www.gravatar.com/avatar" + Md5.hash("gastove@gmail.com") + "?size=160"

}
