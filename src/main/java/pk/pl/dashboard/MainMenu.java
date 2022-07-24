package pk.pl.dashboard;

import pk.pl.database.DataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;

public class MainMenu extends JFrame implements MouseListener {
    private ArrayList<JTextField> additionalExpensesList = new ArrayList<>();

    private int width;
    private int height;
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private JButton sendDataButton = new JButton();
    private JButton loadDataButton = new JButton();
    private JButton addButton = new JButton("Add button");
    private JButton removeButton = new JButton("Remove buttons");
    private JTextField category = new JTextField(50);
    private JTextField subCategory = new JTextField(50);
    private JTextField expense = new JTextField(50);
    private JTextField date = new JTextField(50);
    private JTextField comment = new JTextField(50);
    private JTextArea displayData = new JTextArea();

    private int iterator = 1;

    public MainMenu(int width, int height) {
        this.width = width;
        this.height = height;
        this.setSize(this.width, this.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout mainFrameGrid = new GridLayout(1,1,1,1);
        GridLayout rightMenuGrid = new GridLayout(5 ,5, 1, 1);
        GridLayout leftMenuGrid = new GridLayout(5,5, 1, 1);
        this.setLayout(mainFrameGrid);

        sendDataButton.addMouseListener(this);
        sendDataButton.setText("Save your expense");

        loadDataButton.addMouseListener(this);
        loadDataButton.setText("Load data");

        addButton.addMouseListener(this);
        removeButton.addMouseListener(this);

        //  Text fields
        category.setToolTipText("Category...");
        subCategory.setToolTipText("Subcategory...");
        expense.setToolTipText("Expense...");
        comment.setToolTipText("Comment");
        date.setToolTipText("Date...");

        //  Left Panel
        leftPanel.setLayout(leftMenuGrid);
        leftPanel.add(sendDataButton);
        leftPanel.add(loadDataButton);
        leftPanel.add(addButton);
        leftPanel.add(removeButton);

        //  Right Panel
        rightPanel.setLayout(rightMenuGrid);
        rightPanel.add(category);
        rightPanel.add(subCategory);
        rightPanel.add(expense);
        rightPanel.add(comment);
        rightPanel.add(date);

        this.add(leftPanel);
        this.add(rightPanel);
        this.setVisible(true);
    }

    private void addExpense() {
        JTextField category = new JTextField(10);
        JTextField subcategory = new JTextField(10);
        JTextField expense = new JTextField(10);
        JTextField comment = new JTextField(10);
        JTextField date = new JTextField(10);
        GridLayout gridLayout = new GridLayout(this.iterator, 5);
        this.rightPanel.setLayout(gridLayout);
        this.rightPanel.add(category);
        this.rightPanel.add(subcategory);
        this.rightPanel.add(expense);
        this.rightPanel.add(comment);
        this.rightPanel.add(date);
        this.additionalExpensesList.add(category);
        this.additionalExpensesList.add(subcategory);
        this.additionalExpensesList.add(expense);
        this.additionalExpensesList.add(comment);
        this.additionalExpensesList.add(date);
        this.iterator += 1;
        this.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == sendDataButton) {
            DataBase save = new DataBase();
            try {
         //       save.saveData(
          //              category.getText(),
          //              subCategory.getText(),
           //             Float.parseFloat(expense.getText()),
          //              comment.getText(),
         //               new Date(Long.parseLong(date.getText()))
          //      );
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }

            // Clear
            category.setText("");
            subCategory.setText("");
            expense.setText("");
            comment.setText("");
            date.setText("");
        }

        if (e.getSource() == loadDataButton) {
            DataBase dataBase = new DataBase();
            dataBase.readData();
        }

        if (e.getSource() == addButton) {
            addExpense();
            System.out.println(this.iterator);
        }

        if (e.getSource() == removeButton) {
            for (int iterator = 0; iterator < this.additionalExpensesList.size(); iterator += 1) {
                this.rightPanel.remove(this.additionalExpensesList.get(iterator));
            }
            this.iterator = 1;
            this.additionalExpensesList.clear();
            this.setVisible(true);
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
        if (e.getSource() == sendDataButton) {
            sendDataButton.setForeground(Color.WHITE);
            sendDataButton.setBackground(Color.BLACK);
        }

        if (e.getSource() == loadDataButton) {
            loadDataButton.setForeground(Color.WHITE);
            loadDataButton.setBackground(Color.BLACK);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == sendDataButton) {
            sendDataButton.setForeground(Color.BLACK);
            sendDataButton.setBackground(Color.WHITE);
        }

        if (e.getSource() == loadDataButton) {
            loadDataButton.setForeground(Color.BLACK);
            loadDataButton.setBackground(Color.WHITE);
        }
    }
}
