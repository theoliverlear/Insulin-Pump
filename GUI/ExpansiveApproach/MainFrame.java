package ExpansiveApproach;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        setLocation((int) (screenDimensions.getWidth() / 2),
                    (int) (screenDimensions.getHeight() / 2));
        setSize(500, 500);
        Panel panel =  new MainPanel();
        Canvas canvas = new MainCanvas();

        add(panel);
        add(canvas);
    }

    public class BolusWizardButton extends Button implements ActionListener {
        public BolusWizardButton(String label) {
            setLabel(label);
            setLocation(800,800);
            setVisible(true);
        }
        @Override
        public void actionPerformed(ActionEvent event) {

        }
    }
}
