/**
 * Created by Diki Ardian W (13515092) on 4/23/17.
 */
public class Enemy implements Movable{
  private String name;
  private int length;
  private int speed;

  public Enemy() {

  }

  @Override
  public void move() {

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
}
