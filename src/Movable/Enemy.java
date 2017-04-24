package Movable;

/**
 * Created by Diki Ardian W (13515092) on 4/23/17.
 */
public class Enemy implements Movable{
  private String name;
  private int length;
  private int speed;
  private int posY;

  public Enemy() {
    name = "";
    length = 0;
    speed = 0;
    posY = 0;
  }

  public Enemy(String name, int length, int speed, int posY) {
    this.name = name;
    this.length = length;
    this.speed = speed;
    this.posY = posY;

  }

  @Override
  public void move(int code) {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public int getPosY() {
    return posY;
  }

  public void setPosY(int posY) {
    this.posY = posY;
  }
}
