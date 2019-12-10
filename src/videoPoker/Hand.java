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

	public int getSize() {

		return hand.size();

	}

	public void removeCard(int[] arrayPosition) {
		ListIterator listIterator = hand.listIterator();

		for (int j = arrayPosition.length - 1; j >= 0; j--) {
			hand.remove(arrayPosition[j]);
		}
	}

	public Card removeCard2(int position) {// copy av medoden över,pga JUnit

		return hand.set(3, new Card(1, Suit.Clubs));
	}
	
	public Card removeCard3(int position) {// copy av medoden över,pga JUnit

		return hand.set(4, new Card(1, Suit.Spades));
	}

	public void reset() {
		hand.clear();
	}

	public void sortHand() {
		Collections.sort(hand);
	}

	public Combination handScore() {
		sortHand();

		boolean Pair = false, PairOfJacks = false, TwoPair = false, ThreeOfAKind = false, Straight = false,
				Flush = false, FullHouse = false, FourOfAKind = false, StraightFlush = false, RoyalFlush = false;

		for (int i = 0; i < 4; i++) {

			if (hand.get(i).getValue() == hand.get(i + 1).getValue()
					&& (i - 1 < 0 || hand.get(i - 1).getValue() != hand.get(i).getValue())
					&& (i + 2 > 4 || hand.get(i + 2).getValue() != hand.get(i).getValue())) {
				if (Pair == true) {
					TwoPair = true;
				}
				Pair = true;
				if (TwoPair == false) {
					PairOfJacks = jacksOrBetter();
				}
			}
			if ((i < 4) && hand.get(i).getValue() == hand.get(i + 1).getValue()
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
				}
			}
			if (Flush == true && hand.get(0).getValue() == 1 && hand.get(1).getValue() == 10) {
				RoyalFlush = true;

			}
		}

		FullHouse = ThreeOfAKind & Pair;

		if (RoyalFlush)
			return Combination.RoyalFlush;
		if (StraightFlush)
			return Combination.StraightFlush;
		if (FourOfAKind)
			return Combination.FourOfaKind;
		if (FullHouse)
			return Combination.FullHouse;
		if (Flush)
			return Combination.Flush;
		if (Straight)
			return Combination.Straight;
		if (ThreeOfAKind)
			return Combination.ThreeOfaKind;
		if (TwoPair)
			return Combination.TwoPair;
		if (PairOfJacks)
			return Combination.PairOfJacksOrBetter;
		else
			return Combination.NoCombination;

	}

	public boolean jacksOrBetter() {
		int value = 0, aces = 0, jacks = 0, queens = 0, kings = 0, nothing = 0;
		boolean jacksOrBetter;

		for (int i = 0; i < hand.size(); i++) {
			value = hand.get(i).getValue();
			switch (value) {
			case 1:
				aces++;
			case 11:
				jacks++;
			case 12:
				queens++;
			case 13:
				kings++;
			default:
				nothing++;
			}
		}
		// check if there are more than one highcards
		if (aces == 2 || jacks == 2 || queens == 2 || kings == 2) {
			return jacksOrBetter = true;
		} else {
			return jacksOrBetter = false;
		}

	}

	public void removeCard(int i) {
		hand.remove(i);
	}

}
