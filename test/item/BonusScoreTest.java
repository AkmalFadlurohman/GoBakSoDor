package item;

import org.junit.jupiter.api.Test;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by akmalfadlurohman on 4/26/17.
 */
class BonusScoreTest {
  @Test
  void getEffect() {
    System.out.println("Test getEffect");
    Item I = new BonusScore(10,10);
    assertTrue(Objects.equals("Player's score +10",I.getEffect()));
  }

  @Test
  void getName() {
    System.out.println("Test getName");
    Item I = new BonusScore(10,10);
    assertTrue(Objects.equals("Bonus Score",I.getName()));
  }

  @Test
  void getPos() {
    System.out.println("Test getPos");
    Item I = new BonusScore(10,10);
    assertTrue((I.getPos().getX() == 10) && (I.getPos().getY() == 10));
  }

}