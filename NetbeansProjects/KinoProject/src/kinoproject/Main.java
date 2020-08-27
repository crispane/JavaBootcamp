package kinoproject;

import java.util.Scanner;
import static kinoproject.OddOrEven.runGame;

/**
 *
 * @author f3nix
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Kino OddOrEvenKino = new Kino();
			runGame(sc, OddOrEvenKino);
		}
	}


}
