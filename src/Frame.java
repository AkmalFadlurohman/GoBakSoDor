import javax.swing.JFrame;
import java.io.FileNotFoundException;

/**
 * Created by Diki Ardian W (13515092) on 4/24/17.
 */
public class Frame extends JFrame {
  final private int HEIGHT = 720;
  final private int WIDTH = 1280;

  public Frame() throws FileNotFoundException {
    setName("Bakso");
    setSize(WIDTH, HEIGHT);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    Game game = new Game(4);
    add(game);
    addKeyListener(game);
  }
}
