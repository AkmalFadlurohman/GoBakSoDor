package item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Timer;

import movable.Enemy;
import movable.Player;

/**
 * Created by akmalfadlurohman on 4/23/17.
 */

/**
 * Special.
 * Menangani item "Special"
 */
public class Special extends Item {
  private BufferedImage image;

  /**
   * Konstruktor.
   */
  public Special(int posX, int posY) {
    super("Special", "Slow enemies movement for one second", posX, posY);
    try {
      image = ImageIO.read(new File("./images/snowflakes.png"));
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
  public void applyEffect(Enemy[] e) {
    int[] originalSPeed = new int[e.length];

    for (int i = 0; i < e.length; i++) {
      originalSPeed[i] = e[i].getSpeed();
      e[i].setSpeed(e[i].getSpeed() / 2);
    }
    Timer timer = new Timer(5000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        for (int i = 0; i < e.length; i++) {
          e[i].setSpeed(originalSPeed[i]);
        }
      }
    });
    timer.setRepeats(false);
    timer.start();
  }

  /**
   * Menjalankan efek item.
   * @param p Player
   */
  public  void applyEffect(Player p) {}

}
