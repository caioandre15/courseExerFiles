package course.exercices.files.exer007.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import course.exercices.files.exer007.entities.Product;

public class Program {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			Locale.setDefault(Locale.US);
			System.out.print("Enter a file path: ");
			String strPath = sc.nextLine();
			File path = new File(strPath);
			try (BufferedReader br = new BufferedReader(new FileReader(path.getPath()))) {

				String line = br.readLine();
				List<Product> list = new ArrayList<>();

				System.out.println("Reading file ...");
				System.out.println();
				
				while (line != null) {
					System.out.println(line);
					String[] vectSplit = line.split(",");
					String name = vectSplit[0];
					double price = Double.parseDouble(vectSplit[1]);
					int quantity = Integer.parseInt(vectSplit[2]);
					list.add(new Product(name, price, quantity));
					line = br.readLine();
				}
				System.out.println();
				boolean success = new File(path.getParent() + "\\out").mkdir();
				if (success) {
					System.out.println("Folder \"out\" created!");
				}
				
				File validateFolder = new File(path.getParent() + "\\out");
				if (validateFolder.exists()) {
					try (BufferedWriter bw = new BufferedWriter(new FileWriter(path.getParent() + "\\out" + "\\summary.csv"))) {
						System.out.println("Writing to file ...");
						System.out.println();
						for (Product p : list) {
							bw.write(p.toString());
							bw.newLine();
							System.out.println(p);
						}
						System.out.println();
						System.out.println("Finish writing!");
					}
					catch (IOException e) {
						System.out.println("Error: " + e.getMessage());
					}
				} 
				else {
					System.out.println("Folder was not created");
				}
			} 
			catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			} 
			catch (InputMismatchException e) {
				System.out.println();
			}
		} 
		catch (InputMismatchException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
