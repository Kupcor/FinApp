package pk.pl.dashboard.mainPanel.expensesPanel.uiComponents;

import pk.pl.database.ReadFromFiles;

import javax.swing.*;
import java.util.ArrayList;

public class CategoryComboBox extends JComboBox {

    public CategoryComboBox() {
        ReadFromFiles readFromFiles = new ReadFromFiles();
        this.loadCategoriesFromFilesToComponent("src\\main\\java\\pk\\pl\\externalInformations\\categories.txt");
    }

    private void loadCategoriesFromFilesToComponent(String filePath) {
        ArrayList<String> listOfAvailableCategories = new ArrayList<>();
        ReadFromFiles readFromFiles = new ReadFromFiles();

        listOfAvailableCategories = readFromFiles.getStringList(filePath);
        for (int iterator = 0; iterator < listOfAvailableCategories.size(); iterator++){
            this.addItem(listOfAvailableCategories.get(iterator));
        }
    }
}
