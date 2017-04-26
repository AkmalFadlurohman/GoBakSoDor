package movable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by akmalfadlurohman on 4/26/17.
 */
class EnemyTest {
  @Test
  void getWidth() {
    System.out.println("Test getWidth");
    Enemy E = new Enemy(100,100,10,5,5,0,5);
    assertTrue(E.getWidth() == 100);
  }

  @Test
  void getHeight() {
    System.out.println("Test getHeight");
    Enemy E = new Enemy(100,100,10,5,5,0,5);
    assertTrue(E.getHeight() == 100);
  }

  @Test
  void getSpeed() {
    System.out.println("Test getSpeed");
    Enemy E = new Enemy(100,100,10,5,5,0,5);
    assertTrue(E.getSpeed() == 10);
  }

  @Test
  void getPos() {
    System.out.println("Test getPos");
    Enemy E = new Enemy(100,100,10,5,5,0,5);
    assertTrue((E.getPos().getPosX() == 5) && (E.getPos().getPosY() == 5));
  }

  @Test
  void getDir() {
    System.out.println("Test getDir");
    Enemy E = new Enemy(100,100, 10,5, 5, 0, 5);
    assertTrue(E.getDir() == 0);
  }

  @Test
  void getDelay() {
    System.out.println("Test getDelay");
    Enemy E = new Enemy(100,100,10,5,5,0,5);
    assertTrue(E.getDelay() == 5);
  }

}