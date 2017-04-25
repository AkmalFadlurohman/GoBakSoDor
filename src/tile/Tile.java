package tile;

/**
 * Created by Diki Ardian W (13515092) on 4/25/17.
 */
public class Tile {
  private int posX;
  private int posY;
  private int height;
  private int width;

  public Tile() {
    posX = 0;
    posY = 0;
    height = 0;
    width = 0;
  }

  public Tile(int posX, int posY, int height, int width) {
    posX = posX;
    posY = posY;
    height = height;
    width = width;
  }

  public int getposX() {
    return posX;
  }

  public void setposX(int posX) {
    posX = posX;
  }

  public int getposY() {
    return posY;
  }

  public void setposY(int posY) {
    posY = posY;
  }

  public int getheight() {
    return height;
  }

  public void setheight(int height) {
    height = height;
  }

  public int getwidth() {
    return width;
  }

  public void setwidth(int width) {
    width = width;
  }
}
