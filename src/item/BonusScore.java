package item;

import movable.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

/**
 * Created by akmalfadlurohman on 4/23/17.
 */
public class BonusScore extends Item {
  private BufferedImage image;
  public BonusScore(int posX, int posY) {
    super("Bonus Score", "movable.Player's score +10", posX, posY);
    try {
      image = ImageIO.read(new File("./images/star.png"));
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }

  public BufferedImage getImage() {
    return image;
  }

  public void applyEffect(Enemy[] E) {}

  public void applyEffect(Player P) {
    P.setScore(P.getScore() + 10);
  }
}
