package movable;

import game.Game;
import game.Point;

/**
 * Created by Diki Ardian W (13515092) on 4/23/17.
 */
public class Player implements Movable {

  private static int score = 0;
  private static int life = 3;
  private static String name;
  private int speed;
  private Point pos;
  private int diameter;

  public Player() {
    name = "";
    score = 0;
    life = 0;
    this.pos = new Point(0, 0);
    this.speed = 10;
    this.diameter = 5;
  }

  public Player(String name, Point pos, int speed, int diameter) {
    Player.name = name;
    this.pos = pos;
    this.speed = speed/2;
    this.diameter = diameter;
  }

  public Player(String name, int x, int y, int speed, int diameter) {
    Player.name = name;
    this.pos = new Point(x, y);
    this.speed = speed;
    this.diameter = diameter;
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

  public static boolean gameOver() {
    return (life == 0);
  }

  public static String getName() {
    return name;
  }

  public static void setName(String _name) {
    name = _name;
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

  public void setDiameter(int diameter) {
    this.diameter = diameter;
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

}