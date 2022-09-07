package turnitin;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequency {
	public static void main(String[] args) {

		// Read input line
		Scanner sc = new Scanner(System.in);
		String inputText = sc.nextLine();
		sc.close();

		// Extract words from the line and keep to same case.
		// Additionally we can refine a word to remove the special characters that are
		// added to the end of it. E.g Comma, semicolon, full stop, question mark etc. 
		// For simplicity I am considering space is the only separator here.
		String[] words = inputText.toLowerCase().split("\\s+");

		// count the frequency of each word
		Map<String, Integer> frequency = new HashMap<String, Integer>();
		for (String word : words) {
			if (frequency.containsKey(word)) {
				frequency.put(word, frequency.get(word) + 1);
			} else {
				frequency.put(word, 1);
			}
		}

		// sort the frequencies by descending order and print result
		frequency.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.forEach(entry -> System.out.println(entry.getValue() + " " + entry.getKey()));

	}

}
