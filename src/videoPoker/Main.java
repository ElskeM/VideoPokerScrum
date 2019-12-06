package videoPoker;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) {

		        System.out.println("Välkommen till Video Poker");
		        System.out.println("Nu kör vi!");
		        System.out.println();
		        VideoPoker videoPoker = new VideoPoker();

		        String s;
		        int choice = 0;
		        boolean loop = true;
		        Scanner in = new Scanner(System.in);

		        do {
		            System.out.println("|*********************************|");
		            System.out.println("|    Vad vill du göra?            |");
		            System.out.println("|    1: Spela                     |");
		            System.out.println("|    2: Stand                     |");
		            System.out.println("|    3: Reset                     |");
		            System.out.println("|    4: Regler                    |");
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
		            	new Readfile().readfile();
		                videoPoker.changeCards();
		                break;
		            case 2:
//		                videoPoker.stand();
		                break;
		            case 3:
		                videoPoker.reset();
		                break;
		            case 4:
		            	    System.out.println("|***********************************************************************************************|");
				            System.out.println("|       Spelregler                                                                           	|");
				            System.out.println("|	Du kan byta hur många kort du vill, men bara en gång 								        |");
				            System.out.println("|                                                                                               |");
				            System.out.println("|    9: ROYAL FLUSH             -- Tio, knekt, dam, kung och ess i samma kortsvit         250x  |");
				            System.out.println("|    8: FÄRGSTEGE               -- Straight Flush - Fem kort i rad i samma kortsvit        50x  |");
				            System.out.println("|    7: FYRTAL                  -- Fyra kort med samma valör                               25x  |");
				            System.out.println("|    6: KÅK                     -- Ett par och en triss                                     9x  |");
				            System.out.println("|    5: FÄRG                    -- Fem kort med samma kortsvit                              6x  |");
				            System.out.println("|    4: STEGE                   -- Fem kort i rad                                           4x  |");
				            System.out.println("|    3: TRISS                   -- Tre kort med samma valör                                 3x  |");
				            System.out.println("|    2: TVÅPAR                  -- 2 X Två kort med samma valör                             2x  |");
				            System.out.println("|    1: PAR                     -- Två knektar eller bättre                                 1x  |");
				            System.out.println("|***********************************************************************************************|");
				            break;
		            case 0:		            	
		            	new WriteFile().writeFile(videoPoker.getCredit());
		                System.out.println("Tack för att du spelade Video Poker!");
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
