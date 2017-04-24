package Item;

import Movable.Enemy;

/**
 * Created by akmalfadlurohman on 4/23/17.
 */
public class Special extends Item {
  public Special() {
    super("Item.Special","Slow enemies movement for one second",0,0);
  }
  public void applyEffect(Enemy[] E, int speed) {
    for (int i=0;i<=E.length;i++) {
      E[i].setSpeed(E[i].getSpeed()-speed);
    }
  }
}
