package ExpansiveApproachV2;

import java.awt.*;

public class MainPanel {
    Panel panel;
    public MainPanel() {
        panel = new Panel();
        this.panel.setName("Main Panel");
        this.panel.setVisible(true);
        this.panel.setSize(GUIDimensions.wideHalfInit);
        BorderLayout panelBorderLayout = new BorderLayout();
        this.panel.setLayout(panelBorderLayout);
    }
    public Panel getPanel() {
        return this.panel;
    }
}
