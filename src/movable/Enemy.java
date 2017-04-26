package movable;

import game.Game;
import game.Point;

/**
 * Created by Diki Ardian W (13515092) on 4/23/17.
 */

/**
 * Enemy.
 * Menangani kelas musuh
 */
public class Enemy implements Movable, Runnable {

  private int width;
  private int height;
  private int speed;
  private Point pos;
  private int dir;
  private int delay;

  /**
   * Konstruktor.
   */
  public Enemy() {
    width = 0;
    height = 0;
    speed = 0;
    pos = new Point();
    dir = 0;
  }

  /**
   * Konstruktor berparameter.
   * @param width Lebar badan
   * @param height Panjang badan
   * @param speed Kecepatan gerak
   * @param posX Posisi absis
   * @param posY Posisi ordinat
   * @param dir Arah gerak
   * @param delay Delay timer
   */
  public Enemy(int width, int height, int speed, int posX, int posY, int dir, int delay) {
    this.width = width;
    this.height = height;
    this.speed = speed;
    this.pos = new Point(posX, posY);
    this.dir = dir;
    this.delay = delay;
  }

  /**
   * Menjalankan thread objek.
   */
  public void run() {
    while (true) {
      move(dir);
      try {
        Thread.sleep(delay);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Mengatur pergerakan objek.
   * @param code Tidak memiliki efek apapun
   */
  @Override
  public void move(int code) {
    if (code == 0) {
      if (pos.getPosY() > Game.HEIGHT - height || pos.getPosY() < 0) {
        speed *= -1;
      }
      pos.setPosY(pos.getPosY() + speed);
    } else if (code == 1) {
      if (pos.getPosX() > Game.WIDTH - width || pos.getPosX() < 0) {
        speed *= -1;
      }
      pos.setPosX(pos.getPosX() + speed);
    }
  }

  /**
   * Getter lebar badan.
   * @return width
   */
  public int getWidth() {
    return width;
  }

  /**
   * Setter lebar badan.
   * @param width width
   */
  public void setWidth(int width) {
    this.width = width;
  }

  /**
   * Getter panjang badan.
   * @return height
   */
  public int getHeight() {
    return height;
  }

  /**
   * Setter panjang badan.
   * @param height height
   */
  public void setHeight(int height) {
    this.height = height;
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
   * Getter koordinat posisi.
   * @return pos
   */
  public Point getPos() {
    return pos;
  }

  /**
   * Setter koordinat posisi.
   * @param pos pos
   */
  public void setPos(Point pos) {
    this.pos = pos;
  }

  /**
   * Getter arah gerak.
   * @return dir
   */
  public int getDir() {
    return dir;
  }

  /**
   * Stter arah gerak.
   * @param dir dir
   */
  public void setDir(int dir) {
    this.dir = dir;
  }

  /**
   * Getter delay timer.
   * @return delay
   */
  public int getDelay() {
    return delay;
  }

  /**
   * Setter delay timer.
   * @param delay delay
   */
  public void setDelay(int delay) {
    this.delay = delay;
  }

  /**
   * Setter posisi absis.
   * @param posX Posisi absis
   */
  public void setPosX(int posX) {
    pos.setPosX(posX);
  }

  /**
   * Setter posisi ordinat.
   * @param posY Posisi ordinat
   */
  public void setPosY(int posY) {
    pos.setPosY(posY);
  }

}
