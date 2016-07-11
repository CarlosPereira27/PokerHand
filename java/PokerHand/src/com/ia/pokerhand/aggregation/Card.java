package com.ia.pokerhand.aggregation;

public enum Card {
	
	ACE_OF_HEARTS(0), ACE_OF_SPADES(1), ACE_OF_DIAMONDS(2), ACE_OF_CLUBS(3),
	TWO_OF_HEARTS(4), TWO_OF_SPADES(5), TWO_OF_DIAMONDS(6), TWO_OF_CLUBS(7),
	THREE_OF_HEARTS(8), THREE_OF_SPADES(9), THREE_OF_DIAMONDS(10), THREE_OF_CLUBS(11),
	FOUR_OF_HEARTS(12), FOUR_OF_SPADES(13), FOUR_OF_DIAMONDS(14), FOUR_OF_CLUBS(15),
	FIVE_OF_HEARTS(16), FIVE_OF_SPADES(17), FIVE_OF_DIAMONDS(18), FIVE_OF_CLUBS(19),
	SIX_OF_HEARTS(20), SIX_OF_SPADES(21), SIX_OF_DIAMONDS(22), SIX_OF_CLUBS(23),
	SEVEN_OF_HEARTS(24), SEVEN_OF_SPADES(25), SEVEN_OF_DIAMONDS(26), SEVEN_OF_CLUBS(27),
	EIGTH_OF_HEARTS(28), EIGTH_OF_SPADES(29), EIGTH_OF_DIAMONDS(30), EIGTH_OF_CLUBS(31),
	NINE_OF_HEARTS(32), NINE_OF_SPADES(33), NINE_OF_DIAMONDS(34), NINE_OF_CLUBS(35),
	TEN_OF_HEARTS(36), TEN_OF_SPADES(37), TEN_OF_DIAMONDS(38), TEN_OF_CLUBS(39),
	JACK_OF_HEARTS(40), JACK_OF_SPADES(41), JACK_OF_DIAMONDS(42), JACK_OF_CLUBS(43),
	QUEEN_OF_HEARTS(44), QUEEN_OF_SPADES(45), QUEEN_OF_DIAMONDS(46), QUEEN_OF_CLUBS(47),
	KING_OF_HEARTS(48), KING_OF_SPADES(49), KING_OF_DIAMONDS(50), KING_OF_CLUBS(51);
	
	private int value;

	Card(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public static Card getInstance(int value) {
		switch(value) {
		case 0: return Card.ACE_OF_HEARTS;
		case 1: return Card.ACE_OF_SPADES;
		case 2: return Card.ACE_OF_DIAMONDS;
		case 3: return Card.ACE_OF_CLUBS;
		case 4: return Card.TWO_OF_HEARTS;
		case 5: return Card.TWO_OF_SPADES;
		case 6: return Card.TWO_OF_DIAMONDS;
		case 7: return Card.TWO_OF_CLUBS;
		case 8: return Card.THREE_OF_HEARTS;
		case 9: return Card.THREE_OF_SPADES;
		case 10: return Card.THREE_OF_DIAMONDS;
		case 11: return Card.THREE_OF_CLUBS;
		case 12: return Card.FOUR_OF_HEARTS;
		case 13: return Card.FOUR_OF_SPADES;
		case 14: return Card.FOUR_OF_DIAMONDS;
		case 15: return Card.FOUR_OF_CLUBS;
		case 16: return Card.FIVE_OF_HEARTS;
		case 17: return Card.FIVE_OF_SPADES;
		case 18: return Card.FIVE_OF_DIAMONDS;
		case 19: return Card.FIVE_OF_CLUBS;
		case 20: return Card.SIX_OF_HEARTS;
		case 21: return Card.SIX_OF_SPADES;
		case 22: return Card.SIX_OF_DIAMONDS;
		case 23: return Card.SIX_OF_CLUBS;
		case 24: return Card.SEVEN_OF_HEARTS;
		case 25: return Card.SEVEN_OF_SPADES;
		case 26: return Card.SEVEN_OF_DIAMONDS;
		case 27: return Card.SEVEN_OF_CLUBS;
		case 28: return Card.EIGTH_OF_HEARTS;
		case 29: return Card.EIGTH_OF_SPADES;
		case 30: return Card.EIGTH_OF_DIAMONDS;
		case 31: return Card.EIGTH_OF_CLUBS;
		case 32: return Card.NINE_OF_HEARTS;
		case 33: return Card.NINE_OF_SPADES;
		case 34: return Card.NINE_OF_DIAMONDS;
		case 35: return Card.NINE_OF_CLUBS;
		case 36: return Card.TEN_OF_HEARTS;
		case 37: return Card.TEN_OF_SPADES;
		case 38: return Card.TEN_OF_DIAMONDS;
		case 39: return Card.TEN_OF_CLUBS;
		case 40: return Card.JACK_OF_HEARTS;
		case 41: return Card.JACK_OF_SPADES;
		case 42: return Card.JACK_OF_DIAMONDS;
		case 43: return Card.JACK_OF_CLUBS;
		case 44: return Card.QUEEN_OF_HEARTS;
		case 45: return Card.QUEEN_OF_SPADES;
		case 46: return Card.QUEEN_OF_DIAMONDS;
		case 47: return Card.QUEEN_OF_CLUBS;
		case 48: return Card.KING_OF_HEARTS;
		case 49: return Card.KING_OF_SPADES;
		case 50: return Card.KING_OF_DIAMONDS;
		case 51: return Card.KING_OF_CLUBS;
		default: return null;
		}
	}

}
