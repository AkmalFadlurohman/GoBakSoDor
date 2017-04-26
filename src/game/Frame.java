package game;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import movable.Player;

/**
 * Created by Diki Ardian W (13515092) on 4/24/17.
 */

/**
 * Frame.
 * Menangani frame yang menampung seluruh tampilan UI
 */
public class Frame extends JFrame implements ActionListener {

  public static CardLayout layout = new CardLayout();
  public static JPanel mainPanel = new JPanel();
  private final int heightCons = 720;
  private final int widthCons = 1280;
  JButton newGameButton = new JButton("New game");
  JButton exitButton = new JButton("Exit");
  JButton aboutButton = new JButton("About");
  JButton mainMenuButton = new JButton("Main Menu");
  JButton nextLevelButton = new JButton("Next Level");
  JButton okButton1 = new JButton("OK");
  JButton okButton2 = new JButton("OK");
  MenuPanel menuPanel = new MenuPanel();
  AboutPanel aboutPanel = new AboutPanel();
  GameWinPanel gameWinPanel = new GameWinPanel();
  GameOverPanel gameOverPanel = new GameOverPanel();
  JLabel highScoreLabel = new JLabel("High Score", JLabel.RIGHT);
  Game game;

  /**
   * Constructor.
   * @throws FileNotFoundException Apabila file target yang akan dibaca tidak ditemukan
   */
  public Frame() throws FileNotFoundException {

    setFocusable(true);
    mainPanel.setLayout(layout);
    addButtons();
    add(mainPanel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setName("DorSoBakGo");
    setSize(widthCons, heightCons);
    setResizable(false);
    setLocationRelativeTo(null);
    setVisible(true);

  }

  /**
   * addButtons.
   * Menangani komponen Button pada UI
   * @throws FileNotFoundException Apabila file target yang akan dibaca tidak ditemukan
   */
  private void addButtons() throws FileNotFoundException {
    newGameButton.addActionListener(this);
    aboutButton.addActionListener(this);
    exitButton.addActionListener(this);
    mainMenuButton.addActionListener(this);
    nextLevelButton.addActionListener(this);
    okButton1.addActionListener(this);
    okButton2.addActionListener(this);

    menuPanel.add(newGameButton);
    menuPanel.add(aboutButton);
    menuPanel.add(exitButton);

    mainPanel.add("Menu", menuPanel);
    mainPanel.add("About", aboutPanel);

    gameWinPanel.add(okButton2);
    mainPanel.add("GameWin", gameWinPanel);

    gameOverPanel.add(okButton1);
    mainPanel.add("GameOver", gameOverPanel);

    add(mainPanel);
    layout.show(mainPanel, "Menu");
  }

  /**
   * actionPerformed.
   * Menangani tanggapan terhadap aksi user pada menu utama
   * @param actionEvent Aksi user
   */
  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    Object source = actionEvent.getSource();

    if (source == exitButton) {
      System.exit(1);
    } else if (source == aboutButton) {
      aboutPanel.add(mainMenuButton);
      layout.show(mainPanel, "About");
    } else if (source == newGameButton || source == nextLevelButton) {
      String name = "";
      if (source == newGameButton) {
        name = JOptionPane.showInputDialog(this, "Input Username:");
        Player.setName(name);
      }
      if (Player.getName() == null) {
        layout.show(mainPanel, "Menu");
      } else {
        try {
          game = new Game();
          game.add(mainMenuButton);
          mainPanel.add("game", game);
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
        layout.show(mainPanel, "game");
      }
    } else if (source == mainMenuButton || source == okButton1 || source == okButton2) {
      if (game != null) {
        game.stopTimer();
        Game.setLevel(0);
        Player.setLife(3);
      }
      layout.show(mainPanel, "Menu");
    }
  }
}
