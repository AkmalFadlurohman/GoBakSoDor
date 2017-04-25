package item;

/**
 * Created by akmalfadlurohman on 4/23/17.
 */

/**
 * Item.
 * Menangani objek item
 */
public abstract class Item {

  int locX, locY;
  private String name, effect;

  /**
   * Konstruktor.
   * @param name Nama item
   * @param effect jenis efek item
   * @param x Absis item
   * @param y Ordinat item
   */
  public Item(String name, String effect, int x, int y) {
    this.name = name;
    this.effect = effect;
    locX = x;
    locY = y;
  }

  /**
   * Getter efek item.
   * @return effect
   */
  public String getEffect() {
    return effect;
  }

  /**
   * Setter efek item.
   * @param effect effect
   */
  public void setEffect(String effect) {
    this.effect = effect;
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
   * Getter lokasi absis item.
   * @return locX
   */
  public int getLocX() {
    return locX;
  }

  /**
   * Setter lokasi absis item.
   * @param locX locX
   */
  public void setLocX(int locX) {
    this.locX = locX;
  }

  /**
   * Getter lokasi ordinat item.
   * @return locY
   */
  public int getLocY() {
    return locY;
  }

  /**
   * Setter lokasi ordinat item.
   * @param locY locY
   */
  public void setLocY(int locY) {
    this.locY = locY;
  }
}