package pk.pl;



import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import pk.pl.dashboard.MainDashboard;
import pk.pl.dashboard.MainMenu;
import pk.pl.dashboard.mainPanel.uiComponents.Category;

import javax.swing.*;

public class Main {

    public static void main (String ... args) throws UnsupportedLookAndFeelException {
        //MainMenu mainMenu = new MainMenu(600,300);
        FlatLightLaf.setup();
        UIManager.setLookAndFeel(new FlatIntelliJLaf());
        //MainMenu mainMenu = new MainMenu(600, 300);
        //MainDashboard mainDashboard = new MainDashboard();
        Category category = new Category();
    }

}
