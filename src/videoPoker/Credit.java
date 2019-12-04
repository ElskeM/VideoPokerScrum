package videoPoker;
import java.util.Scanner;

public class Credit {
	public static void main(String[] args) {
		Credit credit = new Credit();
		System.out.println(credit.amountCredit());
	}
	
		public int amountCredit() {
			int credit = 100;
			System.out.println("Du har " + credit + " krediter kvar. Vad vill du betta?");
			Scanner svar = new Scanner(System.in);
			int bett = Integer.parseInt(svar.nextLine());
			
			boolean vinn = true;
			Hand hand = new Hand();
			int combo = Integer.parseInt(hand.handScore());
			svar.close();
					
			if(vinn) {
				int lolFu = combo + bett + credit;
				System.out.println("Grattis! Din kredit är nu: " + lolFu);
				return(lolFu);
			}
			else {
				int lolFu = credit - bett;
				System.out.println("Synd! Din kredit är nu: " + lolFu);
				return(lolFu);
				
				
			}
			
	}
		
}
	



