package videoPoker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

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

	public void addCards(Card card1, Card card2, Card card3, Card card4, Card card5) {
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		hand.add(card4);
		hand.add(card5);
	}

	public void removeCard(int[] arrayPosition) {
		ListIterator listIterator = hand.listIterator();

		for (int j = arrayPosition.length - 1; j >= 0; j--) {
			hand.remove(arrayPosition[j]);
		}
	}

	public void reset() {
		hand.clear();
	}

	public void sortHand() {
		Collections.sort(hand);
	}

	public String handScore() {
		sortHand();
		
		boolean Pair = false, PairOfJacks = false, TwoPair = false, ThreeOfAKind = false, Straight = false,
				Flush = false, FullHouse = false, FourOfAKind = false, StraightFlush = false, RoyalFlush = false;
		
		for (int i = 0; i < 4; i++) {

			if (hand.get(i).getValue() == hand.get(i + 1).getValue()
					&& (i - 1 < 0 || hand.get(i - 1).getValue() != hand.get(i).getValue())
					&& (i + 2 > 4 || hand.get(i + 2).getValue() != hand.get(i).getValue())) {
				if (Pair == true) {
					TwoPair = true;
				} if (TwoPair == false) {
					PairOfJacks = jacksOrBetter();
				}
			} 

			if ((i < 2) && hand.get(i).getValue() == hand.get(i + 1).getValue()
					&& hand.get(i + 1).getValue() == hand.get(i + 2).getValue() && hand.get(i + 2) == hand.get(i + 3)) {
				FourOfAKind = true;
			}

			if (!FourOfAKind && (i < 3) && hand.get(i).getValue() == hand.get(i + 1).getValue()
					&& hand.get(i + 1).getValue() == hand.get(i + 2).getValue()) {
				ThreeOfAKind = true;
			}
			if ((i < 1)
					&& (hand.get(i + 4).getValue() == 12 && hand.get(i).getValue() == 0
							|| hand.get(i).getValue() + 1 == hand.get(i + 1).getValue())
					&& hand.get(i + 1).getValue() + 1 == hand.get(i + 2).getValue()
					&& hand.get(i + 2).getValue() + 1 == hand.get(i + 3).getValue()
					&& hand.get(i + 3).getValue() + 1 == hand.get(i + 4).getValue()) {
				Straight = true;
			}
			if ((i < 1) && hand.get(i).getSuit() == hand.get(i + 1).getSuit()
					&& hand.get(i + 1).getSuit() == hand.get(i + 2).getSuit()
					&& hand.get(i + 2).getSuit() == hand.get(i + 3).getSuit()
					&& hand.get(i + 3).getSuit() == hand.get(i + 4).getSuit()) {
				Flush = true;
				if (Straight == true) {
					StraightFlush = true;
					RoyalFlush = hand.get(0).getValue() == 1 && hand.get(1).getValue() == 10;
				}
			}
		}

		FullHouse = ThreeOfAKind & PairOfJacks;

		if (RoyalFlush)
			return "Du har en Royal Flush!";
		if (StraightFlush)
			return "Du har en Straight Flush!";
		if (FourOfAKind)
			return "Du har en Four of a Kind!";
		if (FullHouse)
			return "Du har en FullHouse!";
		if (Flush)
			return "Du har en Flush!";
		if (Straight)
			return "Du har en Straight!";
		if (ThreeOfAKind)
			return "Du har en Three of a Kind!";
		if (TwoPair)
			return "Du har Two Pair!";
		if (PairOfJacks)
			return "Du har ett Pair Jacks or Better!";
		else
			return "Du har ingenting!";

	}

	public boolean jacksOrBetter() {
		int value = 0, aces = 0, jacks = 0, queens = 0, kings = 0, nothing = 0;
		boolean jacksOrBetter = false;
		// get all values in hand, add them to score
		for (int i = 0; i < hand.size(); i++) {
			value = hand.get(i).getValue();
			switch (value) {
			case 1:
				aces++;
				//break;
			case 11:
				jacks++;
				//break;
			case 12:
				queens++;
				//break;
			case 13:
				kings++;
				//break;
			default:
				nothing++;
				//break;
			}
		}
		// check if there are more than one highcards
		if (aces > 1 || jacks > 1 || queens > 1 || kings > 1) {
			jacksOrBetter = true;
		}
		return jacksOrBetter;
	}

}
