package item;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by akmalfadlurohman on 4/26/17.
 */

import org.junit.jupiter.api.Test;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by akmalfadlurohman on 4/26/17.
 */
class SpecialTest {
  @Test
  void getEffect() {
    System.out.println("Test getEffect");
    Item I = new Special(10,10);
    assertTrue(Objects.equals("Slow enemies movement for five second",I.getEffect()));
  }

  @Test
  void getName() {
    System.out.println("Test getName");
    Item I = new Special(10,10);
    assertTrue(Objects.equals("Special",I.getName()));
  }

  @Test
  void getPos() {
    System.out.println("Test getPos");
    Item I = new Special(10,10);
    assertTrue((I.getPos().getX() == 10) && (I.getPos().getY() == 10));
  }

}