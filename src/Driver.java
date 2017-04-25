import game.Frame;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 * Created by Diki Ardian W (13515092) on 4/24/17.
 */
public class Driver {
  public static void music() {

    AudioPlayer MGP = AudioPlayer.player;
    AudioStream BGM;
    AudioData MD;

    ContinuousAudioDataStream loop = null;

    try
    {
      InputStream test = new FileInputStream("./music/music.wav");
      BGM = new AudioStream(test);
      AudioPlayer.player.start(BGM);
      MD = BGM.getData();
      loop = new ContinuousAudioDataStream(MD);

    }
    catch(FileNotFoundException e){
      System.out.print(e.toString());
    }
    catch(IOException error)
    {
      System.out.print(error.toString());
    }
    MGP.start(loop);
  }
  public static void main(String[] args) throws FileNotFoundException {
    music();
    new Frame();
  }
}
