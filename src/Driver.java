import java.io.FileNotFoundException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * Created by Diki Ardian W (13515092) on 4/24/17.
 */
public class Driver {
  public static void main(String[] args) throws FileNotFoundException {
    JFrame mainFrame = new JFrame("Start Menu");
    mainFrame.setSize(1280,720);
    mainFrame.setResizable(false);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JLabel background = new JLabel(new ImageIcon("/Castle.jpg"));
    mainFrame.setContentPane(background);
    mainFrame.setLayout(new FlowLayout());
    Label headerLabel = new Label("GoBakSoDor");
    headerLabel.setAlignment(Label.CENTER);
    Label statusLabel = new Label("Status : ");
    statusLabel.setAlignment(Label.RIGHT);
    JPanel panel = new JPanel();
    Button newGame = new Button("New Game");
    newGame.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          new Frame();
        } catch (FileNotFoundException ex) {

        }
      }
    });
    Button highScore = new Button("High Score");
    highScore.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        statusLabel.setText("Status : High Score");
      }
    });
    panel.add(headerLabel);
    panel.add(newGame);
    panel.add(highScore);
    panel.add(statusLabel);
    mainFrame.add(panel);
    mainFrame.add(statusLabel);
    mainFrame.setVisible(true);
  }
}
