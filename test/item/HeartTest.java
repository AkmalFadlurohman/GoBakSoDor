package item;

import org.junit.jupiter.api.Test;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by akmalfadlurohman on 4/26/17.
 */
class HeartTest {
  @Test
  void getEffect() {
    System.out.println("Test getEffect");
    Item I = new Heart(10,10);
    assertTrue(Objects.equals("Add additional life to player",I.getEffect()));
  }

  @Test
  void getName() {
    System.out.println("Test getName");
    Item I = new Heart(10,10);
    assertTrue(Objects.equals("Heart",I.getName()));
  }

  @Test
  void getPos() {
    System.out.println("Test getPos");
    Item I = new Heart(10,10);
    assertTrue((I.getPos().getPosX() == 10) && (I.getPos().getPosY() == 10));
  }

}