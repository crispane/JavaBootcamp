

/*Exercises:
*
*1. length()
*    Create a method that accepts 2 strings. Check which is the largest and print a message informing the user.
*    Create a method that accepts a name and returns a message based on length. More than 5 letters is a big name else small name. Use ternary.
*2. charAt()
*    Create a method that accepts an array of names. Print only the names that start with letter J.
*3. indexOf()
*    Create a method that accepts an array of cities Athens, Thessaloniki, Thiva, Thasos, Xanthi, Kallithea, Rethymno. 
*4. concat()
*    Create a method that accepts two names and returns their concatenation
*5. toLowerCase(), toUpperCase()
*    Update the previous method so that it prints the concatenation in Uppercase
*6. trim()
*    Create a method that accepts a string and trims it. Use it with input text.
*7. split(), contains()
*    Create a method that accepts a string. Use String "Computer, Laptop, Tablet". If String contains "," split it and return it. Then create a method that accepts the array and prints it.
*8. replace()
*    Use replace to check for ", " in the previous exercise and replace it with ",".
*9. substring()
*    Create a method that accepts a url and gets only the domain name.
*    http://peoplecert.com
*/
package stringplay;

import java.util.Scanner;

/**
 *
 * @author Chrysanthos Panagakos
 */
public class StringPlay {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String a = "Mitsos";
		String b = "Kwnstantinos";
		String[] cities = {"Athina", "Thessaloniki", "Thiva", "Thasos", "Xanthi", "Kallithea", "Rethymno"};
		String PC = "Computer, Laptop, Tablet";
		String aUrl = "https://www.youtube.com/watch?v=I_izvAbhExY";

		System.out.printf("Given Strings are %s %s .\n", a, b);
		largestString(a, b); // 1
		System.out.println(a + " is a " + sizeString(a)); // 1
		System.out.println();

		charAtString(cities, 'A'); // 2
		System.out.println();
		
		arrayString(cities, "Th"); // 3
		System.out.println();

		System.out.println(concatString(a, b)); // 4, 5
		System.out.println();
		
		System.out.println(trimString(sc)); // 6
		System.out.println();

		printArray(splitString(PC));
		System.out.println();

		System.out.println("Complete url is: " + aUrl);
		System.out.println("And the domain name is: " + domainName(aUrl)); // 9

	}

	public static void largestString(String a, String b) {
		if (a.length() > b.length()) {
			System.out.println("The first string is larger.");
		} else if (a.length() == b.length()) {
			System.out.println("String are of equal length.");
		} else {
			System.out.println("The second string is larger");
		}
	}

	public static String sizeString(String a) {
		return a.length() > 5 ? "Big name" : "Small name";
	}

	public static void charAtString(String[] array, char ch) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].charAt(0) == ch) {
				System.out.println(array[i]);
			}
		}
	}

	public static void arrayString(String[] array, String st) {
		for (String i : array) {
			if (i.indexOf(st) == 0) {
				System.out.println(i);
			}
		}
	}

	public static String concatString(String a, String b) {
		return a.concat(b).toUpperCase();
	}

	public static String trimString(Scanner sc) {
		System.out.print("Enter some text (for trimString() method): ");
		return sc.nextLine().trim();
	}

	public static String[] splitString(String a) {
		if (a.contains(", ")) {
			a = a.replace(", ", ",");
			return a.split(",");
		}
		return null;
	}
	public static void printArray(String [] a){
		for (String i : a) { 
			System.out.println(i);
		}
	}

	public static String domainName(String a) {
		//for (int i = 0; i < a.length(); i++) {
//			if (a.contains(".com")) {
				return a.substring(0, a.indexOf("/", 8));
//			}
//		}
//		return null;
	}

}
