package com.ia.pokerhand.model;

public enum Rank {
	
	ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), 
	EIGTH(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);
	
	private int value;

	Rank(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public static Rank getInstance(int value) {
		switch(value) {
		case 1: return Rank.ACE;
		case 2: return Rank.TWO;
		case 3: return Rank.THREE;
		case 4: return Rank.FOUR;
		case 5: return Rank.FIVE;
		case 6: return Rank.SIX;
		case 7: return Rank.SEVEN;
		case 8: return Rank.EIGTH;
		case 9: return Rank.NINE;
		case 10: return Rank.TEN;
		case 11: return Rank.JACK;
		case 12: return Rank.QUEEN;
		case 13: return Rank.KING;
		default: return null;
		}
	}
}
