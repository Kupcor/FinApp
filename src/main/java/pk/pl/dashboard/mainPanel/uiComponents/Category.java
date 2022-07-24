package pk.pl.dashboard.mainPanel.uiComponents;

import pk.pl.database.ReadFromFiles;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Category extends JComboBox {
    private ArrayList<String> listOfAvailableCategories = new ArrayList<>();

    public Category() {
        ReadFromFiles readFromFiles = new ReadFromFiles();
        this.listOfAvailableCategories = readFromFiles.getStringList("src\\main\\java\\pk\\pl\\externalInformations\\categories.txt");
        System.out.println(listOfAvailableCategories);
    }
}
