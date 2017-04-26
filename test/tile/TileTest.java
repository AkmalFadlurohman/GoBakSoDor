package tile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by akmalfadlurohman on 4/26/17.
 */
class TileTest {
  @Test
  void getPosX() {
    System.out.println("Test getPosX");
    Tile t = new Tile(10,10,100,100);
    assertTrue(t.getPosX() == 10);
  }

  @Test
  void getPosY() {
    System.out.println("Test getPosY");
    Tile t = new Tile(10,10,100,100);
    assertTrue(t.getPosY() == 10);
  }

  @Test
  void getHeight() {
    System.out.println("Test getHeight");
    Tile t = new Tile(10,10,100,100);
    assertTrue(t.getHeight() == 100);
  }

  @Test
  void getWidth() {
    System.out.println("Test getWidth");
    Tile t = new Tile(10,10,100,100);
    assertTrue(t.getWidth() == 100);
  }

}