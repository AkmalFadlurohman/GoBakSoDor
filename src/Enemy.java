/**
 * Created by Diki Ardian W (13515092) on 4/23/17.
 */
public class Enemy implements Movable{
  private String name;
  private int width,height;
  private int speed;
  private int posX,posY;

  public Enemy() {
    name = "";
    speed = 0;
    posY = 0;
  }

  public Enemy(String name, int width,int height, int speed, int posX, int posY) {
    this.name = name;
    this.width = width;
    this.height = height;
    this.speed = speed;
    this.posX = posX;
    this.posY = posY;
  }

  @Override
  public void move() {
    if (posY > Game.HEIGHT - height || posY < 0) {
      speed *= -1;
    }
    posY += speed;
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

  public int getPosX() { return posX; }

  public void setPosX(int posX) { this.posX = posX; }

  public int getPosY() {
    return posY;
  }

  public void setPosY(int posY) {
    this.posY = posY;
  }
}
