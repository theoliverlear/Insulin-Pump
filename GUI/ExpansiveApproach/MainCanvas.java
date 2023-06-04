package ExpansiveApproach;

import java.awt.*;

public class MainCanvas extends Canvas {
    public void paint(Graphics mainGraphics) {
        //setSize(600, 600);
        setForeground(Color.black);
        setBackground(Color.black);
        mainGraphics.setColor(Color.black);
        setSize(500, 500);
        mainGraphics.drawRect(100, 100, 200, 200);
        setVisible(true);
        mainGraphics.drawString("Test", 450, 450);

    }
}