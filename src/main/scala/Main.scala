import twitter4j._
import scala.collection.mutable.HashMap
import scala.collection.JavaConversions._
import scala.io._

//Tega razreda ni potrebno spreminjati, samo dodajte svoje ključe iz Twitterja
class TweetStreamer(manipulator: TweetManipulator) {
  val config = new twitter4j.conf.ConfigurationBuilder()
    .setOAuthConsumerKey("----------------------------------------") //sem vpišite 4 "ključe"
    .setOAuthConsumerSecret("--------------------------------------")
    .setOAuthAccessToken("----------------------------")
    .setOAuthAccessTokenSecret("-------------------------------")
    .build

  def simpleStatusListener = new StatusListener() {
    def onStatus(status: Status) {
      val tweet = status.getText
      manipulator.process(tweet)
    }
    def onDeletionNotice(statusDeletionNotice: StatusDeletionNotice) {}
    def onTrackLimitationNotice(numberOfLimitedStatuses: Int) {}
    def onException(ex: Exception) { ex.printStackTrace }
    def onScrubGeo(arg0: Long, arg1: Long) {}
    def onStallWarning(warning: StallWarning) {}
  }

}

trait TweetManipulator {
  def process(tweet: String)
  def outputFinal
}

//Primer obdelovalca tweetov
object TrivialManipulator extends TweetManipulator {
  def process(tweet: String) = {
    println("-------------------")
    println(tweet)
  }
  def outputFinal = println("Finished streaming")
}

//Primer enostavne naloge
object NalogaDemo {
  def main(args: Array[String]) {
    val tS = new TweetStreamer(TrivialManipulator)
    val twitterStream = new TwitterStreamFactory(tS.config).getInstance
    twitterStream.addListener(tS.simpleStatusListener)
    twitterStream.sample
    Thread.sleep(10000)
    TrivialManipulator.outputFinal
    twitterStream.cleanUp
    twitterStream.shutdown
  }
}

// Naloga 1
object EnglishManipulator extends TweetManipulator {
  def isEnglish(l:List[String]):Boolean = ???
  def process(tweet: String) = ???
  def outputFinal = ???
}

object Naloga1 {
  def main(args: Array[String]) {
    //TODO
  }
}


// Naloga 2
object FreqManipulator extends TweetManipulator {
  def process(tweet: String) = ???
  def outputFinal = ???
}

object Naloga2 {
  def main(args: Array[String]) {
    //TODO
  }
}

// Naloga 3
object SentimentManipulator extends TweetManipulator {
  def process(tweet: String) = ???
  def outputFinal = ???
}
object Naloga3 {
  def main(args: Array[String]) {
    //TODO
  }
}
