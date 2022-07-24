package pk.pl.dashboard.navPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class NavPanel extends JPanel {
    UserProfilePanel userProfilePanel = new UserProfilePanel();

    JButton newExpensesSectionButton = new JButton("New expense");
    JButton reportsSectionButton = new JButton("Reports");
    JButton exitButton = new JButton("EXIT");

    public NavPanel(MouseListener mainDashboard) {
        this.setLayout(new BoxLayout(this ,BoxLayout.Y_AXIS));

        newExpensesSectionButton.addMouseListener(mainDashboard);
        reportsSectionButton.addMouseListener(mainDashboard);
        exitButton.addMouseListener(mainDashboard);

        this.add(Box.createRigidArea(new Dimension(200,0)));
        userProfilePanel.setBackground(Color.BLUE);

        this.add(userProfilePanel);
        this.add(newExpensesSectionButton);
        this.add(reportsSectionButton);
        this.add(exitButton);
    }

    public JButton getExitButton() {
        return exitButton;
    }
    public JButton getNewExpensesSectionButton() {
        return newExpensesSectionButton;
    }
    public JButton getReportsSectionButton() { return reportsSectionButton; }
}
