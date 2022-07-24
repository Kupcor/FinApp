package pk.pl.dashboard;

import pk.pl.dashboard.mainPanel.DefaultMainPanel;
import pk.pl.dashboard.mainPanel.MainSectionsContainer;
import pk.pl.dashboard.mainPanel.expensesPanel.NewExpensesPanel;
import pk.pl.dashboard.mainPanel.reportPanel.ReportsPanel;
import pk.pl.dashboard.navPanel.NavPanel;
import pk.pl.templates.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

public class MainDashboard extends Window implements MouseListener {
    NavPanel navPanel = new NavPanel(this);
    MainSectionsContainer mainSectionsContainer = new MainSectionsContainer();

    DefaultMainPanel defaultMainPanel = new DefaultMainPanel();
    NewExpensesPanel newExpensesSectionPanel = new NewExpensesPanel(this);
    ReportsPanel reportsPanel = new ReportsPanel();

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
        this.revalidate();
    }

    private void clearMainSectionsContainer() {
        mainSectionsContainer.removeAll();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //  Nav panel
        if (e.getSource() == navPanel.getExitButton()) {
            this.dispose();
        }
        if (e.getSource() == navPanel.getNewExpensesSectionButton()) {
            clearMainSectionsContainer();
            mainSectionsContainer.add(newExpensesSectionPanel);
            mainSectionsContainer.revalidate();
            mainSectionsContainer.repaint();
        }
        if (e.getSource() == navPanel.getReportsSectionButton()) {
            clearMainSectionsContainer();
            mainSectionsContainer.add(reportsPanel);
            mainSectionsContainer.revalidate();
            mainSectionsContainer.repaint();
        }

        //  Expenses section
        if (e.getSource() == newExpensesSectionPanel.getAddNewExpenseToTableButton()) {
            if (newExpensesSectionPanel.getOneSessionExpensesList().size() < 10) {
                newExpensesSectionPanel.addNewExpense();
                newExpensesSectionPanel.revalidate();
            }
        }
        if (e.getSource() == newExpensesSectionPanel.getSaveExpensesToDataBaseButton()) {
            try {
                newExpensesSectionPanel.saveExpenses();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == newExpensesSectionPanel.getClearWholeNewExpenseTableButton()) {
            newExpensesSectionPanel.clearWholeNewExpensesTable();
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
