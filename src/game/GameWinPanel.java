package game;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Created by Husnulzaki Wibisono Haryadi (13515005) on 4/26/17.
 */
public class GameWinPanel extends JPanel {
  private Image background;

  public GameWinPanel() {
    background = new ImageIcon("./images/Gamewin.jpg").getImage();
  }

  @Override
  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    graphics.drawImage(background, 0, 0, null);
  }
}
