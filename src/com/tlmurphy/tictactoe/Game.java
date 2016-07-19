package com.tlmurphy.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Game extends JPanel {

    private static byte playerCount = 0;
    private final ImageIcon X = new ImageIcon("/Users/trevor/Dropbox/code/IdeaProjects/TicTacToe/images/X.png");
    private final ImageIcon O = new ImageIcon("/Users/trevor//Dropbox/code/IdeaProjects/TicTacToe/images/O.png");

    private final JButton[] buttons = new JButton[9];
    CardLayout switcher;
    JPanel switcherPanel;

    public Game(CardLayout switcher, JPanel switcherPanel) {
        this.switcher = switcher;
        this.switcherPanel = switcherPanel;
        init();
    }

    private void init() {
        setVisible(true);
        setLayout(new GridLayout(3, 3));
        addButtons();
    }

    private void addButtons() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            add(buttons[i]);
            addButtonActions(buttons[i]);
        }
    }

    private void addButtonActions(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button.getIcon() != null);
                else {
                    if (playerCount % 2 == 0) button.setIcon(X);
                    else button.setIcon(O);
                    playerCount++;
                }

                // Check for winner after every move in the game
                checkWin();
            }
        });
    }


    private void checkWin() {
        if ((buttons[0].getIcon() == X && buttons[1].getIcon() == X && buttons[2].getIcon() == X) ||
                (buttons[0].getIcon() == X && buttons[4].getIcon() == X && buttons[8].getIcon() == X) ||
                (buttons[2].getIcon() == X && buttons[4].getIcon() == X && buttons[6].getIcon() == X) ||
                (buttons[6].getIcon() == X && buttons[7].getIcon() == X && buttons[8].getIcon() == X) ||
                (buttons[3].getIcon() == X && buttons[4].getIcon() == X && buttons[5].getIcon() == X) ||
                (buttons[0].getIcon() == X && buttons[3].getIcon() == X && buttons[6].getIcon() == X) ||
                (buttons[1].getIcon() == X && buttons[4].getIcon() == X && buttons[7].getIcon() == X) ||
                (buttons[2].getIcon() == X && buttons[5].getIcon() == X && buttons[8].getIcon() == X))
        {
            JOptionPane.showMessageDialog(null, "Player One Has Won!", null, JOptionPane.PLAIN_MESSAGE);
            reset();
            switcher.next(switcherPanel);
        }

        else if ((buttons[0].getIcon() == O && buttons[1].getIcon() == O && buttons[2].getIcon() == O) ||
                (buttons[0].getIcon() == O && buttons[4].getIcon() == O && buttons[8].getIcon() == O) ||
                (buttons[2].getIcon() == O && buttons[4].getIcon() == O && buttons[6].getIcon() == O) ||
                (buttons[6].getIcon() == O && buttons[7].getIcon() == O && buttons[8].getIcon() == O) ||
                (buttons[3].getIcon() == O && buttons[4].getIcon() == O && buttons[5].getIcon() == O) ||
                (buttons[0].getIcon() == O && buttons[3].getIcon() == O && buttons[6].getIcon() == O) ||
                (buttons[1].getIcon() == O && buttons[4].getIcon() == O && buttons[7].getIcon() == O) ||
                (buttons[2].getIcon() == O && buttons[5].getIcon() == O && buttons[8].getIcon() == O))
        {
            JOptionPane.showMessageDialog(null, "Player Two Has Won!", null, JOptionPane.PLAIN_MESSAGE );
            reset();
            switcher.next(switcherPanel);
        }

        if (playerCount == 9) {
            JOptionPane.showMessageDialog(null, "It's a Draw", "DRAW", JOptionPane.PLAIN_MESSAGE);
            reset();
            switcher.next(switcherPanel);
        }
    }

    private void reset() {
        playerCount = 0;
        for (JButton button : buttons) {
            button.setIcon(null);
            button.revalidate();
        }
    }
}
