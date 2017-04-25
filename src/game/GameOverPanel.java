package game;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Created by um on 25/04/17.
 */

/**
 * GameOverPanel.
 * Menangani panel "Game Over"
 */
public class GameOverPanel extends JPanel {
  private Image background;

  /**
   * Konstruktor.
   */
  public GameOverPanel() {
    background = new ImageIcon("./images/Gameover.jpg").getImage();
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
