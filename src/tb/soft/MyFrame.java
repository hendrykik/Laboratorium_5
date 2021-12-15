package tb.soft;

import java.awt.Component;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
    MyPanel panel = new MyPanel();

    MyFrame() {
        this.setDefaultCloseOperation(3);
        this.add(this.panel);
        this.pack();
        this.setLocationRelativeTo((Component)null);
        this.setVisible(true);
    }
}
