// Partner Ayaan Ajmal
// Date: 11/7/21

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener {
  JTextField userGuess;
  JButton guessButton;
  JButton playAgainButton;
  JLabel pleaseGuess;
  JLabel status;
  JLabel lastGuess;

  Random r = new Random();
  int randomNum1 = r.nextInt(100) + 1;

  GuessingGame() {

    JFrame frame = new JFrame("Guessing Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(240, 120);
    userGuess = new JTextField(10);
    userGuess.setActionCommand("myTF");

    guessButton = new JButton("Guess");
    playAgainButton = new JButton("Play Again");

    userGuess.addActionListener(this);
    guessButton.addActionListener(this);
    playAgainButton.addActionListener(this);

    pleaseGuess = new JLabel("Enter Your Guess");
    status = new JLabel("");
    lastGuess = new JLabel("");

    frame.add(pleaseGuess);
    frame.add(userGuess);
    frame.add(guessButton);
    frame.add(status);
    frame.add(lastGuess);
    frame.add(playAgainButton);

    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae) {

    if (ae.getActionCommand().equals("Guess")) {
      int guess = Integer.parseInt(userGuess.getText());
      if (guess < randomNum1) {
        status.setText("Too low!");
      } else if (guess > randomNum1) {
        status.setText("Too high!");
      } else {
        status.setText("You got it!");
      }
      lastGuess.setText("Last guess was " + guess);
    } else if (ae.getActionCommand().equals("Play Again")) {
      int randomNum2 = r.nextInt(100) + 1;
      randomNum1 = randomNum2;
      pleaseGuess.setText("Enter your guess: ");
      status.setText("");
      lastGuess.setText("");
      userGuess.setText("");
    } else {
      status.setText("You pressed Enter. Please press the Guess Button.");
    }
  }
}
