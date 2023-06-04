package ExpansiveApproach;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ExitButton extends Button implements ActionListener {
    public ExitButton(String label) {
        setLabel(label);
        setLocation(800,800);
        setVisible(true);
        this.addActionListener(this::actionPerformed);
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        String buttonName = event.getActionCommand();
        if (buttonName.equals("Exit")) {
            System.exit(0);
        }
        repaint();
    }
    @Override
    public void paint(Graphics graphics) {

    }
}
