package videoPoker;

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
		}
		return 0.0;
		
	}
	
}
