package ExpansiveApproach;

import java.awt.*;

public class MainPanel extends Panel {

    public MainPanel() {
        // Declare Main Panel
        setVisible(true);
        setSize(150,150);
        Button[] buttons = new Button[5];
        Button bolusWizardButton = new BolusWizardButton("Bolus Wizard");
        Button editSettingsButton = new HomeButton("Edit Settings");
        Button testBloodSugarButton = new HomeButton("Test Blood Sugar");
        Button viewHistoryButton = new HomeButton("View History");
        Button exitButton = new ExitButton("Exit");

        buttons[0] = (Button) add(bolusWizardButton);
        buttons[1] = (Button) add(editSettingsButton);
        buttons[2] = (Button) add(testBloodSugarButton);
        buttons[3] = (Button) add(viewHistoryButton);
        buttons[4] = (Button) add(exitButton);
    }
}
