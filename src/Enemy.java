/**
 * Created by Diki Ardian W (13515092) on 4/23/17.
 */
public class Enemy implements Movable, Runnable {

  private int width, height;
  private int speed;
  private Point pos;
  private int dir;

  public Enemy() {
    width = 0;
    height = 0;
    speed = 0;
    pos = new Point();
    dir = 0;
  }

  public Enemy(int width, int height, int speed, int posX, int posY, int dir) {
    this.width = width;
    this.height = height;
    this.speed = speed;
    this.pos = new Point(posX, posY);
    this.dir = dir;
  }

  public void run() {
    while (true) {
      move(dir);
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void move(int code) {
    if (code == 0) {
      if (pos.getY() > Game.HEIGHT - height || pos.getY() < 0) {
        speed *= -1;
      }
      pos.setY(pos.getY() + speed);
    } else if (code == 1) {
      if (pos.getX() > Game.WIDTH - width || pos.getX() < 0) {
        speed *= -1;
      }
      pos.setX(pos.getX() + speed);
    }
  }


  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

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
