package com.ia.pokerhand;

public enum Suit {

	HEARTS(1), SPADES(2), DIAMONDS(3), CLUBS(4);
	
	private int value;
	
	Suit(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public static Suit getInstance(int value) {
		switch(value) {
		case 1: return Suit.HEARTS;
		case 2: return Suit.SPADES;
		case 3: return Suit.DIAMONDS;
		case 4: return Suit.CLUBS;
		default: return null;
		}
	}
	
}
