package game;

/**
 * Created by Diki Ardian W (13515092) on 4/24/17.
 */

/**
 * Point.
 * Kelas tipe data abstrak Point
 */
public class Point {
  private int posX;
  private int posY;

  /**
   * Konstruktor.
   */
  public Point() {
    posX = 0;
    posY = 0;
  }

  /**
   * Konstruktor berparameter.
   * @param x Absis
   * @param y Ordinat
   */
  public Point(int x, int y) {
    this.posX = x;
    this.posY = y;
  }

  /**
   * Getter absis.
   * @return Absis
   */
  public int getPosX() {
    return posX;
  }

  /**
   * Setter absis.
   * @param posX Absis
   */
  public void setPosX(int posX) {
    this.posX = posX;
  }

  /**
   * Getter ordinat.
   * @return Ordinat
   */
  public int getPosY() {
    return posY;
  }

  /**
   * Setter ordinat.
   * @param posY Ordinat
   */
  public void setPosY(int posY) {
    this.posY = posY;
  }

  /**
   * Memeriksa apakah objek berada pada titik yang sama dengan p.
   * @param p Point lain
   * @return True apabila objek dan p berada pada titik yang sama
   */
  public boolean isEqual(Point p) {
    return posX == p.posX && posY == p.posY;
  }

  /**
   * Memeriksa apakah objek berada pada titik yang sama dengan (posX, posY).
   * @param x Absis
   * @param y Ordinat
   * @return True apabila objek dan p berada pada titik (posX, posY)
   */
  public boolean isEqual(int x, int y) {
    return this.posX == x && this.posY == y;
  }
}
