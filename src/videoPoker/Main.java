package videoPoker;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Välkommen till Blackjack!");
        System.out.println("Nu kör vi!");
        System.out.println();
        Blackjack blackjack = new Blackjack();
        
        String s;
        int choice = 0;
        boolean loop = true;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("|*********************************|");
            System.out.println("|    Vad vill du göra?            |");
            System.out.println("|    1: Hit                       |");
            System.out.println("|    2: Stand                     |");
            System.out.println("|    3: Reset                     |");
            System.out.println("|    0: Quit                      |");
            System.out.println("|*********************************|");
            s = in.nextLine();
            
            try {
                choice = Integer.parseInt(s);     
                loop = false;
            }
            catch (Exception e)
            {
                System.out.println("Felaktig inmatning! Endast tal!");
            }
            
            switch (choice) {
            case 1:
                blackjack.hit();
                break;
            case 2:
                blackjack.stand();
                break;
            case 3:
                blackjack.reset();
                break;
            case 0:
                System.out.println("Tack för att du spelade Blackjack!");
                System.out.println("Vi ses nästa gång!");
                in.close();
                break;
            default:
                    System.out.println("Felaktig inmatning!");
                    break;
            }
            
        } while (choice != 0);
    }
}

