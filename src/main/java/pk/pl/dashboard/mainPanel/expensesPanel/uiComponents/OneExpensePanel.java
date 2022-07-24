package pk.pl.dashboard.mainPanel.expensesPanel.uiComponents;

import javax.swing.*;

public class OneExpensePanel extends JPanel {
    private CategoryComboBox categoryComboBox = new CategoryComboBox();
    private SubCategoriesComboBox subCategoriesComboBox = new SubCategoriesComboBox();
    private JTextField personWhoMadeExpenseTextField = new JTextField(8);
    private JTextField amountOfExpensesEntryField = new JTextField(8);
    private JTextField additionalCommentEntryField = new JTextField(8);

    public OneExpensePanel() {
        this.add(personWhoMadeExpenseTextField);
        this.add(categoryComboBox);
        this.add(subCategoriesComboBox);
        this.add(amountOfExpensesEntryField);
        this.add(additionalCommentEntryField);
    }

    public JTextField getPersonWhoMadeExpenseTextField() {
        return personWhoMadeExpenseTextField;
    }
    public CategoryComboBox getCategoryComboBox() {
        return categoryComboBox;
    }
    public SubCategoriesComboBox getSubCategoriesComboBox() {
        return subCategoriesComboBox;
    }
    public JTextField getAmountOfExpensesEntryField() {
        return amountOfExpensesEntryField;
    }
    public JTextField getAdditionalCommentEntryField() {
        return additionalCommentEntryField;
    }
}
