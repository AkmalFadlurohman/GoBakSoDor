import game.Point;
import movable.Player;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Husnulzaki Wibisono Haryadi (13515005) on 4/24/17.
 */
class PlayerTest {
  @org.junit.jupiter.api.Test
  void contain() {
    Player p = new Player();
    p.setPos(2, 3);
    Point pos = new Point(2, 3);
    System.out.println("x : " + p.getPos().getPosX() + " y : " + p.getPos().getPosY
      ());
    assertTrue(p.contain(pos));
  }

  @org.junit.jupiter.api.Test
  void contain1() {
    Player p = new Player();
    p.setPos(2, 3);
    System.out.println("x : " + p.getPos().getPosX() + " y : " + p.getPos().getPosY
      ());
    assertTrue(p.contain(2, 3));
  }
}