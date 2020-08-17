package course.exercices.files.exer004;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		
		String[] lines = new String[] {"Good morning", "Good afternoon", "Good night"};
		
		String path = "C:\\temp\\out.txt";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			for (String line : lines) {
				bw.write(line); // Por padr�o n�o tem a quebra de linha
				bw.newLine(); // Insere a quebra de linha
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
