package videoPoker;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Tester {

	
	private Card c;
	private Deck d;
	private Hand h;
	

	@BeforeEach
	void skapaSpel2() {
		d = new Deck();
		h = new Hand();	
	}
	
//	@Test
//	void femKort()
//	{}

	@Test
	void testScoreThreeOfaKind() {
		h.addCard(new Card (9, Suit.Hearts));
		h.addCard(new Card(9, Suit.Spades));
		h.addCard(new Card(9, Suit.Clubs));
		h.addCard(new Card(4, Suit.Spades));
		h.addCard(new Card(6, Suit.Spades));
		assertEquals(Combination.ThreeOfaKind, h.handScore());
	}

	void testScoreFourOfaKind() {
		h.addCard(new Card (12, Suit.Hearts));
		h.addCard(new Card(12, Suit.Spades));
		h.addCard(new Card(12, Suit.Clubs));
		h.addCard(new Card(12, Suit.Diamonds));
		h.addCard(new Card(6, Suit.Spades));
		assertEquals(Combination.FourOfaKind, h.handScore());
	}

	@Test
	void testScoreJacksOrBetter() {
		h.addCard(new Card(11, Suit.Hearts));
		h.addCard(new Card(11, Suit.Diamonds));
		h.addCard(new Card(6, Suit.Clubs));
		h.addCard(new Card(7, Suit.Spades));
		h.addCard(new Card(4, Suit.Spades));
		assertEquals(Combination.PairOfJacksOrBetter, h.handScore());
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
	void testScoreStrightFlush() {
		h.addCard(new Card(2, Suit.Spades));
		h.addCard(new Card(3, Suit.Spades));
		h.addCard(new Card(4, Suit.Spades));
		h.addCard(new Card(5, Suit.Spades));
		h.addCard(new Card(6, Suit.Spades));
		assertEquals(Combination.StraightFlush, h.handScore());
	}
//	@Test
//	void testScoreRoyalFlush() {
//		h.addCard(new Card(1, Suit.Spades));
//		h.addCard(new Card(10, Suit.Spades));
//		h.addCard(new Card(11, Suit.Spades));
//		h.addCard(new Card(12, Suit.Spades));
//		h.addCard(new Card(13, Suit.Spades));
//		assertEquals(Combination.RoyalFlush, h.handScore());
//	}
	
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
	
}



