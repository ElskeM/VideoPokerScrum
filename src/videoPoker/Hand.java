package videoPoker;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	private List<Card> hand; 
	
	public Hand() {
		hand = new ArrayList<Card>();
	}
	
	public Card getCard(int i) {
		return hand.get(i);
	}
	
	public Card getCard() {
		return hand.get(hand.size() - 1);
	}
	
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public void addCards(Card card1, Card card2) {
		hand.add(card1);
		hand.add(card2);
	}
	
	public void reset() {
		hand.clear();
	}
	
	public int score() {
		int score = 0, value = 0, aces = 0;
		// get all values in hand, add them to score
		for (int i = 0; i < hand.size(); i++) {
			value = hand.get(i).getValue();
			switch (value) {
			case 1:
				aces++;
				break;
			case 11:
			case 12:
			case 13:
				score += 10;
				break;
			default:
				score += value;
				break;
			}
		}
		// check if there are more thanone ace
		if (aces > 0) {
			int maxScore = score + 11 + aces - 1;

			if (maxScore <= 21) {
				return maxScore;
			}
			return score + aces;
		}
		return score;
	}

}
