/**
 * Created by Diki Ardian W (13515092) on 4/23/17.
 */
public class Player implements Movable{
  private String name;
  private int score;
  private int life;
  private int posX;
  private int posY;

  public Player() {
  }

  public Player(String name, int score, int life, int posX, int posY) {
    this.name = name;
    this.score = score;
    this.life = life;
    this.posX = posX;
    this.posY = posY;
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

  public int getPosX() {
    return posX;
  }

  public void setPosX(int posX) {
    this.posX = posX;
  }

  public int getPosY() {
    return posY;
  }

  public void setPosY(int posY) {
    this.posY = posY;
  }

  @Override
  public void move() {

  }
}
