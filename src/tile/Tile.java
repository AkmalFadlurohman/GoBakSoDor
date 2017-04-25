package tile;

/**
 * Created by Diki Ardian W (13515092) on 4/25/17.
 */

/**
 * Tile.
 * Menangani zona khusus pada arena
 */
public class Tile {

  private int posX;
  private int posY;
  private int height;
  private int width;

  /**
   * Konstruktor.
   */
  public Tile() {
    posX = 0;
    posY = 0;
    height = 0;
    width = 0;
  }

  /**
   * Konstruktor berparameter.
   * @param posX Posisi absis
   * @param posY Posisi ordinat
   * @param height panjang zona
   * @param width lebar zona
   */
  public Tile(int posX, int posY, int height, int width) {
    this.posX = posX;
    this.posY = posY;
    this.height = height;
    this.width = width;
  }

  /**
   * Getter posisi absis.
   * @return posX
   */
  public int getPosX() {
    return posX;
  }

  /**
   * Setter posisi absis.
   * @param posX posX
   */
  public void setPosX(int posX) {
    this.posX = posX;
  }

  /**
   * Getter posisi ordinat.
   * @return posY
   */
  public int getPosY() {
    return posY;
  }

  /**
   * Setter posisi ordinat.
   * @param posY posY
   */
  public void setPosY(int posY) {
    this.posY = posY;
  }

  /**
   * Getter panjang zona.
   * @return height
   */
  public int getHeight() {
    return height;
  }

  /**
   * Setter panjang zona.
   * @param height height
   */
  public void setHeight(int height) {
    this.height = height;
  }

  /**
   * Getter lebar zona.
   * @return width
   */
  public int getWidth() {
    return width;
  }

  /**
   * Setter lebar zona.
   * @param width width
   */
  public void setWidth(int width) {
    this.width = width;
  }
}
