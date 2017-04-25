package game;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Created by um on 25/04/17.
 */
public class MenuPanel extends JPanel {
  private Image background;

  public MenuPanel() {
    background = new ImageIcon("./images/Castle.jpg").getImage();
  }

  @Override
  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    graphics.drawImage(background, 0, 0, null);
  }
}
