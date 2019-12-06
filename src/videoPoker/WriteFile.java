package videoPoker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Write {
	public static void main(String[] args) {

		BufferedWriter bw = null;

		try {
			String profile = "Detta skrivs till filen";
			
			File file = new File("src/testes/myfile.txt");

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(profile);
			System.out.println("Filen har skrivits");

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		finally
		{
			try{
				if(bw!=null)
					bw.close();
			}catch(Exception ex){
				System.out.println("Fel vid stängning av BufferedWriterr" + ex);
			}
		}
	}


}


