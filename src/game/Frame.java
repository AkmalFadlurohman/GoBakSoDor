package game;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import movable.Player;

/**
 * Created by Diki Ardian W (13515092) on 4/24/17.
 */
public class Frame extends JFrame implements ActionListener {

  final private int HEIGHT = 720;
  final private int WIDTH = 1280;

  JButton newGameButton = new JButton("New game");
  JButton exitButton = new JButton("Exit");
  JButton aboutButton = new JButton("About");
  JButton mainMenuButton = new JButton("Main Menu");
  JButton nextLevelButton = new JButton("Next Level");
  JButton okButton = new JButton("OK");

  static CardLayout layout = new CardLayout();

  static JPanel mainPanel = new JPanel();
  MenuPanel menuPanel = new MenuPanel();
  AboutPanel aboutPanel = new AboutPanel();
  NextLvlPanel nextLvlPanel = new NextLvlPanel();
  GameOverPanel gameOverPanel = new GameOverPanel();

  Game game;

  public Frame() throws FileNotFoundException {

    setFocusable(true);
    mainPanel.setLayout(layout);
    addButtons();
    add(mainPanel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setName("DorSoBakGo");
    setSize(WIDTH, HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void addButtons() {
    newGameButton.addActionListener(this);
    aboutButton.addActionListener(this);
    exitButton.addActionListener(this);
    mainMenuButton.addActionListener(this);
    nextLevelButton.addActionListener(this);
    okButton.addActionListener(this);

    menuPanel.add(newGameButton);
    menuPanel.add(aboutButton);
    menuPanel.add(exitButton);

    mainPanel.add("Menu", menuPanel);
    mainPanel.add("About", aboutPanel);

    nextLvlPanel.add(nextLevelButton);
    mainPanel.add("NextLevel", nextLvlPanel);

    gameOverPanel.add(okButton);
    mainPanel.add("GameOver", gameOverPanel);

    add(mainPanel);
    layout.show(mainPanel, "Menu");
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    Object source = actionEvent.getSource();

    if (source == exitButton) {
      System.exit(1);
    } else if (source == aboutButton) {
      aboutPanel.add(mainMenuButton);
      layout.show(mainPanel, "About");
    } else if (source == newGameButton || source == nextLevelButton) {
      try {
        game = new Game();
        game.add(mainMenuButton);
        addKeyListener(game);
        mainPanel.add("game", game);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
      layout.show(mainPanel, "game");
    } else if (source == mainMenuButton || source == okButton) {
      if (game != null) {
        Game.stopTimer();
        Game.setLevel(1);
        Player.setScore(0);
        Player.setLife(3);
      }
      layout.show(mainPanel, "Menu");
    }
  }
}
