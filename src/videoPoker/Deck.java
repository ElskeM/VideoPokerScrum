package videoPoker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

	private List<Card> cards = new ArrayList<>();

	public Deck() {
		for (int i = 0; i < Suit.values().length; i++) {
			for (int j = 1; j < 14; j++) {
				cards.add(new Card(j, Suit.values()[i]));
			}
		}
	}

	public Card draw() {
		Card card = cards.get(0);
		cards.remove(card);
		return card;
	}

	public void shuffle() {
		List<Card> shuffledCards = new ArrayList<>();
		Random random = new Random();
		Card card;

		while (cards.size() > 0) {
			card = cards.get(random.nextInt(cards.size()));
			shuffledCards.add(card);
			cards.remove(card);
		}
		cards = shuffledCards;
	}
}

