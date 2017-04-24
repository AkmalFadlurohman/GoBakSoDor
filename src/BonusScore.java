/**
 * Created by akmalfadlurohman on 4/23/17.
 */
public class BonusScore extends Item {
  public BonusScore() {
    super("Bonus Score","Player's score +10",0,0);
  }
  public void applyEffect(Player P) {
    P.setScore(P.getScore()+10);
  }
}
