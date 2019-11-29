package videoPoker;

public class Card {
	private int value;
	private Suit suit;

	public Card(int value, Suit suit) {
		this.value = value;
		this.suit = suit;
		
	}

	public int getValue() {
		return value;
	}

	public Suit getSuit() {
		return suit;
	}

	@Override
	public String toString() {
		if (value == 1) {
			return "" + "A" + " " + suit.Type;
		}
		else if (value == 11) {
			return "" + "J" + " " + suit.Type;
		}
		else if (value == 12) {
			return "" + "Q" + " " + suit.Type;
		}
		else if (value == 13) {
			return "" + "K" + " " + suit.Type;
		}
		else 
		{ 
		return "" + value + " " + suit.Type;
		}
	}
}