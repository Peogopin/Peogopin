package com.peogopin.durak;

public class Card {
	private final String rank;
	private final String card_type;
	Card(String rank, String cardType){
		/*
		Define a GameCard
		 * :rank → str : The rank of the card <-> [1, 2, 3, 4, 5, 6, 7, 8, 9, J, Q, K, A]
		 * :card_type -> str : The type of the card <-> [Heart, Diamond, Spade, Club]
		 */
		this.rank = rank;
		this.card_type = cardType;
	}

	public String get_rank(){
		return this.rank;
	}

	public String get_card_type(){
		return this.card_type;
	}
}
