# Twitter Streamer

### About
Listens to the twitter streaming API and filters responses based on keywords.

### Requirements
- Sbt
- Creativity

### User
```bash
chmod a+x build
./build
```
```
> console
```
```scala
import com.hackeracademy.twitterstreamer
twitterstreamer.StatusStreamer(1000, "yolo")
// would stream results for 1 second that contain
// the phrase yolo
```
