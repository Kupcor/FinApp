package pk.pl.dashboard;

import pk.pl.dashboard.mainPanel.DefaultMainPanel;
import pk.pl.dashboard.mainPanel.MainSectionsContainer;
import pk.pl.dashboard.mainPanel.NewExpensesPanel;
import pk.pl.dashboard.navPanel.NavPanel;
import pk.pl.templates.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainDashboard extends Window implements MouseListener {
    NavPanel navPanel = new NavPanel(this);
    MainSectionsContainer mainSectionsContainer = new MainSectionsContainer();

    DefaultMainPanel defaultMainPanel = new DefaultMainPanel();
    NewExpensesPanel newExpensesSectionPanel = new NewExpensesPanel();

    public MainDashboard() {
        this.setLayout(new BorderLayout());

        //  Panels
        JButton button = new JButton("Hello?");
        navPanel.setBackground(Color.GREEN);
        navPanel.addMouseListener(this);
        newExpensesSectionPanel.addMouseListener(this);

        //  mainSectionsContainer
        mainSectionsContainer.add(defaultMainPanel);

        //  Adding panels
        this.add(navPanel, BorderLayout.LINE_START);
        this.add(mainSectionsContainer, BorderLayout.CENTER);
        //this.add(newExpensesSectionPanel, BorderLayout.CENTER);

    }

    private void clearMainSectionsContainer() {
        mainSectionsContainer.removeAll();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == navPanel.getExitButton()) {
            this.dispose();
        }
        if (e.getSource() == navPanel.getNewExpensesSectionButton()) {
            clearMainSectionsContainer();
            mainSectionsContainer.add(newExpensesSectionPanel);
            mainSectionsContainer.revalidate();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
