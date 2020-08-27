/*
 * This class contain specialized methods for "Odd Or Even" variation of KINO.
 */
package kinoproject;

import java.util.Scanner;
import static kinoproject.Utilities.*;

/**
 *
 * @author f3nix
 */
public class OddOrEven {

	public static Integer betOn(Scanner sc) { // Pick Bet: Odd, Even or Draw
		System.out.println("");
		System.out.println(" Which numbers will come out the most? ");
		System.out.println("");
		System.out.println("1. Odd");
		System.out.println("2. Even");
		System.out.println("3. Draw");
		return inputChoice(sc, 3);
	}

	public static void runGame(Scanner sc, Kino kino) {
		System.out.println("");
		clearScreen();
		System.out.println("*** This is a KINO emulation. ***\n"
				+ "You can bet on which numbers will be drawn the most: Odd, Even or Draw.\n");
		printTable();
		System.out.println("");
		System.out.print("Do you feel lucky punk? ");
		if (!yes(sc)) {
			System.exit(0);
		}
		clearScreen();
		System.out.println("*** LET'S PLAY ***\n\n");
		printTable();
		Integer bet = betOn(sc); 																// pick a bet
		kino.setMoneyBet(kino.betAmount(sc)); 													// pick amount of bet
		kino.setNumberOfDraws(kino.numberOfGames(sc)); 											// pick number of numberOfGames
		int initialBetAmount = kino.getMoneyBet() * kino.getNumberOfDraws();				 	// set initial balance
//		kino.setTotalEarnings(-initialBetAmount);												// subtract balance from total earnings
		for (int i = 0; i < kino.getNumberOfDraws(); i++) { 									// loop through all draws
			if (bet.equals(oddOrEven(kino.runADraw()))) {										// compare player bet choice with draw result.
				System.out.println("*** YOU WON! ***");
				System.out.println("Draw Earnings: " + kino.calculateEarnings(bet)); 			// print individual draw earnings.
				kino.setTotalEarnings(kino.getTotalEarnings() + kino.calculateEarnings(bet)); 	// update total earnings.
			}
		}
		Integer Balance = kino.getTotalEarnings() - initialBetAmount;					// calculate remaining balance.
		System.out.println("**********************************************************");
		System.out.printf(" INITIAL BET AMOUNT : %d\u20ac\n", initialBetAmount);
		System.out.printf("     TOTAL EARNINGS : %d\u20ac\n", kino.getTotalEarnings());
		System.out.printf("            BALANCE : %d\u20ac\n", Balance);
	}

}
