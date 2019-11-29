package videoPoker;

public enum Suit {
	Hearts ("♥"),
	Spades ("♠"),
	Diamonds ("♦"),
	Clubs ("♣");

	public String Type;
	
	private Suit(String Type) {
		this.Type = Type;
	}

}
