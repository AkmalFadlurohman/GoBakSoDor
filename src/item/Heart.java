package item;

import movable.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

/**
 * Created by akmalfadlurohman on 4/23/17.
 */
public class Heart extends Item {
  private BufferedImage image;

  public Heart(int posX, int posY) {
    super("Heart", "Add additional life to player", posX, posY);
    try {
      image = ImageIO.read(new File("./images/heart.png"));
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }

  public BufferedImage getImage() {
    return image;
  }

  public void applyEffect(Player P) {
    P.setLife(P.getLife() + 1);
  }

  public void applyEffect(Enemy[] E) {}

}
