package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;

import movable.Enemy;
import movable.Player;
import tile.Tile;


@SuppressWarnings("serial")
/**
 * Game.
 * Menangani transisi level, kontrol pemain, dan tampilan permainan
 */
public class Game extends JPanel {
  public static final int HEIGHT = 600;
  public static final int WIDTH = 1280;
  private static final String PRESSED = "pressed";
  private static final String RELEASED = "released";
  static int level = 0;
  Player player;
  Enemy[] enemyPool;
  int playerPosX;
  int playerPosY;
  Tile start = new Tile();
  Tile finish = new Tile();
  private Map<Dir, Boolean> dirMap = new EnumMap<>(Dir.class);
  private Timer animationTimer = new Timer(10, new AnimationListener());
  private BufferedImage imageLogo, imageBall;

  /**
   * Konstruktor.
   * @throws FileNotFoundException Apabila file target yang akan dibaca tidak
   * ditemukan
   */
  Game() throws FileNotFoundException {

    try {
      imageLogo = ImageIO.read(new File("./images/GobakSodor.jpg"));
      imageBall = ImageIO.read(new File("./images/Ball.png"));
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }

    String namaFile = "./level/0.txt";
    try {

      FileInputStream fstream = new FileInputStream(namaFile);
      BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
      String strLine;
      strLine = br.readLine();
      start.setPosX(Integer.parseInt(strLine.substring(10)));
      strLine = br.readLine();
      start.setPosY(Integer.parseInt(strLine.substring(10)));
      strLine = br.readLine();
      start.setHeight(Integer.parseInt(strLine.substring(12)));
      strLine = br.readLine();
      start.setWidth(Integer.parseInt(strLine.substring(11)));
      strLine = br.readLine();
      finish.setPosX(Integer.parseInt(strLine.substring(11)));
      strLine = br.readLine();
      finish.setPosY(Integer.parseInt(strLine.substring(11)));
      strLine = br.readLine();
      finish.setHeight(Integer.parseInt(strLine.substring(13)));
      strLine = br.readLine();
      finish.setWidth(Integer.parseInt(strLine.substring(12)));
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

        enemyPool[i] = new Enemy(enemyWidth, enemyHeight, enemySpeed,
          enemyPosX, enemyPosY, dir, delay);
        new Thread(enemyPool[i]).start();
      }
      player = new Player(Player.getName(), new Point(playerPosX, playerPosY), speedPlayer, diameter);
      strLine = br.readLine();
    } catch (IOException ioe) {
      System.out.println(ioe.getMessage());
    }
    for (Dir dir : Dir.values()) {
      dirMap.put(dir, Boolean.FALSE);
    }
    setKeyBindings();
    animationTimer.start();
  }

  /**
   * Getter level.
   * @return level permainan saat ini
   */
  public static int getLevel() {
    return level;
  }

  /**
   * Setter level.
   * @param level level permainan saat ini
   */
  static void setLevel(int level) {
    Game.level = level;
  }

  /**
   * Menggambar visual arena permainan.
   * @param g Kelas Graphics yang dipakai
   */
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints
      .VALUE_ANTIALIAS_ON);
    g2d.setColor(new Color(52, 152, 219));
    g2d.fillRect(start.getPosX(), start.getPosY(), start.getWidth(), start
      .getHeight());
    g2d.setColor(new Color(231, 76, 60));
    g2d.fillRect(finish.getPosX(), finish.getPosY(), finish.getWidth(),
      finish.getHeight());
    g2d.setColor(new Color(0xFF23D3));
    g2d.fillOval(player.getPos().getX(), player.getPos().getY(), player
      .getDiameter(), player.getDiameter());
    g2d.drawImage(imageBall, player.getPos().getX(), player.getPos().getY(),
      player.getDiameter(), player.getDiameter(), this);
    g2d.setColor(new Color(0x000000));
    g2d.drawRect(0, 0, WIDTH, HEIGHT);
    g2d.drawLine(519, HEIGHT, 519, HEIGHT + 120);
    for (Enemy anEnemyPool : enemyPool) {
      g2d.fillRect(anEnemyPool.getPos().getX(), anEnemyPool.getPos().getY(),
        anEnemyPool.getWidth(), anEnemyPool.getHeight());
    }
    g2d.drawImage(imageLogo, 0, 607, this);
    g2d.setFont(new Font("Ubuntu", Font.PLAIN, 40));
    g2d.drawString("Name: " + Player.getName(), 530, HEIGHT + 50);
    g2d.drawString("Life: " + Player.getLife(), 900, HEIGHT + 50);
  }

  /**
   * Mengatur deteksi input pemain.
   */
  private void setKeyBindings() {
    InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
    ActionMap actionMap = getActionMap();

    for (Dir dir : Dir.values()) {
      KeyStroke keyPressed = KeyStroke.getKeyStroke(dir.getKeyCode(), 0, false);
      KeyStroke keyReleased = KeyStroke.getKeyStroke(dir.getKeyCode(), 0, true);

      inputMap.put(keyPressed, dir.toString() + PRESSED);
      inputMap.put(keyReleased, dir.toString() + RELEASED);

      actionMap.put(dir.toString() + PRESSED, new DirAction(dir, PRESSED));
      actionMap.put(dir.toString() + RELEASED, new DirAction(dir, RELEASED));
    }
  }

  /**
   * Menghentikan system timer.
   */
  void stopTimer() {
    animationTimer.stop();
  }

  /**
   * Enumerasi arah gerak player.
   */
  enum Dir {


    LEFT("Left", KeyEvent.VK_LEFT, -1, 0), RIGHT("Right", KeyEvent.VK_RIGHT,
      1, 0), UP("Up", KeyEvent.VK_UP, 0, -1), DOWN("Down", KeyEvent.VK_DOWN,
      0, 1);
    private String name;
    private int keyCode;
    private int deltaX;
    private int deltaY;

    Dir(String name, int keyCode, int deltaX, int deltaY) {
      this.name = name;
      this.keyCode = keyCode;
      this.deltaX = deltaX;
      this.deltaY = deltaY;
    }

    public String getName() {
      return name;
    }

    public int getKeyCode() {
      return keyCode;
    }

    public int getDeltaX() {
      return deltaX;
    }

    public int getDeltaY() {
      return deltaY;
    }
  }

  /**
   * Memonitor dan menggerakkan player sesuai input arah gerak pemain.
   */
  private class AnimationListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

      int moveCode = 0;
      for (Dir dir : Dir.values()) {
        if (dirMap.get(dir)) {
          if (Objects.equals(dir.getName(), "Left")) {
            player.move(1);
          }
          if (Objects.equals(dir.getName(), "Down")) {
            player.move(2);
          }
          if (Objects.equals(dir.getName(), "Right")) {
            player.move(3);
          }
          if (Objects.equals(dir.getName(), "Up")) {
            player.move(4);
          }
        }
      }

      player.move(moveCode);

      repaint();

      for (Enemy anEnemyPool : enemyPool) {
        if (player.contain(anEnemyPool)) {
          Player.setLife(Player.getLife() - 1);
          player.setPos(playerPosX, playerPosY);
        }
      }

      if (player.contain(finish.getPosX(), finish.getPosY(), finish.getWidth
        (), finish.getHeight()) && level == 0) {
        Player.setScore(Player.getScore() + 1);
        animationTimer.stop();
        Frame.layout.show(Frame.mainPanel, "GameWin");
      }

      if (Player.gameOver()) {
        animationTimer.stop();
        Frame.layout.show(Frame.mainPanel, "GameOver");
      }
    }
  }

  /**
   * Mendeteksi arah gerak player berdasarkan penekanan tombol keyboard.
   */
  private class DirAction extends AbstractAction {
    private String pressedOrReleased;
    private Dir dir;

    DirAction(Dir dir, String pressedOrReleased) {
      this.dir = dir;
      this.pressedOrReleased = pressedOrReleased;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
      if (pressedOrReleased.equals(PRESSED)) {
        dirMap.put(dir, Boolean.TRUE);
      } else if (pressedOrReleased.equals(RELEASED)) {
        dirMap.put(dir, Boolean.FALSE);
      }
    }

    public void submitScore() {

    }
  }
}