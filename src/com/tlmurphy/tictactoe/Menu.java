package com.tlmurphy.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JPanel {

    //private final JButton singleButton = new JButton("Single Player");
    private final JButton playButton = new JButton("Play");
    private final JButton helpButton = new JButton("Help");
    private final JButton quitButton = new JButton("Quit");

    CardLayout switcher;
    JPanel switcherPanel;

    public Menu(CardLayout switcher, JPanel switcherPanel) {
        init();
        this.switcher = switcher;
        this.switcherPanel = switcherPanel;
        userSelection();
    }

    private void init() {
        setVisible(true);
        setLayout(new GridLayout(3, 0));
        addButtons();
    }

    private void addButtons() {
        //add(singleButton);
        add(playButton);
        add(helpButton);
        add(quitButton);
    }

    private void userSelection() {
//        singleButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                switcher.next(switcherPanel);
//            }
//        });

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switcher.next(switcherPanel);
            }
        });

        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String helpText = "Select Play to play a game of tic-tac-toe with a friend.\n" +
                                  "Select Quit to exit the app.";

                JOptionPane.showMessageDialog(null, helpText, "HELP", JOptionPane.PLAIN_MESSAGE);
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}

