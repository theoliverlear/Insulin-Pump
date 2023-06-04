package CondensedApproach;

import java.awt.*;
import java.awt.event.*;

class GUI {
    // Highest Order to Lowest Order
    static Frame frame;

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
    GUI() {
        // * General Order of Instantiation
        // * Declares named Object
        // 1. setTitle()
        // 2. setName()
        // 3. setVisible()
        // 4. setLocation()
        // 5. setSize()
        // 6. add()
        // * proceeding sorted logistically
        // * end with ActionEvent listeners
        // Highest Order to Lowest Order
        // -----------Frame----------------
        frame = new Frame();
        frame.setTitle("Insulin Pump GUI");
        frame.setName("Frame");
        frame.setVisible(true);
        frame.setLocation((int) getCenter(screenWidth),
                          (int) getCenter(screenHeight));
        frame.setSize(initSize);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                System.exit(0);
            }
        });

        // -----------BoarderLayout----------------
        BorderLayout frameBorderLayout = new BorderLayout();
        frame.setLayout(frameBorderLayout);
        BorderLayout panelBorderLayout = new BorderLayout();
        // -------------Panel---------------
        Panel panel = new Panel();
        panel.setName("Panel");
        panel.setVisible(true);
        frame.add(panel, BorderLayout.NORTH);
        panel.setSize(wideHalfInit);
        panel.setLayout(panelBorderLayout);


        // ----------Exit-Button----------
        Button exitButton = new Button("Exit");
        exitButton.setName("Exit Button");
        exitButton.setVisible(true);
        panel.add(exitButton, BorderLayout.NORTH);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String buttonName = event.getActionCommand();
                if (buttonName.equals("Exit")) {
                    System.exit(0);
                }
            }
        });

        //----------BG-TextField-----------
        TextField bgTextField = new TextField();
        bgTextField.setName("BG TextField");
        bgTextField.setVisible(false);
        panel.add(bgTextField, BorderLayout.WEST);

        //----------Enter-Button-----------
        Button enterButton = new Button("Enter");
        enterButton.setName("Enter Button");
        enterButton.setVisible(false);
        panel.add(enterButton, BorderLayout.EAST);

        //-----------Enter-BG-Button-----------
        Button enterBGButton = new Button("Enter BG");
        enterBGButton.setName("Enter BG Button");
        enterBGButton.setVisible(true);
        panel.add(enterBGButton, BorderLayout.SOUTH);
        enterBGButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String buttonName = event.getActionCommand();
                if (buttonName.equals("Enter BG")) {
                    bgTextField.setVisible(true);
                    enterButton.setVisible(true);
                }
            }
        });
        // -----------Canvas----------------
        Canvas canvas = new Canvas() {
            public void paint(Graphics graphics) {
                String bgInput = bgTextField.getText();
                graphics.setColor(Color.WHITE);
                graphics.fillRect(0, 0, (int) getSize().getWidth(), (int) getSize().getHeight());
                graphics.setColor(Color.BLACK);
                graphics.drawString(bgInput, this.getWidth() / 2, this.getHeight() / 2);
            }
        };
        canvas.setName("Canvas");
        canvas.setVisible(true);
        frame.add(canvas, BorderLayout.SOUTH);
        canvas.setSize(wideHalfInit);
        canvas.setBackground(Color.BLACK);
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bgInput = bgTextField.getText();
                System.out.println(bgInput);
                canvas.repaint();
            }
        });

// TODO: CONNECT PUMP/METER TO COMPUTER AND ADD DATA TO PROGRAM

    }
    public static void main(String[] args) {
        GUI insulinPumpGUI = new GUI();
    }

    // Highest Order to Lowest Order
    public Frame getFrame() {
        return this.frame;
    }
}
