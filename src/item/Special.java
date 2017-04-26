package item;

import movable.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.Timer;

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
    super("Special", "Slow enemies movement for five second", posX, posY);
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
   * @param E Array musuh
   */
  public void applyEffect(Enemy[] E) {
    int[] originalSPeed = new int[E.length];

    for (int i = 0; i < E.length; i++) {
      originalSPeed[i] = E[i].getSpeed();
      E[i].setSpeed(E[i].getSpeed()/2);
    }
    Timer timer = new Timer(5000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        for (int i=0; i<E.length; i++) {
          E[i].setSpeed(originalSPeed[i]);
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
