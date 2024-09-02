import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PursePanel extends JPanel {

    private Purse purse = new Purse();
    private JLabel textLabel = new JLabel("");
    private JLabel imageLabel = new JLabel("");

    public PursePanel() {
        this.setPreferredSize(new Dimension(200, 600));
        this.setBackground(Color.white);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentY(Component.TOP_ALIGNMENT);

        textLabel.setFont(new Font("calbri", Font.PLAIN, 12));
        this.add(textLabel);
        this.add(imageLabel);

    }

    public void setPurse(Purse purse) {
        this.purse = purse;
    }

    public void paintComponent() {
        this.removeAll();
        this.repaint();
        this.setBackground(Color.white);
        double amount = purse.getValue();

        if (amount <= 0) {
            var label = new JLabel("Empty Purse");
            label.setFont(new Font("calbri", Font.PLAIN, 20));
            this.add(label);
            return;
        }

        int denominationCount = 0;

        for (var type : MoneyType.values()) {
            denominationCount = purse.getDenominationCount(type);
            if (denominationCount > 0) {
                var rowPanel = new JPanel();
                for (int i = 0; i < denominationCount; i++) {
                    rowPanel.add(newImage(type));
                }
                rowPanel.setSize(new Dimension(100, 60));
                rowPanel.setBackground(Color.white);
                this.add(rowPanel);
            }
        }
    }

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
        try {
            img = ImageIO.read(new File(address));
        } catch (IOException ex) {
            return null;
        }

        var icon = resizeImage(50, img);
        var label = new JLabel(icon);
        // var label = new JLabel(address);

        label.setHorizontalAlignment(SwingConstants.RIGHT);
        return label;
    }

    private ImageIcon resizeImage(int height, BufferedImage img) {

        var ration = img.getWidth() / img.getHeight();
        var newImg = new ImageIcon(img.getScaledInstance((height * ration), 50, Image.SCALE_SMOOTH));

        return newImg;
    }

}
