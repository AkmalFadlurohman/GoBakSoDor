package item;

import movable.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

/**
 * Created by akmalfadlurohman on 4/23/17.
 */

/**
 * BonusScore.
 * Menangani item "Bonus"
 */
public class BonusScore extends Item {
  private BufferedImage image;

  /**
   * Konstruktor.
   */
  public BonusScore(int posX, int posY) {
    super("Bonus Score", "Player's score +10", posX, posY);
    try {
      image = ImageIO.read(new File("./images/star.png"));
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }

  /**
   * Getter gambar item.
   * @return image
   */
  public BufferedImage getImage() {
    return image;
  }

  /**
   * Menjalankan efek item.
   * @param E Array musuh
   */
  public void applyEffect(Enemy[] E) {}

  /**
   * Menjalankan efek item.
   * @param P Player saat ini
   */
  public void applyEffect(Player P) {
    Player.setScore(Player.getScore() + 10);
  }
}
