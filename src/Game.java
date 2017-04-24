import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Set;
import java.util.TreeSet;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Game extends JPanel implements ActionListener, KeyListener {

  static final int HEIGHT = 600;
  static final int WIDTH = 1280;
  Player player;
  Enemy[] enemyPool;
  int playerPosX;
  int playerPosY;
  int level;
  int startPosX;
  int startPosY;
  int startHeight;
  int startWidth;
  int finishPosX;
  int finishPosY;
  int finishHeight;
  int finishWidth;
  private BufferedImage image;

  public Game(int level) throws FileNotFoundException {

    this.level = level;

    try {
      image = ImageIO.read(new File("./images/GobakSodor.png"));
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }

    String namaFile = "./level/" + Integer.toString(level) + ".txt";
    try {
      FileInputStream fstream = new FileInputStream(namaFile);
      BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
      String strLine;
      strLine = br.readLine();
      startPosX = Integer.parseInt(strLine.substring(10));
      strLine = br.readLine();
      startPosY = Integer.parseInt(strLine.substring(10));
      strLine = br.readLine();
      startHeight = Integer.parseInt(strLine.substring(12));
      strLine = br.readLine();
      startWidth = Integer.parseInt(strLine.substring(11));
      strLine = br.readLine();
      finishPosX = Integer.parseInt(strLine.substring(11));
      strLine = br.readLine();
      finishPosY = Integer.parseInt(strLine.substring(11));
      strLine = br.readLine();
      finishHeight = Integer.parseInt(strLine.substring(13));
      strLine = br.readLine();
      finishWidth = Integer.parseInt(strLine.substring(12));
      strLine = br.readLine();
      int speedPlayer = Integer.parseInt(strLine.substring(12));
      strLine = br.readLine();
      playerPosX = Integer.parseInt(strLine.substring(11));
      strLine = br.readLine();
      playerPosY = Integer.parseInt(strLine.substring(11));
      strLine = br.readLine();
      int diameter = Integer.parseInt(strLine.substring(15));
      strLine = br.readLine();
      int enemyCount = Integer.parseInt(strLine.substring(12));
      enemyPool = new Enemy[enemyCount];
      for (int i = 0; i < enemyCount; i++) {
        strLine = br.readLine();
        strLine = br.readLine();
        int enemyHeight = Integer.parseInt(strLine.substring(12));
        strLine = br.readLine();
        int enemyWidth = Integer.parseInt(strLine.substring(11));
        strLine = br.readLine();
        int enemyPosX = Integer.parseInt(strLine.substring(10));
        strLine = br.readLine();
        int enemyPosY = Integer.parseInt(strLine.substring(10));
        strLine = br.readLine();
        int enemySpeed = Integer.parseInt(strLine.substring(11));
        strLine = br.readLine();
        int delay = Integer.parseInt(strLine.substring(11));
        strLine = br.readLine();
        int dir = Integer.parseInt(strLine.substring(15));

        enemyPool[i] = new Enemy(enemyWidth, enemyHeight, enemySpeed, enemyPosX, enemyPosY, dir, delay);
        new Thread(enemyPool[i]).start();
      }

      player = new Player("jekk", new Point(playerPosX, playerPosY), speedPlayer, diameter);

    } catch (IOException ioe) {
      System.out.println(ioe.getMessage());
    }

    Timer timer = new Timer(10, this);

    timer.start();
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setColor(new Color(52, 152, 219));
    g2d.fillRect(0, 0, 100, HEIGHT);
    g2d.setColor(new Color(231, 76, 60));
    g2d.fillRect(WIDTH - 100, 0, 100, HEIGHT);
    g2d.setColor(new Color(0xFF23D3));
    g2d.fillOval(player.getPos().getX(), player.getPos().getY(), player.getDiameter(), player.getDiameter());
    g2d.setColor(new Color(0x000000));
    g2d.drawRect(0, 0, WIDTH, HEIGHT);
    g2d.drawLine(519, HEIGHT, 519, HEIGHT + 120);
    for (Enemy anEnemyPool : enemyPool) {
      g2d.fillRect(anEnemyPool.getPos().getX(), anEnemyPool.getPos().getY(), anEnemyPool.getWidth(), anEnemyPool.getHeight());
    }
    g2d.drawImage(image, 0, 607, this);
    g2d.setFont(new Font("Ubuntu", Font.PLAIN, 40  ));
    g2d.drawString("Name: " + player.getName() , 530, HEIGHT + 50);
    g2d.drawString("Score: " + player.getScore() , 530, HEIGHT + 90);
    g2d.drawString("Life: " + player.getLife() , 900, HEIGHT + 50);
    g2d.drawString("Level: " + level , 900, HEIGHT + 90);
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    repaint();
    for (Enemy anEnemyPool : enemyPool) {
      if (player.contain(anEnemyPool)) {
        player.setLife(player.getLife() - 1);
        player.setPos(playerPosX, playerPosY);
      }
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
    if (code == KeyEvent.VK_ESCAPE) {
      System.exit(2);
    }
  }

  @Override
  public void keyReleased(KeyEvent keyEvent) {
    pressed.remove(keyEvent.getKeyCode());
  }


}