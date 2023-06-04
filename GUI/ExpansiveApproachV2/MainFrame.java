package ExpansiveApproachV2;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame  {
    Frame frame;
    public MainFrame() {
        this.frame = new Frame("Insulin Pump");
        this.frame.setName("Main Frame");
        this.frame.setVisible(true);
        this.frame.setSize(1000, 1000);
        this.frame.setLocation((int) GUIDimensions.getCenter(GUIDimensions.screenWidth),
                               (int) GUIDimensions.getCenter(GUIDimensions.screenHeight));
        this.frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                System.exit(0);
            }
        });
        BorderLayout frameBorderLayout = new BorderLayout();
        frame.setLayout(frameBorderLayout);
        MainPanel mainPanel = new MainPanel();
        this.frame.add(mainPanel.getPanel(), BorderLayout.NORTH);
    }
    public Frame getFrame() {
        return this.frame;
    }
}
