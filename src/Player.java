/**
 * Created by Diki Ardian W (13515092) on 4/23/17.
 */
public class Player implements Movable {

  private String name;
  private int score;
  private int life;
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

  public Player(String name, int score, int life, Point pos, int speed, int diameter) {
    this.name = name;
    this.score = score;
    this.life = life;
    this.pos = pos;
    this.speed = speed;
    this.diameter = diameter;
  }

  public Player(String name, int score, int life, int x, int y, int speed, int diameter) {
    this.name = name;
    this.score = score;
    this.life = life;
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

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public int getLife() {
    return life;
  }

  public void setLife(int life) {
    this.life = life;
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

  public boolean contain(int x, int y) {
    return pos.getX() == x && pos.getY() == y;
  }
  public boolean contain(Point pos) {
    return this.pos.getX() == pos.getX() && this.pos.getY() == pos.getY();
  }
}
