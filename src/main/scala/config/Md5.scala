
package com.gastove.the_range.config

import java.security.MessageDigest

object Md5 {

  def hash(text: String): String = {
    val digest = MessageDigest.getInstance("md5")
    digest.digest(text.getBytes).map("%02x".format(_)).mkString
  }

}
