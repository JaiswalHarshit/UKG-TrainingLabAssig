package assg4b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class WordFrequency {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter line to enter in the file");
		String line = in.nextLine();

		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(new File("story.txt"),true));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			writer.write("\n"+line);
			writer.flush();
			System.out.println("Line inserted in file");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, Integer> map=new HashMap<>();
		
		BufferedReader br2=null;
		try {
			br2=new BufferedReader(new FileReader(new File("story.txt")));
			String line2=null;
			while((line2=br2.readLine())!=null) {
				String tokens[]=line2.split(" ");
				for(String token: tokens)
					if(map.containsKey(token)) {
						int freq=map.get(token)+1;
						map.put(token, freq);
					}
					else {
						map.put(token, 1);
					}
			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				br2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("-------word with freq......");
			 Set<Entry<String, Integer>>entrySet=  map.entrySet();
			
			 for(Entry<String, Integer> e: entrySet) {
				 System.out.println(e.getKey()+": "+ e.getValue());
			 }
	}

	}

}
