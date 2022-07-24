package pk.pl.dashboard.mainPanel;

import javax.swing.*;
import java.awt.*;

public class DefaultMainPanel extends JPanel {

    public DefaultMainPanel() {
        JLabel welcomeCaption = new JLabel("Welcom dear Kupcor!");
        welcomeCaption.setOpaque(true);
        welcomeCaption.setBackground(Color.BLUE);

        this.add(welcomeCaption);
    }
}
