/**
 * Created by Diki Ardian W (13515092) on 4/23/17.
 */
public class Player implements Movable{
  private String name;
  private int score;
  private int life;
  private Point pos;

  public Player() {
    this.name = "";
    this.score = 0;
    this.life = 0;
    this.pos.setX(0);
    this.pos.setY(0);
  }

  public Player(String name, int score, int life, Point pos) {
    this.name = name;
    this.score = score;
    this.life = life;
    this.pos = pos;
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

  @Override
  public void move() {

  }
}
