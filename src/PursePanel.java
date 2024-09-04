import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
        this.setPreferredSize(new Dimension(500, 700));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(0, 1));
        this.setVisible(true);

        JLabel label = new JLabel("Empty Purse");
        label.setPreferredSize(new Dimension(100, 100));
        this.add(label);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintComponent();
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
        double amount = purse.getValue();

        // if purse is empty, displays empty message
        if (amount <= 0) {
            // creates jpanel holder for the empty purse label
            JPanel holder = new JPanel();
            holder.setPreferredSize(new Dimension(100, this.getWidth()));
            holder.setBackground(Color.white);

            // creates the empty purse jlabel
            JLabel label = new JLabel("Empty Purse");
            label.setFont(new Font("calibri", 0, 16));
            label.setPreferredSize(new Dimension(100, this.getWidth()));
            label.setBackground(Color.red);

            // adds the emements
            holder.add(label);
            this.add(holder);
            holder.revalidate();
            this.revalidate();
            return;
        }

        int denominationCount = 0;

        // iterates through the different denominations and displays the image
        // for the bill based on the number in the purse
        for (MoneyType type : MoneyType.values()) {
            denominationCount = purse.getDenominationCount(type);
            if (denominationCount > 0) {
                JPanel rowPanel = new JPanel();
                rowPanel.setBackground(Color.white);
                rowPanel.setPreferredSize(new Dimension(100, this.getWidth()));
                for (int i = 0; i < denominationCount; i++) {
                    rowPanel.add(newImage(type));
                }

                // formats the panel and adds to the purse panel
                rowPanel.revalidate();
                this.add(rowPanel);
            }
        }
        this.revalidate();
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
        ImageIcon icon = resizeImage(50, img);

        // adds the image to a new JLabel and adds to the Purse Panel
        JLabel label = new JLabel(icon);
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

        double ration = img.getWidth() / img.getHeight();
        ImageIcon newImg = new ImageIcon(img.getScaledInstance((int) (height * ration), 50, Image.SCALE_SMOOTH));

        return newImg;
    }

}
