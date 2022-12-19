package com.peogopin.durak;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Game extends JPanel {
	List<User> userList;
	private final Card trump;
	private final CardDeck card_deck;

	Game(List<User> userList){
		this.card_deck = new CardDeck(1);
		this.userList = userList;

		this.card_deck.mix_card_deck();
		this.distribute_cards();
		this.trump = this.define_trump();

		// Game Window Settings
		JFrame game_window = new JFrame();
		game_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game_window.setResizable(false);
		game_window.setTitle("Durak Game");

		GamePanel gamePanel = new GamePanel();
		game_window.add(gamePanel);

		game_window.pack();

		game_window.setLocationRelativeTo(null);
		game_window.setVisible(true);

		gamePanel.startGameThread();
	}


	private void distribute_cards(){
		for (int r = 1; r<=6; r++ )
			for (User u : this.userList){
				Card distribution_card = this.card_deck.get_cards().get(0);
				u.give_card(distribution_card);
				this.card_deck.remove_card(distribution_card);
			}
	}

	public Card define_trump(){
		return this.card_deck.get_cards().get(this.card_deck.get_cards().size() - 1);
	}

	public Card get_trump(){
		return this.trump;
	}
}
