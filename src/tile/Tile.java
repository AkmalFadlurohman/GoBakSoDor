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
    this.posX = posX;
    this.posY = posY;
    this.height = height;
    this.width = width;
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

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }
}
