package videoPoker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Tester {

	private Card c;
	private Deck d;
	private Hand h;
	private List<Card> hand;

	@BeforeEach
	void skapaSpel2() {
		d = new Deck();
		h = new Hand();
	}


	@Test
	void testScoreThreeOfaKind() {
		h.addCard(new Card(9, Suit.Hearts));
		h.addCard(new Card(9, Suit.Spades));
		h.addCard(new Card(9, Suit.Clubs));
		h.addCard(new Card(4, Suit.Spades));
		h.addCard(new Card(6, Suit.Spades));
		assertEquals(Combination.ThreeOfaKind, h.handScore());
	}

//	@Test
//	void testScoreFourOfaKind() {
//		h.addCard(new Card(10, Suit.Hearts));
//		h.addCard(new Card(10, Suit.Spades));
//		h.addCard(new Card(10, Suit.Clubs));
//		h.addCard(new Card(10, Suit.Diamonds));
//		h.addCard(new Card(6, Suit.Spades));
//		assertEquals(Combination.FourOfaKind, h.handScore());
//	}

	@Test
	void testScoreJacksOrBetter() {
		h.addCard(new Card(12, Suit.Hearts));
		h.addCard(new Card(12, Suit.Diamonds));
		h.addCard(new Card(6, Suit.Clubs));
		h.addCard(new Card(7, Suit.Spades));
		h.addCard(new Card(4, Suit.Spades));
		assertEquals(Combination.PairOfJacksOrBetter, h.handScore());
	}

	@Test
	void testScoreTwoPair() {
		h.addCard(new Card(12, Suit.Hearts));
		h.addCard(new Card(12, Suit.Diamonds));
		h.addCard(new Card(7, Suit.Clubs));
		h.addCard(new Card(7, Suit.Spades));
		h.addCard(new Card(4, Suit.Spades));
		assertEquals(Combination.TwoPair, h.handScore());
	}

	@Test
	void testScoreFlush() {
		h.addCard(new Card(2, Suit.Spades));
		h.addCard(new Card(3, Suit.Spades));
		h.addCard(new Card(5, Suit.Spades));
		h.addCard(new Card(7, Suit.Spades));
		h.addCard(new Card(10, Suit.Spades));
		assertEquals(Combination.Flush, h.handScore());
	}

	@Test
	void testScoreStraight() {
		h.addCard(new Card(2, Suit.Spades));
		h.addCard(new Card(3, Suit.Clubs));
		h.addCard(new Card(4, Suit.Spades));
		h.addCard(new Card(5, Suit.Hearts));
		h.addCard(new Card(6, Suit.Spades));
		assertEquals(Combination.Straight, h.handScore());
	}

	@Test
	void testScoreStraightFlush() {
		h.addCard(new Card(2, Suit.Spades));
		h.addCard(new Card(3, Suit.Spades));
		h.addCard(new Card(4, Suit.Spades));
		h.addCard(new Card(5, Suit.Spades));
		h.addCard(new Card(6, Suit.Spades));
		assertEquals(Combination.StraightFlush, h.handScore());
	}

	@Test
	void testScoreRoyalFlush() {
		h.addCard(new Card(1, Suit.Spades));
		h.addCard(new Card(10, Suit.Spades));
		h.addCard(new Card(11, Suit.Spades));
		h.addCard(new Card(12, Suit.Spades));
		h.addCard(new Card(13, Suit.Spades));
		assertEquals(Combination.RoyalFlush, h.handScore());
	}

	@Test
	void testScoreFullHouse() {
		h.addCard(new Card(10, Suit.Spades));
		h.addCard(new Card(10, Suit.Diamonds));
		h.addCard(new Card(8, Suit.Spades));
		h.addCard(new Card(8, Suit.Clubs));
		h.addCard(new Card(8, Suit.Diamonds));
		assertEquals(Combination.FullHouse, h.handScore());
	}

	@Test
	void testScoreNoCombination() {
		h.addCard(new Card(2, Suit.Spades));
		h.addCard(new Card(3, Suit.Diamonds));
		h.addCard(new Card(5, Suit.Spades));
		h.addCard(new Card(8, Suit.Clubs));
		h.addCard(new Card(10, Suit.Spades));
		assertEquals(Combination.NoCombination, h.handScore());
	}

	@Test
	void testScoreNoCombinationPair() {
		h.addCard(new Card(2, Suit.Spades));
		h.addCard(new Card(3, Suit.Diamonds));
		h.addCard(new Card(5, Suit.Spades));
		h.addCard(new Card(10, Suit.Clubs));
		h.addCard(new Card(10, Suit.Spades));
		assertEquals(Combination.NoCombination, h.handScore());
	}

	@Test
	void testFemKort() {
		Hand hand2 = new Hand();

		hand2.addCards(new Card(2, Suit.Spades), new Card(3, Suit.Diamonds), new Card(5, Suit.Spades),
				new Card(10, Suit.Clubs), new Card(10, Suit.Spades));

		assertEquals(5, hand2.getSize());
	}

	@Test
	void testRemovCard() {
		Hand hand3 = new Hand();
		Hand hand4 = new Hand();

		hand3.addCards(new Card(2, Suit.Spades), new Card(3, Suit.Diamonds), new Card(5, Suit.Spades),
				new Card(10, Suit.Clubs), new Card(10, Suit.Spades));

		hand4.addCards(new Card(2, Suit.Spades), new Card(3, Suit.Diamonds), new Card(5, Suit.Spades),
				new Card(1, Suit.Clubs), new Card(10, Suit.Spades));

		for (int i = 0; i <= 4; i++) {
			System.out.println(hand3.getCard(i));
		}
		System.out.println();
		for (int i = 0; i <= 4; i++) {
			System.out.println(hand4.getCard(i));
		}

		hand3.removeCard2(3); // anropa metoden i hand som ändrar kort på position 3
							  // och sätter samma värde och suit som kort i hand4
							  //1, Suit.Clubs
		System.out.println();

		for (int i = 0; i <= 4; i++) {
			System.out.println(hand3.getCard(i));
		}
		System.out.println();
		for (int i = 0; i <= 4; i++) {
			System.out.println(hand4.getCard(i));
		}

		for (int i = 0; i <= 4; i++) {
			assertEquals(hand4.getCard(i), hand3.getCard(i));
		}

	}

}
