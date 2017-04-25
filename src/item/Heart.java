package item;

import movable.Player;

/**
 * Created by akmalfadlurohman on 4/23/17.
 */
public class Heart extends Item {
  public Heart() {
    super("item.Heart", "Add additional life to player", 0, 0);
  }

  public void applyEffect(Player P) {
    P.setLife(P.getLife() + 1);
  }
}
