import java.awt.*;

public class MainCanvas extends Canvas {
    //@Override
    public void paint(Graphics mainGraphics) {

        //setSize(600, 600);
        setForeground(Color.black);
        setBackground(Color.black);
        mainGraphics.setColor(Color.black);
        mainGraphics.drawRect(100, 100, 200, 200);
        setVisible(true);

    }
}
