package videoPoker;

public class Blackjack {
	private Hand playerHand = new Hand();
	private Hand dealerHand = new Hand();
	private Deck deck = new Deck();
	private int losses = 0;
	private int wins = 0;
	
	public Blackjack() {
		deck.shuffle();
		draw();
	}
	
	public void draw() {
		playerHand.addCards(deck.draw(), deck.draw(), deck.draw(), deck.draw(), deck.draw());
		// dealerHand.addCards(deck.draw(), deck.draw());
		System.out.println("Du fick: " + playerHand.getCard(0) + ", " + playerHand.getCard(1) + " (" + playerHand.score() + ")");	
		// System.out.println("Dealern fick: " + dealerHand.getCard(0) + " och ett gömt kort.");
		
		if ( playerHand.score() == 21) {
			System.out.println("Wow! du fick BLACKJACK.");
			stand();
		}	
	}
	
	public void hit() {
		playerHand.addCard(deck.draw());
		System.out.println("Du fick: " + playerHand.getCard() + " (" + "Poäng: " + playerHand.score() + ")");
		System.out.println("------------------------------");
		if (playerHand.score() > 21) {
			winner();
		}
	}
	
	public void stand() {
		System.out.println("Här kommer dealerns andra kort: " + dealerHand.getCard(1) + " Dealern har nu: (" + dealerHand.score() + ")" );
		if (dealerHand.score() < 17) {
			System.out.println("Dealern ska ta ett kort till.");
		}
		// Dealer drar kort tills poäng är mer än 17
		while (dealerHand.score() < 17) {
			Card card = deck.draw();
			dealerHand.addCard(card);
			System.out.println("Dealern fick: " + card + " Dealern har nu: (" + dealerHand.score() + ") poäng.");
		}
		System.out.println("Dealern fick: (" + dealerHand.score() + ") poäng");
		winner();
	}
	
	private void winner() {
		if (playerHand.score() > 21) {
			losses++;
			System.out.println("Du förlorade! (Poäng är högre än 21)");
			System.out.println("Wins: " + wins + "   Losses: " + losses);
			System.out.println("------------------------------");
		} else if (dealerHand.score() >= playerHand.score() && dealerHand.score() <= 21) {
			losses++;
			System.out.println("Du förlorade! (Poäng är mindre än/lika med dealerns)");
			System.out.println("Wins: " + wins + "   Losses: " + losses);
			System.out.println("------------------------------");
		} else {
			wins++;
			System.out.println("Du vann!");
			System.out.println("Wins: " + wins + "   Losses: " + losses);
			System.out.println("------------------------------");
		}
		System.out.println("\nVill du köra en gång till? Annars kan du välja 0 för att avsluta spelet.");
		System.out.println();
		reset();
	}
	
	public void reset() {
		playerHand.reset();
		dealerHand.reset();
		deck = new Deck();
		deck.shuffle();
		draw();
	}
	
}