import java.awt.*;
import javax.swing.*;

/**
 * Driver for the GUI section
 */
public class MakingChange {

    public static void main(String[] args) {

        // creats the main frame for the GUI
        JFrame frame = new JFrame("Change Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000, 900));

        // adds a regiter panel for the functionality
        RegisterPanel register = new RegisterPanel();
        register.setPreferredSize(new Dimension(600, 600));

        // displays the frame
        frame.getContentPane().add(register);
        frame.pack();
        frame.setVisible(true);
    }
}
