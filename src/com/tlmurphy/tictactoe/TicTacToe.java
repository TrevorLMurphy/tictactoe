package com.tlmurphy.tictactoe;

import javax.swing.*;
import java.awt.*;

/**
 * Basic Tic-Tac-Toe game created by Trevor L. Murphy
 * Main class for Tic-Tac-Toe game.
 */
public class TicTacToe extends JFrame {

    private final CardLayout switcher = new CardLayout();
    private final JPanel switcherPanel = new JPanel(switcher);

    private TicTacToe() throws HeadlessException {
        super("Tic-Tac-Toe");
        init();
    }

    private void init() {
        setVisible(true);
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //App starts in center of screen
        add(switcherPanel);

        Menu gameMenu = new Menu(switcher, switcherPanel);
        Game newGame = new Game(switcher, switcherPanel);

        switcherPanel.add(gameMenu);
        switcherPanel.add(newGame);
    }


    public static void main(String[] args) {
        new TicTacToe();
    }
}
