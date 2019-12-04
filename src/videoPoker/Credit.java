import java.util.Scanner;

public class Credit {


	public void amountCredit() {
		Scanner svar = new Scanner(System.in);
		String A = svar.nextLine();
		double credit = 100;
		System.out.println("Du har " + credit + " krediter kvar. Vad vill du betta? A för att avbryta");

		if(A == "A") {
			System.out.println("Tack för att du spelade!");
			System.exit(0);
			}

		else {
			}

	svar.close();
	}
	public double winCredit() {
		//Combination[] combo = Combination.values();
		int points = Combination.getValue(); //Detta är ej färdigt än
		switch(Combination.getValue()) {
		int krediter = svar.nextInt();
		int credit = 100;
		System.out.println("Du har " + credit + " krediter kvar. Vad vill du betta?");
		int combo = 0;
		switch(combo) {
			case 'A':
				int ett = Combination.StraightFlush.getValue() * krediter + credit;
				System.out.println("Grattis! Du har nu " + ett + "krediter!");
			case 'B':
				int tva = Combination.RoyalFlush.getValue() * krediter + credit;
				System.out.println("Grattis! Du har nu " + tva + "krediter!");
			case 'C':
				int tre = Combination.FourOfaKind.getValue() * krediter + credit;
				System.out.println("Grattis! Du har nu " + tre + "krediter!");
			case 'D':
				int fyra = Combination.FullHouse.getValue() * krediter + credit;
				System.out.println("Grattis! Du har nu " + fyra + "krediter!");
			case 'E':
				int fem = Combination.Flush.getValue() * krediter + credit;
				System.out.println("Grattis! Du har nu " + fem + "krediter!");
			case 'F':
				int sex = Combination.Straight.getValue() * krediter + credit;
				System.out.println("Grattis! Du har nu " + sex + "krediter!");
			case 'G':
				int sju = Combination.ThreeOfaKind.getValue() * krediter + credit;
				System.out.println("Grattis! Du har nu " + sju + "krediter!");
			case 'H':
				int atta = Combination.TwoPair.getValue() * krediter + credit;
				System.out.println("Grattis! Du har nu " + atta + "krediter!");
			case 'I':
				int nio = Combination.PairOfJacks.getValue() * krediter + credit;
				System.out.println("Grattis! Du har nu " + nio + "krediter!");
				break;
			default:
				int tio = credit - krediter;
				System.out.println("Tråkigt! Du har nu " + tio + "krediter kvar.");
		}
		return 0.0;


	svar.close();

	}

}
