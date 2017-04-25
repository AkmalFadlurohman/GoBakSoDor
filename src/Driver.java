import game.Frame;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 * Created by Diki Ardian W (13515092) on 4/24/17.
 */
public class Driver {
  public static void music() {

    AudioStream BGM = null;
    AudioData MD;
    AudioPlayer MP = AudioPlayer.player;
    ContinuousAudioDataStream loop = null;

    try {
      BGM = new AudioStream(new FileInputStream("./music/music.wav"));
      MD = BGM.getData();
      loop = new ContinuousAudioDataStream(MD);
      MP.start(loop);
    } catch (IOException error) {
      MP.start(BGM);
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    music();
    new Frame();
  }
}
