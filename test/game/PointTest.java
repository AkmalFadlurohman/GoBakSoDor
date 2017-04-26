package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by akmalfadlurohman on 4/26/17.
 */
class PointTest {
  @Test
  void getX() {
    System.out.println("Test getX");
    Point p = new Point(10,10);
    assertTrue(p.getPosX() == 10);
  }

  @Test
  void getY() {
    System.out.println("Test getY");
    Point p = new Point(10,10);
    assertTrue(p.getPosY() == 10);
  }

  @Test
  void isEqual() {
    System.out.println("Test isEqual");
    Point p = new Point(0,0);
    assertTrue(p.isEqual(0,0));
  }

}