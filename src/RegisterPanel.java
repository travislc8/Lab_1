import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RegisterPanel extends JPanel {
    private Register register = new Register();
    private JTextField inputText = new JTextField("");
    private JLabel messageLabel = new JLabel("");
    private Double inputAmount = 0.0;
    private JPanel inputPanel = new JPanel();
    private PursePanel pursePanel = new PursePanel();

    public RegisterPanel() {
        this.setPreferredSize(new Dimension(1000, 900));
        this.setBackground(Color.white);

        inputText.setEditable(true);
        inputText.setPreferredSize(new Dimension(200, 50));
        inputText.setFont(new Font("calbri", Font.PLAIN, 16));
        inputText.addActionListener(new InputListener());
        inputPanel.add(inputText);

        messageLabel.setFont(new Font("calbri", Font.PLAIN, 12));
        inputPanel.add(messageLabel);

        this.add(inputPanel);
        this.add(pursePanel);
    }

    private class InputListener implements ActionListener {

        public void actionPerformed(ActionEvent e) { // called when enter key is pressed
            String input = inputText.getText();
            try {
                inputAmount = Double.parseDouble(input);
                calculateValue();
            } catch (Exception exception) {
                inputText.setText("");
                messageLabel.setText("Error: Could not read the input. Input must be a number.");
                inputAmount = 0.0;
            }
        }
    }

    private void calculateValue() {
        pursePanel.removeAll();
        var purse = register.makeChange(inputAmount);
        messageLabel.setText("Value in Purse = $" + purse.getValue());
        pursePanel.setPurse(purse);
        pursePanel.paintComponent();

    }

}
