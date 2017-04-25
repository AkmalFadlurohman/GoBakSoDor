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

  public  void applyEffect(Player p) {}

}
