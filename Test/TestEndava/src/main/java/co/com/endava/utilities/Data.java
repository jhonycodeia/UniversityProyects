package co.com.endava.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Data {

	public static List<String[]> csv(String filename) {
		List<String[]> data = new ArrayList<String[]>();
		String testRow;
		try {
			System.out.println("ubicacion : " + new File(".").getAbsolutePath());
			// Open and read the file
			BufferedReader br = new BufferedReader(new FileReader(filename));
			// Read data as long as it's not empty
			// Parse the data by comma using .split() method
			// Place into a temporary array, then add to List
			while ((testRow = br.readLine()) != null) {
				String[] line = testRow.split(",");
				data.add(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found " + filename);
		} catch (IOException e) {
			System.out.println("ERROR: Could not read " + filename);
		}
		return data;
	}

}
