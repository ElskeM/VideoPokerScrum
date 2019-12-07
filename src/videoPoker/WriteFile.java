package videoPoker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteFile {

	
	
	public void writeFile(int i) {
	
		BufferedWriter bw = null;
	

		try {
			String credit = "" + i;
			File file = new File("src/videoPoker/sparadSpel.txt");
			System.out.println(file.getAbsolutePath());
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(credit);
			System.out.println("Filen har skrivits");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Fel vid stängning av BufferedWriter" + ex);
			}
			
		}
	}
}