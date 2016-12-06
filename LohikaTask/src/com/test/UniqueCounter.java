package com.test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;


public class UniqueCounter {

	public static void main(String[] args) {
		
		if (args.length < 2) {
			System.out.println("Provide the input file name and Number of occurences");
			return;
		}

		int numOccurences = Integer.valueOf(args[1]);
		
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(args[0]));
			String str = null;
			while ((str = reader.readLine()) != null)
			{
				String[] words = str.split(" ");
				for (String w : words) {
					Integer cnt = map.get(w);
					map.put(w, cnt == null ? 1 : ++cnt);
				}
			}
			
			Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
			int cnt = 0;
			
			for (; it.hasNext() && cnt < numOccurences; ) {
				Entry<String, Integer> e = it.next();
				if (e.getValue() == 1) {
					System.out.println(e.getKey());
					cnt++;
				}
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
