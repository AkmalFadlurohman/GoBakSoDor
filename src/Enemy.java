/**
 * Created by Diki Ardian W (13515092) on 4/23/17.
 */
public class Enemy implements Movable{
  private String name;
  private int width,height;
  private int speed;
  private Point pos;

  public Enemy() {
    name = "";
    width = 0;
    height = 0;
    speed = 0;
    pos.setX(0);
    pos.setY(0);
  }

  public Enemy(String name, int width, int height, int speed, Point pos) {
    this.name = name;
    this.width = width;
    this.height = height;
    this.speed = speed;
    this.pos = pos;
  }

  @Override
  public void move(int code) {
    if (pos.getY() > Game.HEIGHT - height || pos.getY() < 0) {
      speed *= -1;
    }
    pos.setY(pos.getY() + speed);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getWidth() { return width; }

  public void setWidth(int width) { this.width = width; }

  public int getHeight() { return height; }

  public void setHeight(int height) { this.height = height; }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public Point getPos() {
    return pos;
  }

  public void setPos(Point pos) {
    this.pos = pos;
  }
}
