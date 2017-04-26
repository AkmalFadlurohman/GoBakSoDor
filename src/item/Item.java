package item;
import game.*;
import movable.*;

import java.awt.image.BufferedImage;


/**
 * Created by akmalfadlurohman on 4/23/17.
 */

/**
 * Item.
 * Menangani objek item
 */
public abstract class Item {

  private String name, effect;
  private Point pos;
  public static final int width = 30;
  public static final int height = 30;

  /**
   * Konstruktor.
   * @param name Nama item
   * @param effect jenis efek item
   * @param posX Absis item
   * @param posY Ordinat item
   */
  public Item(String name, String effect, int posX, int posY) {
    this.name = name;
    this.effect = effect;
    this.pos = new Point(posX, posY);
  }

  /**
   * Getter efek item.
   * @return effect
   */
  public String getEffect() {
    return effect;
  }

  /**
   * Getter nama item.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * Setter nama item.
   * @param name name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Setter efek item.
   * @param effect effect
   */
  public void setEffect(String effect) {
    this.effect = effect;
  }

  /**
   * Getter koordinat item.
   * @return pos
   */
  public Point getPos() {
    return pos;
  }

  /**
   * Setter koordinat item.
   * @param pos pos
   */
  public void setPos(Point pos) {
    this.pos = pos;
  }

  abstract public BufferedImage getImage();

  abstract public void applyEffect(Enemy[] E);

  abstract public  void applyEffect(Player p);
}