package videoPoker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VideoPoker {
	public static Hand playerHand = new Hand();
	private Hand dealerHand = new Hand();
	private Deck deck = new Deck();
	private int credit = 100;
	private int kontoCredit;
	private int bet = 0;
	private int stBet = 10;
	private String betSvar;

	public VideoPoker() {
		deck.shuffle();
		drawCredit();
		draw();
	}

	public void draw() {
		playerHand.addCards(deck.draw(), deck.draw(), deck.draw(), deck.draw(), deck.draw());
		System.out.println("Du fick: [" + playerHand.getCard(0) + ", " + playerHand.getCard(1) + ", "
				+ playerHand.getCard(2) + ", " + playerHand.getCard(3) + ", " + playerHand.getCard(4) + "]\n");
		changeCards();
	}

	public void changeCards() {
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
					System.out.println("Ange kortens position (1, 2, 3, 4 eller 5)");
					arrayPosition[i] = scanner.nextInt() - 1;
				}
				playerHand.removeCard(arrayPosition);
				for (int i = 0; i < antalKort; i++) {
					playerHand.addCard(deck.draw());
				}
				System.out.println("Du valde att byta ut " + antalKort + " kort.");
				System.out.println("Du har nu följande kort på handen: " + playerHand.getCard(0) + ", "
						+ playerHand.getCard(1) + ", " + playerHand.getCard(2) + ", " + playerHand.getCard(3) + ", "
						+ playerHand.getCard(4));
				placeBet();
				loop = false;
			} else if (answer.equalsIgnoreCase("n")) {
				placeBet();
				loop = false;
			} else {
				System.out.println("Fel! Endast 'y' eller 'n'!");
				loop = true;
			}
		} while (loop != false);
	}

	public void drawCredit() {
		credit -= stBet;
	}

	public void placeBet() {
		boolean betLoop;
		do {
			Scanner s = new Scanner(System.in);
			System.out.println("Vill du placera en bet? y/n");
			String betSvar = s.next();
			if (betSvar.equalsIgnoreCase("y")) {
				System.out.println("Hur många credits vill du satsa?");
				bet = s.nextInt();
				if (bet > credit) {
					System.out.println("Fel! Du kan inte satsa mer än " + credit + " credits");
					betLoop = true;
				} else {
					credit -= bet;
					System.out.println("Du satsade: " + bet
							+ " credits. Nu ska vi kontrollera dina kort på möjliga kombinationer.");
					creditAfterBetting();
					betLoop = false;
				}
			} else if (betSvar.equalsIgnoreCase("n")) {
				System.out.println(
						"Du placerade ingen extra bet. Nu ska vi kontrollera dina kort på möjliga kombinationer.");
				creditAfterBetting();
				betLoop = false;
			} else {
				System.out.println("Fel! Endast 'y' eller 'n'!");
				betLoop = true;
			}
		} while (betLoop != false);
	}

	public void creditAfterBetting() {
		if (playerHand.handScore() == playerHand.handScore().NoCombination) {
			System.out.println("Tyvärr! Du fick ingen kombination! Du har nu " + credit + " credits kvar.");
		} else {
			bet += stBet;
			bet *= playerHand.handScore().value;
			credit += bet;

			kontoCredit = credit;

			bet = 0;
			System.out.println("Grattis! Du fick " + playerHand.handScore() + "! Du vann " + bet + "credits och har nu "
					+ credit + " credits i ditt konto.");
			bet = 0;
		}
	}

	public int setCredit(int credit) {
		this.kontoCredit = credit;
		return kontoCredit;
	}

	public int getCredit() {
		return kontoCredit;

	}

	public void reset() {
		drawCredit();
		playerHand.reset();
		deck = new Deck();
		deck.shuffle();
		draw();
		drawCredit();
	}
}
