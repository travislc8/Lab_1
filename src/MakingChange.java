import java.awt.*;
import javax.swing.*;

public class MakingChange {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Change Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000, 900));

        var register = new RegisterPanel();
        register.setPreferredSize(new Dimension(600, 600));

        frame.getContentPane().add(register);
        frame.pack();
        frame.setVisible(true);
    }
}
