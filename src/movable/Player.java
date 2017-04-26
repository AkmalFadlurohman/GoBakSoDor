package movable;

import game.Game;
import game.Point;
import item.Item;

/**
 * Created by Diki Ardian W (13515092) on 4/23/17.
 */

/**
 * Player.
 * Menangani kelas player yang dimainkan pemain
 */
public class Player implements Movable {

  private static int score = 0;
  private static int life = 3;
  private static String name;
  private int speed;
  private Point pos;
  private int diameter;

  /**
   * Konstruktor.
   */
  public Player() {
    name = "";
    score = 0;
    life = 0;
    this.pos = new Point(0, 0);
    this.speed = 10;
    this.diameter = 5;
  }

  /**
   * Konstruktor berparameter.
   * @param name Nama pemain
   * @param pos Koordinat
   * @param speed Kecepatan gerak
   * @param diameter Diameter player
   */
  public Player(String name, Point pos, int speed, int diameter) {
    Player.name = name;
    this.pos = pos;
    this.speed = speed / 2;
    this.diameter = diameter;
  }

  /**
   * Konstruktor berparameter.
   * @param name Nama pemain
   * @param x Posisi absis
   * @param y Posisi ordinat
   * @param speed Kecepatan gerak
   * @param diameter Diameter player
   */
  public Player(String name, int x, int y, int speed, int diameter) {
    Player.name = name;
    this.pos = new Point(x, y);
    this.speed = speed;
    this.diameter = diameter;
  }

  /**
   * Konstruktor berparameter.
   * @param name Nama player
   */
  public Player(String name) {
    Player.name = name;
    this.pos = new Point();
    this.speed = 0;
    this.diameter = 0;
  }

  /**
   * Getter skor pemain.
   * @return score
   */
  public static int getScore() {
    return score;
  }

  /**
   * Setter skor pemain.
   * @param score Skor pemain
   */
  public static void setScore(int score) {
    Player.score = score;
  }

  /**
   * Getter life point.
   * @return life
   */
  public static int getLife() {
    return life;
  }

  /**
   * Setter life point.
   * @param life life point
   */
  public static void setLife(int life) {
    Player.life = life;
  }

  /**
   * Memeriksa apakah player telah kalah.
   * @return True apabila life point player == 0
   */
  public static boolean gameOver() {
    return (life == 0);
  }

  /**
   * Getter nama pemain.
   * @return name
   */
  public static String getName() {
    return name;
  }

  /**
   * Setter nama pemain.
   * @param name name
   */
  public static void setName(String name) {
    Player.name = name;
  }

  /**
   * Getter posisi player.
   * @return pos
   */
  public Point getPos() {
    return pos;
  }

  /**
   * Setter posisi player.
   * @param pos pos
   */
  public void setPos(Point pos) {
    this.pos = pos;
  }

  /**
   * Setter posisi player.
   * @param x Posisi absis
   * @param y Posisi ordinat
   */
  public void setPos(int x, int y) {
    this.pos.setPosX(x);
    this.pos.setPosY(y);
  }

  /**
   * Getter kecepatan gerak.
   * @return speed
   */
  public int getSpeed() {
    return speed;
  }

  /**
   * Setter kecepatan gerak.
   * @param speed speed
   */
  public void setSpeed(int speed) {
    this.speed = speed;
  }

  /**
   * Mengatur arah gerak player.
   * @param code Kode arah gerak
   */
  @Override
  public void move(int code) {
    switch (code) {
      case 1:
        if (pos.getPosX() > 0) {
          pos.setPosX(pos.getPosX() - speed);
        }
        break;
      case 2:
        if (pos.getPosY() + diameter < Game.HEIGHT) {
          pos.setPosY(pos.getPosY() + speed);
        }
        break;
      case 3:
        if (pos.getPosX() + diameter < Game.WIDTH) {
          pos.setPosX(pos.getPosX() + speed);
        }
        break;
      case 4:
        if (pos.getPosY() > 0) {
          pos.setPosY(pos.getPosY() - speed);
        }
        break;
      default:
        break;
    }
  }

  /**
   * Getter diameter player.
   * @return diameter
   */
  public int getDiameter() {
    return diameter;
  }

  /**
   * Setter diameter player.
   * @param diameter diameter
   */
  public void setDiameter(int diameter) {
    this.diameter = diameter;
  }

  /**
   * Memeriksa apakah player bersinggungan dengan titik (x, y).
   * @param x Posisi absis
   * @param y Posisi ordinat
   * @return True apabila player bersinggungan dengan (x, y)
   */
  public boolean contain(int x, int y) {
    return pos.getPosX() <= x && pos.getPosY() <= y && pos.getPosX() + diameter >= x
      && pos.getPosY() + diameter >= y;
  }

  /**
   * Memeriksa apakah player bersinggungan dengan titik pos.
   * @param pos Koordinat
   * @return True apabila player bersinggungan dengan titik pos
   */
  public boolean contain(Point pos) {
    return this.pos.getPosX() <= pos.getPosX() && this.pos.getPosY() <= pos.getPosY()
      && this.pos.getPosX() + diameter >= pos.getPosX() && this.pos.getPosY() + diameter
      >= pos.getPosY();
  }

  /**
   * Memeriksa apakah player bersinggungan dengan objek berdimensi.
   * @param x Absis anchor objek
   * @param y Ordinat anchor objek
   * @param width lebar objek
   * @param heigth panjang objek
   * @return True apabila player bersinggungan dengan objek
   */
  public boolean contain(int x, int y, int width, int heigth) {
    return ((pos.getPosX() + diameter >= x && pos.getPosX() <= x + width)
      && (pos.getPosY() + diameter >= y && pos.getPosY() <= y + heigth));
  }

  /**
   * Memeriksa apakah player bersinggungan dengan enemy tertentu.
   * @param enemy Enemy
   * @return True apabila player bersinggungan dengan enemy
   */
  public boolean contain(Enemy enemy) {
    return ((pos.getPosX() + diameter >= enemy.getPos().getPosX() && pos.getPosX()
      <= enemy.getPos().getPosX() + enemy.getWidth()) && (pos.getPosY() + diameter
      >= enemy.getPos().getPosY() && pos.getPosY() <= enemy.getPos().getPosY()
      + enemy.getHeight()));
  }

  /**
   * Memeriksa apakah player bersinggungan dengan item tertentu.
   * @param item item
   * @return True apabila player bersinggungan dengan item
   */
  public boolean contain(Item item) {
    return ((pos.getPosX() + diameter >= item.getPos().getPosX() && pos.getPosX()
      <= item.getPos().getPosX() + Item.width) && (pos.getPosY() + diameter
      >= item.getPos().getPosY() && pos.getPosY() <= item.getPos().getPosY() + Item.height));
  }
}