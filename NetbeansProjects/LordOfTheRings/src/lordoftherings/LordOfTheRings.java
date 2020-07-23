/* Create a new program to exercise with Lists and Sets.
* Use the attached file (lorgOfRings.txt) for this exercise.
* Create a list and a set.
* Insert all the words from the above file into a list (Which list will you use?)
* Insert all the words from the above file into a set.
* Create methods for the above requirements (one method for inserting into list and one method for set).
* How many words does the above file have?
* How many different words does the above file have?
 */
package lordoftherings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Chrysanthos Panagakos
 */
public class LordOfTheRings {

	public static void main(String[] args) {
		List<String> lordList = listFromFile("lordOfRings.txt");
		wordCount(lordList);
	}

	public static List<String> listFromFile(String directory) {
		List<String> list = new ArrayList<>();
		try {
			File text = new File(directory);
			Scanner sc = new Scanner(text);
			while (sc.hasNext()) {
				list.add(sc.next());
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Error: File Not Found.");
		}
		return list;
	}

	public static void wordCount(List<String> list) {
		if (list.isEmpty()) return;
		Set<String> set = new HashSet<>();
			set.addAll(list);
		System.out.println("This list has " + list.size() + " words."
				+ set.size() + " are unique.");
		System.out.println(list);
	}

}
