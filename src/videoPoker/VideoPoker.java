package videoPoker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VideoPoker {
	private Hand playerHand = new Hand();
	private Hand dealerHand = new Hand();
	private Deck deck = new Deck();
	private int losses = 0;
	private int wins = 0;

	public VideoPoker() {
		deck.shuffle();
		draw();
	}

	public void draw() {
		playerHand.addCards(deck.draw(), deck.draw(), deck.draw(), deck.draw(), deck.draw());
		System.out.println("Du fick: [" + playerHand.getCard(0) + ", " + playerHand.getCard(1) + ", "
				+ playerHand.getCard(2) + ", " + playerHand.getCard(3) + ", " + playerHand.getCard(4) + "]\n");
		hit();
	}

	public void hit() {

		boolean loop;
		
		do {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Vill du byta ut något kort? y/n");
			String answer = scanner.next();
			

			if (answer.equalsIgnoreCase("y")) {
				System.out.println("Hur många kort vill du byta ut? (max 5)");
				int antalKort = scanner.nextInt();
				int[] arrayPosition = new int[antalKort];

				for (int i = 0; i < arrayPosition.length; i++) {
					System.out.println("Ange kortens position (1, 2, 3, 4 eller 5");
					arrayPosition[i] = scanner.nextInt()-1;
				}
				playerHand.removeCard(arrayPosition);

				for (int i = 0; i < antalKort; i++) {
					playerHand.addCard(deck.draw());
				}
				System.out.println("Du valde att byta ut " + antalKort + " kort.");
				System.out.println("Du har nu följande kort på handen: " + playerHand.getCard(0) + ", "
						+ playerHand.getCard(1) + ", " + playerHand.getCard(2) + ", " + playerHand.getCard(3) + ", "
						+ playerHand.getCard(4));
				
				stand();
				loop = false;

			} 
			else if (answer.equalsIgnoreCase("n")) {
				loop = false;
				stand();
			} 
			else {
				System.out.println("Fel! Endast 'y' eller 'n'!");
				loop = true;
			}
		} while (loop != false);

	}

	public void stand() {
		System.out.println("Här kommer stand metoden :-)");
//		System.out.println("Här kommer dealerns andra kort: " + dealerHand.getCard(1) + " Dealern har nu: ("
//				+ dealerHand.score() + ")");
//		if (dealerHand.score() < 17) {
//			System.out.println("Dealern ska ta ett kort till.");
//		}
//		// Dealer drar kort tills poäng är mer än 17
//		while (dealerHand.score() < 17) {
//			Card card = deck.draw();
//			dealerHand.addCard(card);
//			System.out.println("Dealern fick: " + card + " Dealern har nu: (" + dealerHand.score() + ") poäng.");
//		}
//		System.out.println("Dealern fick: (" + dealerHand.score() + ") poäng");
//		winner();
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
	//	dealerHand.reset();
		deck = new Deck();
		deck.shuffle();
		draw();
	}

}