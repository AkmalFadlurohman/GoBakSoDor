/**
 * Created by Diki Ardian W (13515092) on 4/23/17.
 */
public class Player implements Movable{
  private String name;
  private int score;
  private int life;
  private int posX;
  private int posY;
  private int speed;

  public Player() {
    this.name = "";
    this.score = 0;
    this.life = 0;
    this.posX = 0;
    this.posY = 0;
    this.speed = 0;
  }

  public Player(String name, int score, int life, int posX, int posY, int
    speed) {
    this.name = name;
    this.score = score;
    this.life = life;
    this.posX = posX;
    this.posY = posY;
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
        posX -= speed;
        break;
      case 2 :
        posY += speed;
        break;
      case 3 :
        posX += speed;
        break;
      case 4 :
        posY -= speed;
        break;
    }
  }
}
