/**
 * Created by akmalfadlurohman on 4/23/17.
 */
public abstract class Item {

  private String name,effect;
  int locX,locY;

  public Item(String name,String effect,int x,int y) {
    this.name = name;
    this.effect = effect;
    locX = x; locY = y;
  }
  public String getEffect() {
    return effect;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEffect(String effect) {
    this.effect = effect;
  }

  public int getLocX() {
    return locX;
  }

  public void setLocX(int locX) {
    this.locX = locX;
  }

  public int getLocY() {
    return locY;
  }

  public void setLocY(int locY) {
    this.locY = locY;
  }
}