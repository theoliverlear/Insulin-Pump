import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame {
    // Provide screen dimensions to create appropriate window sizing
    Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
    public MainFrame() {
        // Declare Main Frame
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setTitle("Home Screen");
        setVisible(true);
        setLocation((int) (screenDimensions.getWidth() / 2), (int) (screenDimensions.getHeight() / 2));
        setSize(1200, 1100);
        add(new MainPanel());
        
    }
}
