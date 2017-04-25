package item;
import game.*;
import movable.*;

import java.awt.image.BufferedImage;


/**
 * Created by akmalfadlurohman on 4/23/17.
 */
public abstract class Item {

  private String name, effect;
  private Point pos;
  public static final int width = 30;
  public static final int height = 30;

  public Item(String name, String effect, int posX, int posY) {
    this.name = name;
    this.effect = effect;
    this.pos = new Point(posX, posY);
  }

  public String getEffect() {
    return effect;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEffect(String effect) {
    this.effect = effect;
  }

  public Point getPos() {
    return pos;
  }

  public void setPos(Point pos) {
    this.pos = pos;
  }

  abstract public BufferedImage getImage();

  abstract public void applyEffect(Enemy[] E);

  abstract public  void applyEffect(Player p);

}