package com.peogopin;

import com.peogopin.GamePanel;

import javax.swing.*;

public class World extends JPanel{
	World(){
		// World Window Settings
		JFrame game_window = new JFrame();
		game_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game_window.setResizable(false);
		game_window.setTitle("Peogopin Games");

		GamePanel gamePanel = new GamePanel();
		game_window.add(gamePanel);

		game_window.pack();

		game_window.setLocationRelativeTo(null);
		game_window.setVisible(true);

		gamePanel.startGameThread();
	}
}
