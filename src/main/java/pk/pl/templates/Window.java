package pk.pl.templates;

import com.formdev.flatlaf.*;
import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    protected int width = 1200;
    protected int height = 500;

    protected Window() {
        try {
            //  FlatLaf module -> see formdev.com/flatlaf/
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Failed to initialized flat laf theme.");
        }
        this.setSize(new Dimension(this.width, this.height));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
}