package game;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created by Diki Ardian W (13515092) on 4/24/17.
 */
public class Frame extends JFrame implements ActionListener {

  final private int HEIGHT = 720;
  final private int WIDTH = 1280;

  JButton newGame = new JButton("New game");
  JButton exit = new JButton("Exit");
  JButton about = new JButton("About");
  JButton mainMenu = new JButton("Main Menu");

  CardLayout layout = new CardLayout();

  BackPanel menu = new BackPanel();
  JPanel panel = new JPanel();
  Game game;

  public Frame() throws FileNotFoundException {

//    JLabel background = new JLabel(new ImageIcon("./images/Castle.jpg"));
//    setContentPane(background);
//    setLayout(new FlowLayout());

    setFocusable(true);
    panel.setLayout(layout);
    addButtons();
    add(panel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setName("DorSoBakGo");
    setSize(WIDTH, HEIGHT);
    setResizable(false);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void addButtons() {
    newGame.addActionListener(this);
    about.addActionListener(this);
    exit.addActionListener(this);
    mainMenu.addActionListener(this);

    menu.add(newGame);
    menu.add(about);
    menu.add(exit);

    panel.add("Menu", menu);

    add(panel);
    layout.show(panel, "Menu");
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    Object source = actionEvent.getSource();

    if (source == exit) {
      System.exit(1);
    } else if (source == about) {

    } else if (source == newGame) {
      try {
        game = new Game(3);
        game.add(mainMenu);
//        addKeyListener(game);
        panel.add("game", game);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
      layout.show(panel, "game");
    } else if (source == mainMenu) {
      layout.show(panel, "Menu");
    }
  }
}
