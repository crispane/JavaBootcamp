
/* Exercise 3 FTJV 15
*
*Write a program to count the occurrences of each word the text file provided. 
*(A Journey into the Interior of the Earth.txt).
*
* Allow the user to type a word and report how many times that word appeared in the book.
* Report all words that appeared in the book at least 500 times, in alphabetical order.
 */
package ftjv15exercises3and4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Chrysanthos Panagakos
 */
public class Main {

	public static void main(String[] args) {
		//Exercise 3
		Map<String, Integer> journeyMap = wordMap("aJourneyToTheInteriorOfTheEarth.txt");
		System.out.println(" *** Word map of " + "\"aJourneyToTheInteriorOfTheEarth.txt\" ***");
		System.out.println();
		System.out.println(journeyMap);
		wordFinder(journeyMap);
		wordOccurrences(journeyMap, 500);

		// Exercise 4
		portionOfTree(journeyMap);
	}

	public static Map<String, Integer> wordMap(String directory) {
		Map<String, Integer> map = new TreeMap<>();
		try {
			File text = new File(directory);
			Scanner sc = new Scanner(text);
			String word;
			while (sc.hasNext()) {
				word = sc.next();
				if (map.containsKey(word)) {
					map.put(word, map.get(word) + 1);
				} else {
					map.put(word, 1);
				}
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Error: File Not Found.");
		}
		return map;
	}

	public static void wordFinder(Map<String, Integer> map) {
		Scanner input = new Scanner(System.in);
		System.out.println();
		String word = inputString(input, "Enter word to be found in text: ");
		if (map.containsKey(word)) {
			System.out.println("Word found! \"" + word + "\" occurs " + map.get(word) + " times.");
		} else {
			System.out.println("Word not found.");
		}
	}

	public static void wordOccurrences(Map<String, Integer> map, Integer limit) {
		System.out.println();
		System.out.println("Words with " + limit + " Occurrences or above: ");
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() >= limit) {
				System.out.print(entry.getKey() + " ");
			}
		}
		System.out.println();
	}

	public static String inputString(Scanner sc, String message) {
		System.out.print(message);
		return sc.next();
	}

	public static Map<String, Integer> portionOfTree(Map<String, Integer> map) {
		System.out.println();
		System.out.print("Enter a letter to map words after it: ");
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		Map<String, Integer> portion = new TreeMap();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getKey().charAt(0) >= word.charAt(0)) {
				portion.put(entry.getKey(), entry.getValue());
			}
		}
		System.out.println();
		System.out.println("The portion of the map after \"" + word.charAt(0) + "\" is: ");
		System.out.println(portion);
		return portion;
	}

}
