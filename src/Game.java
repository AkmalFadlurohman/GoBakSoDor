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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Game extends JPanel implements ActionListener, MouseListener, KeyListener {

  static final int HEIGHT = 720;
  static final int WIDTH = 1280;
  Point playerInitPos;

  Player player;

  int speedPlayer = 15;
  int radiusPlayer = 50;
  Enemy[] enemyPool;

  public Game(int enemyCount) {
    JFrame frame = new JFrame("DorSoBakGo");
    Timer timer = new Timer(10, this);

    playerInitPos = new Point(0, 0);
    player = new Player("jekk", 0, 3, playerInitPos, speedPlayer, radiusPlayer);

    JLabel playerName = new JLabel(" Name : " + player.getName()+" ");
    JLabel playerLife = new JLabel(" Life : " + player.getLife()+" ");
    JLabel playerScore = new JLabel("Score : " + player.getScore()+" ");
    playerName.setFont(playerName.getFont().deriveFont(36.0f));
    playerLife.setFont(playerLife.getFont().deriveFont(36.0f));
    playerScore.setFont(playerScore.getFont().deriveFont(36.0f));
    add(playerName);
    add(playerLife);
    add(playerScore);

    frame.add(this);
    frame.setSize(WIDTH, HEIGHT);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.addKeyListener(this);
    frame.setResizable(false);

    enemyPool = new Enemy[enemyCount];
    int enemyPosX = HEIGHT / 2;
    int enemyPosY = HEIGHT / 2 - 30;
    int enemySpeed = 10;
    for (int i = 0; i < enemyCount; i++) {
      enemyPool[i] = new Enemy("Enemy" + i, 30, 100, enemySpeed, new Point(enemyPosX, enemyPosY));
      enemyPosX += 200;
      enemyPosY += 50;
      enemySpeed += 2;
    }
    timer.start();

//    WindowListener exitListener = new WindowAdapter() {
//
//      @Override
//      public void windowClosing(WindowEvent e) {
//        if (Player.) {
//          System.exit(0);
//        }
//      }
//    };
//    frame.addWindowListener(exitListener);

  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setColor(new Color(52, 152, 219));
    g2d.fillRect(0, 0, 100, HEIGHT);
    g2d.setColor(new Color(231, 76, 60));
    g2d.fillRect(WIDTH - 100, 0, 100, HEIGHT);
    g2d.setColor(new Color(0));
    g2d.fillOval(player.getPos().getX(), player.getPos().getY(), player.getRadius(), player.getRadius());
    for (Enemy anEnemyPool : enemyPool) {
      g2d.fillRect(anEnemyPool.getPos().getX(), anEnemyPool.getPos().getY(), anEnemyPool.getWidth(), anEnemyPool.getHeight());
    }
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    repaint();
    for (Enemy anEnemyPool : enemyPool) {
      anEnemyPool.move(0);
    }
  }

  @Override
  public void keyTyped(KeyEvent keyEvent) {

  }

  Set<Integer> pressed = new TreeSet<>();

  @Override
  public void keyPressed(KeyEvent keyEvent) {
    int code = keyEvent.getKeyCode();
    pressed.add(code);

    if (pressed.size() > 1) {
      Integer[] array = pressed.toArray(new Integer[]{});
      if ((array[0] == KeyEvent.VK_LEFT) && (array[1] == KeyEvent.VK_DOWN)) {
        player.move(1);
        player.move(2);
      } else if (array[0] == KeyEvent.VK_LEFT && array[1] == KeyEvent.VK_UP) {
        player.move(4);
        player.move(1);
      } else if (array[0] == KeyEvent.VK_UP && array[1] == KeyEvent.VK_RIGHT) {
        player.move(3);
        player.move(4);
      } else if (array[0] == KeyEvent.VK_RIGHT && array[1] == KeyEvent.VK_DOWN) {
        player.move(2);
        player.move(3);
      }
    } else {
      if (code == KeyEvent.VK_LEFT) {
        player.move(1);
      } else if (code == KeyEvent.VK_DOWN) {
        player.move(2);
      } else if (code == KeyEvent.VK_RIGHT) {
        player.move(3);
      } else if (code == KeyEvent.VK_UP) {
        player.move(4);
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