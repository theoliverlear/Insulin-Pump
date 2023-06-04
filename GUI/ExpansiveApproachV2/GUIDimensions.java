package ExpansiveApproachV2;

import java.awt.*;

public class GUIDimensions {
    static Dimension initSize = new Dimension(1000, 1000);
    static Dimension wideHalfInit = new Dimension((int) initSize.getWidth(),
                                                  (int) getSizeFraction(initSize.getHeight(), 2));
    static Dimension quarterInit = new Dimension((int) getSizeFraction(initSize.getWidth(), 4),
                                                 (int) getSizeFraction(initSize.getHeight(), 4));
    static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    static double screenWidth = screen.getWidth();
    static double screenHeight = screen.getHeight();
    public static double getCenter(double size) {
        return size / 2;
    }
    public static double getSizeFraction(double size, int division) {
        return size / division;
    }
}
