package com.peogopin.durak;

import java.util.ArrayList;
import java.util.List;

public class User {
	private final String name;
	private List<Card> hand_cards = new ArrayList<>();

	// Initialize the class and take some needed stuff
	User(String name){
		this.name = name;
	}

	public void set_hand_cards(List<Card> cards){
		hand_cards = cards;
	}

	public List<Card> get_hand_cards(){
		return hand_cards;
	}

	public void give_card(Card card){
		try {
			if (!(hand_cards.contains(card))){
				hand_cards.add(card);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
