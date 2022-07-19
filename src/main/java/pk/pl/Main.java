package pk.pl;



import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.sql.Date;

public class Main {

    public static void main (String ... args) throws UnsupportedLookAndFeelException {
        FlatLightLaf.setup();
        UIManager.setLookAndFeel(new FlatIntelliJLaf());
        //MainMenu mainMenu = new MainMenu(600,300);
        MainMenu mainMenu = new MainMenu(600, 300);
    }

}
