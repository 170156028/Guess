package GuessNumberPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessNumber {

    private JFrame frame;
    private JTextField guessField;
    private JButton submitButton;
    private JLabel promptLabel, resultLabel, guessLabel;
    private int randomNumber;
    private int attempts = 0;

    public GuessNumber() {
        // initialising the game
        randomNumber = new Random().nextInt(25) + 1; // Random number between 1 and 100

        // Creating JFrame
        frame = new JFrame("Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        // Creating Components
        promptLabel = new JLabel("Guess a number between 1 and 25:");
        guessLabel = new JLabel("Your Guess:");
        guessField = new JTextField(10);
        submitButton = new JButton("Submit");
        resultLabel = new JLabel("");

        // Adding action listener to the button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userGuess = Integer.parseInt(guessField.getText());
                    attempts++;

                    if (userGuess < 1 || userGuess > 25) {
                        resultLabel.setText("guess a number between 1 and 25.");
                    } else if (userGuess < randomNumber) {
                        resultLabel.setText("Try higher :) Attempts: " + attempts);
                    } else if (userGuess > randomNumber) {
                        resultLabel.setText("Try lower :) Attempts: " + attempts);
                    } else {
                        resultLabel.setText("Congratssss! You guessed it correctly in " + attempts + " attempts.");
                        submitButton.setEnabled(false); // Disable further submissions
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid number.");
                }
            }
        });

        // Add components to the frame
        frame.add(promptLabel);
        frame.add(guessLabel);
        frame.add(guessField);
        frame.add(submitButton);
        frame.add(resultLabel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GuessNumber());
    }
}
