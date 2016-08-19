package com.ia.pokerhand.model;

public enum TypeOfHand {
	
	NOTHING(0), ONE_PAIR(1), TWO_PAIRS(2), THREE_OF_A_KIND(3), STRAIGHT(4), FLUSH(5), 
	FULL_HOUSE(6), FOUR_OF_A_KIND(7), STRAIGHT_FLUSH(8), ROYAL_FLUSH(9);
	
	private int value;

	TypeOfHand(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public static TypeOfHand getInstance(int value) {
		switch(value) {
		case 0: return TypeOfHand.NOTHING;
		case 1: return TypeOfHand.ONE_PAIR;
		case 2: return TypeOfHand.TWO_PAIRS;
		case 3: return TypeOfHand.THREE_OF_A_KIND;
		case 4: return TypeOfHand.STRAIGHT;
		case 5: return TypeOfHand.FLUSH;
		case 6: return TypeOfHand.FULL_HOUSE;
		case 7: return TypeOfHand.FOUR_OF_A_KIND;
		case 8: return TypeOfHand.STRAIGHT_FLUSH;
		case 9: return TypeOfHand.ROYAL_FLUSH;
		default: return null;
		}
	}
	
}
