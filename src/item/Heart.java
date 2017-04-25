package item;

import movable.Player;

/**
 * Created by akmalfadlurohman on 4/23/17.
 */

/**
 * Heart.
 * Menangani item "Heart"
 */
public class Heart extends Item {
  /**
   * Konstruktor.
   */
  public Heart() {
    super("item.Heart", "Add additional life to player", 0, 0);
  }

  /**
   * Menjalankan efek item.
   * @param P Player saat ini
   */
  public void applyEffect(Player P) {
    Player.setLife(Player.getLife() + 1);
  }
}
