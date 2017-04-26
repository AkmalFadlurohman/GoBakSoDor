package game;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Created by um on 25/04/17.
 */

/**
 * AboutPanel.
 * Menangani panel "About"
 */
public class AboutPanel extends JPanel {
  private Image background;

  /**
   * Konstruktor.
   */
  public AboutPanel() {
    background = new ImageIcon("./images/About.jpg").getImage();
  }

  /**
   * Menangani tampilan visual panel.
   * @param graphics Kelas Graphics yang dipakai
   */
  @Override
  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    graphics.drawImage(background, 0, 0, getWidth(), getHeight(), null);
  }
}
