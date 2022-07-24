package pk.pl.dashboard.mainPanel.expensesPanel.descriptions;

import javax.swing.*;

public class NewExpensesFieldDescriptionPanel extends JPanel {

    public NewExpensesFieldDescriptionPanel() {
        JLabel nameCaption = new JLabel("Name");
        JLabel categoryCaption = new JLabel("Category");
        JLabel subCategoryCaption = new JLabel("Sub category");
        JLabel amountCaption = new JLabel("Amount");
        JLabel additionalCommentCaption = new JLabel("Additional comment");

        this.add(nameCaption);
        this.add(categoryCaption);
        this.add(subCategoryCaption);
        this.add(amountCaption);
        this.add(additionalCommentCaption);
    }
}
