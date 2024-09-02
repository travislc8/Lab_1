import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Class for a JPanel that reads and displays cash based on the user input
 */
public class RegisterPanel extends JPanel {
    // data fields
    private Register register = new Register();
    private JTextField inputText = new JTextField("");
    private JLabel messageLabel = new JLabel("");
    private Double inputAmount = 0.0;
    private JPanel inputPanel = new JPanel();
    private PursePanel pursePanel = new PursePanel();

    /**
     * Constructor for Register Panel class
     */
    public RegisterPanel() {
        // formats the jpanel
        this.setPreferredSize(new Dimension(1000, 900));
        this.setBackground(Color.white);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // formats the JTextField for the user input
        inputText.setEditable(true);
        inputText.setPreferredSize(new Dimension(200, 50));
        inputText.setFont(new Font("calibri", Font.PLAIN, 16));
        inputText.addActionListener(new InputListener());

        // formats the input JPanel
        inputPanel.add(inputText);
        inputPanel.setSize(new Dimension(800, 150));
        inputPanel.setBackground(Color.white);

        // formats tha message label for feedback to the user
        messageLabel.setFont(new Font("calibri", Font.PLAIN, 12));
        inputPanel.add(messageLabel);

        // adds the panels to the Register Panel
        this.add(inputPanel);
        this.add(pursePanel);
    }

    /**
     * Listener for the user input field, that calls the method for calculating the
     * result when the user inputs data.
     * 
     */
    private class InputListener implements ActionListener {

        public void actionPerformed(ActionEvent e) { // called when enter key is pressed
            String input = inputText.getText();
            // gets user input and catches exception if the user enters non-numbers
            try {
                inputAmount = Double.parseDouble(input);
                calculateValue();
            } catch (Exception exception) {
                // displays the error message if user inputs a non-number
                inputText.setText("");
                messageLabel.setText("Error: Could not read the input. Input must be a number.");
                inputAmount = 0.0;
            }
        }
    }

    /**
     * Calculates and displays the denominations based on the inputAmount
     */
    private void calculateValue() {
        pursePanel.removeAll();
        var purse = register.makeChange(inputAmount);
        if (purse.getValue() < 0)
            messageLabel.setText("Value in Purse = $0");
        else
            messageLabel.setText("Value in Purse = $" + purse.getValue());
        pursePanel.setPurse(purse);
        pursePanel.paintComponent();

    }

}
