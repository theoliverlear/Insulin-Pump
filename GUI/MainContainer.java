import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class MainContainer extends Container {
    public MainContainer() {
        add(new MainCanvas());
    }
}
