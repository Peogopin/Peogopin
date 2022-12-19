package com.peogopin.games.durak;
import java.util.List;

public class Game {
	List<User> userList;
	private final Card trump;
	private final CardDeck card_deck;

	public Game(List<User> userList){
		this.card_deck = new CardDeck(1);
		this.userList = userList;

		this.card_deck.mix_card_deck();
		this.distribute_cards();
		this.trump = this.define_trump();
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
