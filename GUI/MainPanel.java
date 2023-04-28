import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class MainPanel extends Panel {
    public MainPanel() {
        // Declare Main Panel
        setVisible(true);
        setSize(750,750);
        add(new HomeButton("Bolus Wizard")) ;
        add(new HomeButton("Edit Settings")) ;
        add(new HomeButton("Test Blood Sugar")) ;
        add(new HomeButton("View History")) ;
        add(new MainContainer());

    }
}
