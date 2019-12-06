
package videoPoker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class ReadFile {
	
	public static void main(String[] args) throws IOException {
		
	File file = new File("src/testes/myfile.txt");
	FileReader fr = new FileReader(file);
	BufferedReader br = new BufferedReader(fr);
	
	String line; 
	while ((line = br.readLine()) != null) {
		System.out.println(line);
		}
	
	fr.close();
	}	
}