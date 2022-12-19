package com.peogopin.durak;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class CardDeck {
	private final Integer number_of_card_decks;
	List<Card> cards;
	CardDeck(Integer number_of_card_decks){
		/*
		* Create a card deck
		* :number_of_card_decks: -> int : The amount of card decks that have to be created.
		*/
		this.number_of_card_decks = number_of_card_decks;
		this.cards = create_card_deck(number_of_card_decks);
	}

	public List<Card> get_cards(){
		return this.cards;
	}

	private List<Card> create_card_deck(Integer times){
		/*
		* :times : -> int : The number if card decks that have to be created.
		 */
		List<Card> cards = new ArrayList<>();
		for(int t = 0; t<times; t++)
			for(String card_type : new String[]{"Heart", "Diamond", "Spade", "Club"}) // Heart->Herz ; Diamond->Karo ; Spade->Pik ; Club->Kreuz
				for(String rank : new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K", "A"})
					cards.add(new Card(rank, card_type));
		return cards;
	}

	public void mix_card_deck(){
		Collections.shuffle(this.cards);
	}

	public void reset_card_deck(){
		this.cards = create_card_deck(this.number_of_card_decks);
	}

	public void remove_card(Card card){
		this.cards.remove(card);
	}


}
