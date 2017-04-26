package item;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import movable.Enemy;
import movable.Player;

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
   * @param e Array musuh
   */
  public void applyEffect(Enemy[] e) {}

  /**
   * Menjalankan efek item.
   * @param p Player saat ini
   */
  public void applyEffect(Player p) {
    Player.setScore(Player.getScore() + 10);
  }
}
