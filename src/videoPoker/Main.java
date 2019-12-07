package videoPoker;
import java.util.Scanner;

import javax.swing.JOptionPane;



public class Main {

	public static void main(String[] args) {
		System.out.println("Välkommen till VideoPoker! Du har " + new Readfile().readfile() + " krediter");
		String regler =   "***************************************************************************************************\n"
						+ "       Spelregler                                                                                  \n"
						+ "	      Du kan byta hur många kort du vill, men bara en gång 								          \n"
						+ "                                                                                                   \n"
						+ "    9: ROYAL FLUSH                -- Tio, knekt, dam, kung och ess i samma kortsvit          250x  \n"
						+ "    8: FÄRGSTEGE                  -- Straight Flush - Fem kort i rad i samma kortsvit         50x  \n"
						+ "    7: FYRTAL                  	 -- Fyra kort med samma valör                                25x  \n"
						+ "    6: KÅK                    	 -- Ett par och en triss                                      9x  \n"
						+ "    5: FÄRG                   	 -- Fem kort med samma kortsvit                               6x  \n"
						+ "    4: STEGE                  	 -- Fem kort i rad                                            4x  \n"
						+ "    3: TRISS                  	 -- Tre kort med samma valör                                  3x  \n"
						+ "    1: PAR                    	 -- Två knektar eller bättre                                  1x  \n"
						+ "***************************************************************************************************\n";


JOptionPane.showMessageDialog(null, regler);


		System.out.println();


		        String s;
		        int choice = 0;
		        boolean loop = true;
		        Scanner in = new Scanner(System.in);

		        do {
				System.out.println("|*********************************|\n"
								 + "|    Vad vill du göra?            |\n"
								 + "|    1: Spela med konto           |\n"
								 + "|    2: Spela utan konto          |\n"
								  +"|    0: Quit                      |\n"
								 + "|*********************************|");


		            s = in.nextLine();

		            try {
		                choice = Integer.parseInt(s);
		                loop = false;
		            }
		            catch (Exception e)
		            {
		                System.out.println("Felaktig inmatning! Endast tal!");
		            }
		            VideoPoker videoPoker= new VideoPoker() ;
		            switch (choice) {
		            case 1:
		            	int credit = Integer.parseInt(new Readfile().readfile());
		            	videoPoker.setCredit(credit);
		                videoPoker.changeCards();
		                break;
		            case 2:
		            	videoPoker= new VideoPoker() ;
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
