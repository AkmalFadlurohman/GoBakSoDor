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

/**
 * Driver.
 * Implementasi program utama
 */
public class Driver {
  /**
   * Memutar musik pada program.
   */
  public static void music() {

    AudioStream bgm = null;
    AudioData md;
    AudioPlayer mp = AudioPlayer.player;
    ContinuousAudioDataStream loop = null;

    try {
      bgm = new AudioStream(new FileInputStream("./music/music.wav"));
      md = bgm.getData();
      loop = new ContinuousAudioDataStream(md);
      mp.start(loop);
    } catch (IOException error) {
      mp.start(bgm);
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    music();
    new Frame();
  }
}
