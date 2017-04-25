package movable;

import game.*;

/**
 * Created by Diki Ardian W (13515092) on 4/23/17.
 */
public class Player implements Movable {

  private String name;
  private static int score = 0;
  private static int life = 3;
  private int speed;
  private Point pos;
  private int diameter;

  public Player() {
    this.name = "";
    this.score = 0;
    this.life = 0;
    this.pos = new Point(0, 0);
    this.speed = 10;
    this.diameter = 5;
  }

  public Player(String name, Point pos, int speed, int diameter) {
    this.name = name;
    this.pos = pos;
    this.speed = speed;
    this.diameter = diameter;
  }

  public Player(String name, int x, int y, int speed, int diameter) {
    this.name = name;
    this.pos = new Point(x, y);
    this.speed = speed;
    this.diameter = diameter;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static int getScore() {
    return score;
  }

  public static void setScore(int score) {
    Player.score = score;
  }

  public static int getLife() {
    return life;
  }

  public static void setLife(int life) {
    Player.life = life;
  }

  public Point getPos() {
    return pos;
  }

  public void setPos(Point pos) {
    this.pos = pos;
  }

  public void setPos(int x, int y) {
    this.pos.setX(x);
    this.pos.setY(y);
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public void setDiameter(int diameter) {
    this.diameter = diameter;
  }

  @Override
  public void move(int code) {
    switch (code) {
      case 1:
        if (pos.getX() > 0) {
          pos.setX(pos.getX() - speed);
        }
        break;
      case 2:
        if (pos.getY() + diameter < Game.HEIGHT) {
          pos.setY(pos.getY() + speed);
        }
        break;
      case 3:
        if (pos.getX() + diameter < Game.WIDTH) {
          pos.setX(pos.getX() + speed);
        }
        break;
      case 4:
        if (pos.getY() > 0) {
          pos.setY(pos.getY() - speed);
        }
        break;
    }
  }

  public int getDiameter() {
    return diameter;
  }

  public boolean contain(int x, int y) {
    return pos.getX() <= x && pos.getY() <= y && pos.getX() + diameter >= x &&
      pos.getY() + diameter >= y;
  }

  public boolean contain(Point pos) {
    return this.pos.getX() <= pos.getX() && this.pos.getY() <= pos.getY() &&
      this.pos.getX() + diameter >= pos.getX() && this.pos.getY() + diameter >= pos
      .getY();
  }

  public boolean contain(int x, int y, int width, int heigth) {
    return ((pos.getX() + diameter >= x && pos.getX() <= x + width) &&
      (pos.getY() + diameter >= y && pos.getY() <= y + heigth));
  }

  public boolean contain(Enemy enemy) {
    return ((pos.getX() + diameter >= enemy.getPos().getX() && pos.getX() <= enemy.getPos().getX() + enemy.getWidth()) &&
           (pos.getY() + diameter >= enemy.getPos().getY() && pos.getY() <= enemy.getPos().getY() + enemy.getHeight()));
  }

  public static boolean gameOver() {
    return (life == 0);
  }

}