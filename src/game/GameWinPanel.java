package game;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Created by Husnulzaki Wibisono Haryadi (13515005) on 4/26/17.
 */

/**
 * GameWinPanel.
 * Menangani panel "Game Win"
 */
public class GameWinPanel extends JPanel {
  private Image background;
  /**
   * Konstruktor.
   */
  public GameWinPanel() {
    background = new ImageIcon("./images/Gamewin.jpg").getImage();
  }

  /**
   * Menangani tampilan visual panel.
   * @param graphics Kelas Graphics yang dipakai
   */
  @Override
  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    graphics.drawImage(background, 0, 0, null);
  }
}
