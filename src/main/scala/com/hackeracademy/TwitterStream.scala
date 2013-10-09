package com.hackeracademy.twitterstreamer
 
import twitter4j._
 
object StatusStreamer(wait: Int, key: String) {

  val twitterStream = new TwitterStreamFactory(Util.config).getInstance
  twitterStream.addListener(Util.simpleStatusListener(key))
  twitterStream.sample
  Thread.sleep(wait)
  twitterStream.cleanUp
  twitterStream.shutdown

}

object Util {
  val config = new twitter4j.conf.ConfigurationBuilder()
    .setOAuthConsumerKey(AuthVariables.authConsumerKey)
    .setOAuthConsumerSecret(AuthVariables.authConsumerSecret)
    .setOAuthAccessToken(AuthVariables.authAccessToken)
    .setOAuthAccessTokenSecret(AuthVariables.authAccessTokenSecret)
    .build

  def simpleStatusListener(key: String) = new StatusListener() {
    // Functions called by Twitter4j
    def onStatus(status: Status) { 
      val text = status.getText
      if (text.toLowerCase().contains(key.toLowerCase()))
        println(status.getText)
    }
    // other not implemented functions
    def onDeletionNotice(statusDeletionNotice: StatusDeletionNotice) {}
    def onTrackLimitationNotice(numberOfLimitedStatuses: Int) {}
    def onException(ex: Exception) { ex.printStackTrace }
    def onScrubGeo(arg0: Long, arg1: Long) {}
    def onStallWarning(warning: StallWarning) {}
  }

}