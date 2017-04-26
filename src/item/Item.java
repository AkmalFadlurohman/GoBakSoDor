package item;

import game.Point;

import java.awt.image.BufferedImage;

import movable.Enemy;
import movable.Player;

/**
 * Created by akmalfadlurohman on 4/23/17.
 */

/**
 * Item.
 * Menangani objek item
 */
public abstract class Item {

  private String name;
  private String effect;
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

  public abstract BufferedImage getImage();

  public abstract void applyEffect(Enemy[] e);

  public abstract void applyEffect(Player p);
}