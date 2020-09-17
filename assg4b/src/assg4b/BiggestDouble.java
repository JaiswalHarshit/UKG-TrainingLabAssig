package assg4b;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BiggestDouble {

	public static void main(String[] args) {

		BufferedReader br = null;
		double max = -127;
		try {
			br = new BufferedReader(new FileReader(new File("data.txt")));
			String line = null;
			double num;
			while ((line = br.readLine()) != null) {
				num = Double.parseDouble(line);
				if (num > max)
					max = num;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		System.out.println("Biggest Double in the file is: "+max);
	}
}
