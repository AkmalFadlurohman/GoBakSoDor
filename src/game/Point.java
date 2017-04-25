package game;

/**
 * Created by Diki Ardian W (13515092) on 4/24/17.
 */

/**
 * Point.
 * Kelas tipe data abstrak Point
 */
public class Point {
  private int x;
  private int y;

  /**
   * Konstruktor.
   */
  public Point() {
    x = 0;
    y = 0;
  }

  /**
   * Konstruktor berparameter.
   * @param x Absis
   * @param y Ordinat
   */
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Getter absis.
   * @return Absis
   */
  public int getX() {
    return x;
  }

  /**
   * Setter absis.
   * @param x Absis
   */
  public void setX(int x) {
    this.x = x;
  }

  /**
   * Getter ordinat.
   * @return Ordinat
   */
  public int getY() {
    return y;
  }

  /**
   * Setter ordinat.
   * @param y Ordinat
   */
  public void setY(int y) {
    this.y = y;
  }

  /**
   * Memeriksa apakah objek berada pada titik yang sama dengan p.
   * @param p Point lain
   * @return True apabila objek dan p berada pada titik yang sama
   */
  public boolean isEqual(Point p) {
    return x == p.x && y == p.y;
  }

  /**
   * Memeriksa apakah objek berada pada titik yang sama dengan (x, y).
   * @param x Absis
   * @param y Ordinat
   * @return True apabila objek dan p berada pada titik (x, y)
   */
  public boolean isEqual(int x, int y) {
    return this.x == x && this.y == y;
  }
}
