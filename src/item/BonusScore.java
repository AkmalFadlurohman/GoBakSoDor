package item;

import movable.Player;

/**
 * Created by akmalfadlurohman on 4/23/17.
 */

/**
 * BonusScore.
 * Menangani item "Bonus"
 */
public class BonusScore extends Item {
  /**
   * Konstruktor.
   */
  public BonusScore() {
    super("Bonus Score", "movable.Player's score +10", 0, 0);
  }

  /**
   * Menjalankan efek item.
   * @param P Player saat ini
   */
  public void applyEffect(Player P) {
    Player.setScore(Player.getScore() + 10);
  }
}
