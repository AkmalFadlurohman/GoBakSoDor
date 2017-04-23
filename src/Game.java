import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Game extends JPanel implements ActionListener, MouseListener, KeyListener {

  final int HEIGHT = 600;
  final int WIDTH = 800;
  int x = 0;
  int y = 0;

  int r = 50;
  int e1 = HEIGHT/2;
  int speedEnemy = 10;
  int speedPlayer = 15;

  public Game() {
    JFrame frame = new JFrame("DorSoBakGo");
    Timer timer = new Timer(10, this);

    frame.add(this);
    frame.setSize(WIDTH, HEIGHT);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.addKeyListener(this);

    timer.start();
  }

  private void moveBall(int code) {
    if (code == 1) x -= speedPlayer;
    else if (code == 2) y += speedPlayer;
    else if (code == 3) x += speedPlayer;
    else if (code == 4) y -= speedPlayer;
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                         RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setColor(new Color(52, 152, 219));
    g2d.fillRect(0,0,100, HEIGHT);
    g2d.setColor(new Color(231, 76, 60));
    g2d.fillRect(WIDTH - 100,0,100, HEIGHT);
    g2d.setColor(new Color(0));
    g2d.fillOval(x, y, r, r);
    g2d.fillRect(HEIGHT/2, e1, 30, 100);
  }

  public static void main(String[] args) {
    Game game = new Game();
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    repaint();
    moveEnemy();
  }

  private void moveEnemy() {
    if (e1 > HEIGHT-r || e1 < 0) {
      speedEnemy *= -1;
    }
    e1 += speedEnemy;
  }

  @Override
  public void keyTyped(KeyEvent keyEvent) {

  }

  Set<Integer> pressed = new TreeSet<>();

  @Override
  public void keyPressed(KeyEvent keyEvent) {
    int code = keyEvent.getKeyCode();
    pressed.add(code);

    if (pressed.size() > 1 ) {
      Integer [] array = pressed.toArray(new Integer[] {});
      if (array[0] == keyEvent.VK_LEFT && array[1] == keyEvent.VK_DOWN) {
        moveBall(1);
        moveBall(2);
      } else if (array[0] == keyEvent.VK_LEFT && array[1] == keyEvent.VK_UP) {
        moveBall(4);
        moveBall(1);
      } else if (array[0] == keyEvent.VK_UP && array[1] == keyEvent.VK_RIGHT) {
        moveBall(3);
        moveBall(4);
      } else if (array[0] == keyEvent.VK_RIGHT && array[1] == keyEvent.VK_DOWN) {
        moveBall(2);
        moveBall(3);
      }
    } else {
      if (code == keyEvent.VK_LEFT) {
        moveBall(1);
      } else if (code == keyEvent.VK_DOWN) {
        moveBall(2);
      } else if (code == keyEvent.VK_RIGHT) {
        moveBall(3);
      } else if (code == keyEvent.VK_UP) {
        moveBall(4);
      }
    }
  }

  @Override
  public void keyReleased(KeyEvent keyEvent) {
    pressed.remove(keyEvent.getKeyCode());
  }

  @Override
  public void mouseClicked(MouseEvent mouseEvent) {

  }

  @Override
  public void mousePressed(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseReleased(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseEntered(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseExited(MouseEvent mouseEvent) {

  }

}