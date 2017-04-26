package movable;

import game.Point;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by akmalfadlurohman on 4/26/17.
 */
class PlayerTest {
  @Test
  void getScore() {
    System.out.println("Test getScore");
    Player p = new Player("Player",10,10,5,50);
    p.setScore(100);
    assertTrue(p.getScore() == 100);
  }

  @Test
  void getLife() {
    System.out.println("Test getLife");
    Player p = new Player("Player",10,10,5,50);
    p.setLife(3);
    assertTrue(p.getLife() == 3);
  }

  @Test
  void getName() {
    System.out.println("Test getName");
    Player p = new Player("Player",10,10,5,50);
    assertTrue(Objects.equals("Player", p.getName()));
  }

  @Test
  void getPos() {
    System.out.println("Test getPos");
    Player p = new Player("Player",10,10,5,50);
    assertTrue((p.getPos().getPosX() == 10) && (p.getPos().getPosY() == 10));
  }

  @Test
  void getSpeed() {
    System.out.println("Test getSpeed");
    Player p = new Player("Player",10,10,5,50);
    assertTrue(p.getSpeed() == 5);
  }

  @Test
  void getDiameter() {
    System.out.println("Test getDiameter");
    Player p = new Player("Player",10,10,5,50);
    assertTrue(p.getDiameter() == 50);
  }

  @Test
  void contain() {
    System.out.println("Test contain");
    Player p = new Player();
    p.setPos(2, 3);
    Point pos = new Point(2, 3);
    assertTrue(p.contain(pos));
  }

}