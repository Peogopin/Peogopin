package com.peogopin.durak;

import java.util.ArrayList;
import java.util.List;

public class CardDiscardPile {
	List<Card> cards = new ArrayList<>();

	public void add_card(Card card){
		if (!this.cards.contains(card))
			cards.add(card);
	}

	public void clear_card_discard_pile(){
		this.cards = new ArrayList<>();
	}

}
