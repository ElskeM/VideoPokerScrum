package videoPoker;

import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

	public static void main(String[] args) {

		System.out.println();

		String s;
		int choice = 0;
		boolean loop = true;
		Scanner in = new Scanner(System.in);
		System.out.println("Välkommen till VideoPoker! Nu kör vi!");
		System.out.println();
		VideoPoker videoPoker = new VideoPoker();

		do {
			System.out.println("|*********************************|\n" + "|    Vad vill du göra?            |\n"
					+ "|    1: Fortsätta spela           |\n" + "|    2: Visa regler               |\n"
					+ "|    0: Quit                      |\n" + "|*********************************|");

			s = in.nextLine();

			try {
				choice = Integer.parseInt(s);
				loop = false;
			} catch (Exception e) {
				System.out.println("Felaktig inmatning! Endast tal!");
			}

			switch (choice) {
			case 1:
				videoPoker.reset();
				break;
			case 2:
				Regel regel = new Regel();
				break;
			case 0:
				new WriteFile().writeFile(videoPoker.getCredit());
				System.out.println("Tack för att du spelade Video Poker!");
				System.out.println("Vi ses nästa gång!");
				System.exit(0);
				break;
			default:
				System.out.println("Felaktig inmatning!");
				break;
			}

		} while (choice != 0);

	}

}

class Regel extends JFrame {
	public Regel() {// konstruktor ,anropas automatisk

//regel är nu i Label så spelare kan alltid titta på regler
		JLabel reg = new JLabel("<html><body><table border='0'>" + "<tr>"
				+ "<td>*****************************************************************************</td>" + "</tr>"
				+ "<tr>" + "<td></td><td>Spelregler </td>" + "</tr>" + "<tr>"
				+ "<td></td><td>Du kan byta hur många kort du vill, men bara en gång </td>	" + "</tr>"
				+ "<tr>--------------------------------------------------------------------------------------------------</tr>"
				+ "<tr>"
				+ "<td>9: ROYAL FLUSH </td><td>Tio, knekt, dam, kung och ess i samma kortsvit</td><td>250x</td>"
				+ " </tr>"
				+ "<tr>--------------------------------------------------------------------------------------------------</tr>"
				+ "<tr>"
				+ "<td>8: STRAIGHT FLUSH </td><td>Straight Flush - Fem kort i rad i samma kortsvit</td><td>50x</td>"
				+ "</tr>"
				+ "<tr>--------------------------------------------------------------------------------------------------</tr>"
				+ "<tr>" + "<td>7: FOUR OF KIND</td><td>Fyra kort med samma valör</td><td>25x </td>" + "</tr>"
				+ "<tr>--------------------------------------------------------------------------------------------------</tr>"
				+ "<tr>" + "<td>6: FULL HOUSE</td><td>Ett par och en triss</td><td> 9x</td>" + "</tr>"
				+ "<tr>--------------------------------------------------------------------------------------------------</tr>"
				+ "<tr>" + "<td>5: FLUSH </td><td>Fem kort med samma kortsvit</td><td>6x</td>" + "</tr>"
				+ "<tr>--------------------------------------------------------------------------------------------------</tr>"
				+ "<tr>" + "<td>4: STRAIGHT  </td><td>Fem kort i rad</td><td>4x</td>" + "</tr>"
				+ "<tr>--------------------------------------------------------------------------------------------------</tr>"
				+ "<tr>" + "<td>3: THREE OF A KIND</td><td>Tre kort med samma valör</td>3x<td>" + " </tr>"
				+ "<tr>--------------------------------------------------------------------------------------------------</tr>"
				+ "<tr>" + "<td>2: TWO PAIR</td><td>Två knektar eller bättre </td><td>2x<td>" + " </tr>"
				+ "<tr>--------------------------------------------------------------------------------------------------</tr>"
				+ "<tr>" + "<td>1 : PAIR OF JACKS OR BETTER  </td><td>Ett knekt eller bättre i rad</td><td>1x</td>"
				+ "</tr>"
				+ "<tr>--------------------------------------------------------------------------------------------------</tr>"
				+ "<tr>" + "<td>3: NO COMBINATION</td><td>Inga kombination</td>0x<td>" + " </tr>"
				+ "<tr>--------------------------------------------------------------------------------------------------</tr>"

				+ "<tr>*****************************************************************************"

				+ "</tr>" + "</table></body></html>", JLabel.CENTER);

		add(reg);// placera reg i fönster
		reg.setOpaque(true);
		reg.setBackground(Color.GREEN);
		reg.setForeground(Color.BLACK);
		reg.setFont((new Font("SansSerif", Font.ITALIC, 12)));

		setSize(900, 600);
		setVisible(true);

	}

}
