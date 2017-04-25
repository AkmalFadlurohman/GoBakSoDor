package item;

import movable.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

/**
 * Created by akmalfadlurohman on 4/23/17.
 */
public class Special extends Item {
  private BufferedImage image;

  public Special(int posX, int posY) {
    super("Special", "Slow enemies movement for one second", posX, posY);
    try {
      image = ImageIO.read(new File("./images/snowflakes.png"));
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }

  public BufferedImage getImage() {
    return image;
  }

  public void applyEffect(Enemy[] E) {
    for (int i = 0; i <= E.length; i++) {
      E[i].setSpeed(E[i].getSpeed()/2);
    }
  }

  public  void applyEffect(Player p) {}

}
