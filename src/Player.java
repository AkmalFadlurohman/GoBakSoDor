/**
 * Created by Diki Ardian W (13515092) on 4/23/17.
 */
public class Player implements Movable{
  private String name;
  private int score;
  private int life;
  private int speed;
  private Point pos;

  public Player() {
    this.name = "";
    this.score = 0;
    this.life = 0;
    this.pos.setX(0);
    this.pos.setY(0);
    this.speed = 10;
  }

  public Player(String name, int score, int life, Point pos, int speed) {
    this.name = name;
    this.score = score;
    this.life = life;
    this.pos = pos;
    this.speed = speed;
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

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  @Override
  public void move(int code) {
    switch (code) {
      case 1 :
        pos.setX(pos.getX()-speed);
        break;
      case 2 :
        pos.setY(pos.getY()+speed);
        break;
      case 3 :
        pos.setX(pos.getX()+speed);
        break;
      case 4 :
        pos.setY(pos.getY()-speed);
        break;
    }
  }
}
