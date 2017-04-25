package item;

import movable.Enemy;

/**
 * Created by akmalfadlurohman on 4/23/17.
 */

/**
 * Special.
 * Menangani item "Special"
 */
public class Special extends Item {
  /**
   * Konstruktor.
   */
  public Special() {
    super("item.Special", "Slow enemies movement for one second", 0, 0);
  }

  /**
   * Menjalankan efek item.
   * @param E Array musuh
   * @param speed Besar perlambatan kecepatan
   */
  public void applyEffect(Enemy[] E, int speed) {
    for (int i = 0; i <= E.length; i++) {
      E[i].setSpeed(E[i].getSpeed() - speed);
    }
  }
}
