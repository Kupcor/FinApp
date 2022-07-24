package pk.pl.dashboard.mainPanel.expensesPanel;

import pk.pl.dashboard.mainPanel.expensesPanel.descriptions.NewExpensesFieldDescriptionPanel;
import pk.pl.dashboard.mainPanel.expensesPanel.uiComponents.OneExpensePanel;
import pk.pl.database.DataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class NewExpensesPanel extends JPanel {
    private ArrayList<OneExpensePanel> oneSessionExpensesList = new ArrayList<>();
    private JButton saveExpensesToDataBaseButton = new JButton("Save");
    private JButton addNewExpenseToTableButton = new JButton("Add expense");
    private JButton clearWholeNewExpensesTableButton = new JButton("Clear all expenses");

    private NewExpensesFieldDescriptionPanel newExpensesFieldDescriptionPanel = new NewExpensesFieldDescriptionPanel();
    private JPanel newExpensesTablePanel = new JPanel();
    private JPanel containerForButtonsPanel = new JPanel();

    public NewExpensesPanel(MouseListener mainDashboard) {
        this.setLayout(new BorderLayout());
        newExpensesTablePanel.setLayout(new GridLayout(10,0));

        addNewExpenseToTableButton.addMouseListener(mainDashboard);
        saveExpensesToDataBaseButton.addMouseListener(mainDashboard);
        clearWholeNewExpensesTableButton.addMouseListener(mainDashboard);

        this.addNewExpense();
        containerForButtonsPanel.add(clearWholeNewExpensesTableButton);
        containerForButtonsPanel.add(addNewExpenseToTableButton);
        containerForButtonsPanel.add(saveExpensesToDataBaseButton);

        this.add(newExpensesFieldDescriptionPanel, BorderLayout.PAGE_START);
        this.add(newExpensesTablePanel, BorderLayout.CENTER);
        this.add(containerForButtonsPanel, BorderLayout.PAGE_END);
    }

    public void addNewExpense() {
        OneExpensePanel oneExpensePanel = new OneExpensePanel();
        newExpensesTablePanel.add(oneExpensePanel);
        oneSessionExpensesList.add(oneExpensePanel);
    }

    public void saveExpenses() throws SQLException {
        DataBase dataBase = new DataBase();
        for (int iterator = 0; iterator < oneSessionExpensesList.size(); iterator++) {
            dataBase.saveData(
                    oneSessionExpensesList.get(iterator).getPersonWhoMadeExpenseTextField().getText(),
                    String.valueOf(oneSessionExpensesList.get(iterator).getCategoryComboBox().getSelectedItem()),
                    String.valueOf(oneSessionExpensesList.get(iterator).getSubCategoriesComboBox().getSelectedItem()),
                    Float.parseFloat(oneSessionExpensesList.get(iterator).getAmountOfExpensesEntryField().getText()),
                    oneSessionExpensesList.get(iterator).getAdditionalCommentEntryField().getText(),
                    Date.valueOf(java.time.LocalDate.now())
            );
        }
        dataBase.closeDateBase();
        clearWholeNewExpensesTable();
    }

    public void clearWholeNewExpensesTable() {
        oneSessionExpensesList.clear();
        newExpensesTablePanel.removeAll();
        addNewExpense();
        newExpensesTablePanel.revalidate();
        newExpensesTablePanel.repaint();
    }

    public ArrayList<OneExpensePanel> getOneSessionExpensesList() {
        return oneSessionExpensesList;
    }
    //  Buttons return
    public JButton getAddNewExpenseToTableButton() {
        return addNewExpenseToTableButton;
    }
    public JButton getSaveExpensesToDataBaseButton() {
        return saveExpensesToDataBaseButton;
    }
    public JButton getClearWholeNewExpenseTableButton() {
        return clearWholeNewExpensesTableButton;
    }
}
