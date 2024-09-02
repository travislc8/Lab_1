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
        this.setPreferredSize(new Dimension(900, 600));
        this.setBackground(Color.blue);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        textLabel.setFont(new Font("calbri", Font.PLAIN, 12));
        this.add(textLabel);
        this.add(imageLabel);

    }

    public PursePanel(Purse purse) {
        this.purse = purse;

        this.setPreferredSize(new Dimension(300, 300));
        this.setBackground(Color.blue);

    }

    public void setPurse(Purse purse) {
        this.purse = purse;
    }

    public void paintComponent() {
        this.setBackground(Color.red);
        double amount = purse.getValue();

        if (amount <= 0) {
            newLabel("Empty Purse");
            return;
        }

        int denominationCount = 0;

        for (var type : MoneyType.values()) {
            denominationCount = purse.getDenominationCount(type);
            if (denominationCount > 0) {
                var rowPanel = new JPanel();
                rowPanel.add(newLabel(Integer.toString(denominationCount)));
                rowPanel.add(newImage(type));
                rowPanel.setPreferredSize(new Dimension(200, 100));
                this.add(rowPanel);
            }
        }
    }

    private JLabel newLabel(String text) {
        var label = new JLabel(text);
        label.setFont(new Font("calbri", Font.PLAIN, 12));
        label.setHorizontalAlignment(SwingConstants.LEFT);

        return label;
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
        var icon = new ImageIcon(img.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        var label = new JLabel(icon);
        // var label = new JLabel(address);

        label.setPreferredSize(new Dimension(100, 100));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        return label;
    }

}
