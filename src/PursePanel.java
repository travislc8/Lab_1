import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Class to display a set of cash images based on a given dollar figure
 */
public class PursePanel extends JPanel {

    // data fields
    private Purse purse = new Purse();

    /**
     * Constructor for PursePanel class
     */
    public PursePanel() {
        // formats the JPanel
        this.setPreferredSize(new Dimension(200, 600));
        this.setBackground(Color.white);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentY(Component.TOP_ALIGNMENT);

    }

    /**
     * Setter for purse data field
     * 
     * @param purse a purse object that contains the value that will be displayed
     */
    public void setPurse(Purse purse) {
        this.purse = purse;
    }

    /**
     * Displays the images based on the amount in the purse
     */
    public void paintComponent() {
        // clears the JPanel from the previous iterations
        this.removeAll();
        this.repaint();

        double amount = purse.getValue();

        // if purse is empty, displays empty message
        if (amount <= 0) {
            var label = new JLabel("Empty Purse");
            label.setFont(new Font("calibri", Font.PLAIN, 20));
            this.add(label);
            return;
        }

        int denominationCount = 0;

        // iterates through the different denominations and displays the image
        // for the bill based on the number in the purse
        for (var type : MoneyType.values()) {
            denominationCount = purse.getDenominationCount(type);
            if (denominationCount > 0) {
                var rowPanel = new JPanel();
                for (int i = 0; i < denominationCount; i++) {
                    rowPanel.add(newImage(type));
                }

                // formats the panel and adds to the purse panel
                rowPanel.setSize(new Dimension(100, 60));
                rowPanel.setBackground(Color.white);
                this.add(rowPanel);
            }
        }
    }

    /**
     * Constructs a new JLabel with the proper image of the specified type
     *
     * @param type the MoneyType that the image should be of
     */
    private JLabel newImage(MoneyType type) {
        String address = "src/Image/";

        address += switch (type) {
            case MoneyType.Penny -> "penny.png";
            case MoneyType.Nickel -> "nickel.png";
            case MoneyType.Dime -> "dime.png";
            case MoneyType.Quarter -> "quarter.png";
            case MoneyType.OneDollar -> "one_note.png";
            case MoneyType.FiveDollar -> "five_note.png";
            case MoneyType.TenDollar -> "ten_note.png";
            case MoneyType.TwentyDollar -> "twenty_note.png";
            case MoneyType.FiftyDollar -> "fifty_note.png";
            case MoneyType.OneHundredDollar -> "hundred_note.png";
        };

        BufferedImage img;
        // resizes the image
        try {
            img = ImageIO.read(new File(address));
        } catch (IOException ex) {
            return null;
        }
        var icon = resizeImage(50, img);

        // adds the image to a new JLabel and adds to the Purse Panel
        var label = new JLabel(icon);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        return label;
    }

    /**
     * Helper function to resize an image to a specified height while keeping the
     * correct aspect ratio
     *
     * @param height the desired height to make the image
     * @param img    the image to resize as a BufferedImage object
     *
     * @return the resized image as an ImageIcon object
     */
    private ImageIcon resizeImage(int height, BufferedImage img) {

        var ration = img.getWidth() / img.getHeight();
        var newImg = new ImageIcon(img.getScaledInstance((height * ration), 50, Image.SCALE_SMOOTH));

        return newImg;
    }

}
