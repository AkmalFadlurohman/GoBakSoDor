package item;

import movable.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

/**
 * Created by akmalfadlurohman on 4/23/17.
 */

/**
 * Heart.
 * Menangani item "Heart"
 */
public class Heart extends Item {
  private BufferedImage image;

  /**
   * Konstruktor.
   */
  public Heart(int posX, int posY) {
    super("Heart", "Add additional life to player", posX, posY);
    try {
      image = ImageIO.read(new File("./images/heart.png"));
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
   * @param P Player saat ini
   */
  public void applyEffect(Player P) {
    Player.setLife(Player.getLife() + 1);
  }

  /**
   * Menjalankan efek item.
   * @param E Array musuh
   */
  public void applyEffect(Enemy[] E) {}

}
