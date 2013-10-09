# Twitter Streamer

### About
Listens to the twitter streaming API and filters responses based on keywords.

### Requirements
- Sbt
- Creativity

### Use
```bash
chmod a+x build
./build
```
```
> update
> console
```
```scala
import com.hackeracademy.twitterstreamer
twitterstreamer.StatusStreamer(1000, "yolo")
// would stream results for 1 second that contain
// the phrase yolo
```

### Last Notes
I purposely left out the file ``src/main/scala/com/hackeracademy/AuthVariables.scala`` for the user to fill in their own oauth credentials. For those that are new, should look something like this:

```scala
package com.hackeracademy.twitterstreamer

object AuthVariables {
  val authConsumerKey: String = "..."
  val authConsumerSecret: String = "..."
  val authAccessToken: String = "..."
  val authAccessTokenSecret: String = "..."
}
```

Get your credentials from: https://dev.twitter.com/
