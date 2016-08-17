package com.ia.pokerhand;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	
	private List<Card> cards;
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	private TypeOfHand typeOfHand;
	
	public Hand() {
		cards = new ArrayList<Card>(5);
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public boolean removeCard(Card card) {
		return cards.remove(card);
	}

	public TypeOfHand getTypeOfHand() {
		return typeOfHand;
	}

	public void setTypeOfHand(TypeOfHand typeOfHand) {
		this.typeOfHand = typeOfHand;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Card card : cards) {
			sb.append(card+",");
		}
		sb.append(typeOfHand);
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cards == null) ? 0 : cards.hashCode());
		result = prime * result + ((typeOfHand == null) ? 0 : typeOfHand.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Hand other = (Hand) obj;
		if (cards == null) {
			if (other.cards != null) {
				return false;
			}
		} else {
			for(int i = 0; i < cards.size(); i++) {
				if(!cards.get(i).equals(other.cards.get(i))) {
					return false;
				}
			}
		}
		if (typeOfHand != other.typeOfHand) {
			return false;
		}
		return true;
	}

}
