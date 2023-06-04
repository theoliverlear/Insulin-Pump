package ExpansiveApproach;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BolusWizardButton extends Button implements ActionListener {

    public BolusWizardButton(String label) {
        setLabel(label);
        setLocation(800,800);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
