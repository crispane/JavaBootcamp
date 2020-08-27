/* 
 *This class contains basic implementation methods and can be expanded for various KINO games.
 */

package kinoproject;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import static kinoproject.Utilities.*;

/**
 *
 * @author f3nix
 */
public class Kino implements IKino {

	private Integer moneyBet;
	private Integer numberOfDraws;
	private Integer totalEarnings = 0;
	final private int MIN = 1; 			
	final private int MAX = 80;		

	public Kino() {
	} 									

	public Kino(Integer moneyBet, Integer numberOfDraws) { 
		this.moneyBet = moneyBet;
		this.numberOfDraws = numberOfDraws;
	}

	@Override
	public Integer betAmount(Scanner sc) {
		Integer amount = 0;
		System.out.println("Available Bets:");
		System.out.println("");
		System.out.println(" 1.   1\u20ac");
		System.out.println(" 2.   2\u20ac");
		System.out.println(" 3.   3\u20ac");
		System.out.println(" 4.   5\u20ac");
		System.out.println(" 5.  10\u20ac");
		System.out.println(" 6.  15\u20ac");
		System.out.println(" 7.  20\u20ac");
		System.out.println(" 8.  30\u20ac");
		System.out.println(" 9.  50\u20ac");
		System.out.println("10. 100\u20ac");
		switch (inputChoice(sc, 10)) {
			case 1:
				amount = 1;
				break;
			case 2:
				amount = 2;
				break;
			case 3:
				amount = 3;
				break;
			case 4:
				amount = 5;
				break;
			case 5:
				amount = 10;
				break;
			case 6:
				amount = 15;
				break;
			case 7:
				amount = 20;
				break;
			case 8:
				amount = 30;
				break;
			case 9:
				amount = 50;
				break;
			case 10:
				amount = 100;
				break;
			default:
				break;
		}
		return amount;
	}

	@Override
	public Integer numberOfGames(Scanner sc) {
		Integer games = 1;
		System.out.println("");
		System.out.println("Number of games:");
		System.out.println("");
		System.out.println(" 1.   1");
		System.out.println(" 2.   2");
		System.out.println(" 3.   3");
		System.out.println(" 4.   4");
		System.out.println(" 5.   5");
		System.out.println(" 6.   6");
		System.out.println(" 7.  10");
		System.out.println(" 8.  20");
		System.out.println(" 9.  50");
		System.out.println("10. 100");
		System.out.println("11. 200");
		switch (inputChoice(sc, 11)) {
			case 1:
				games = 1;
				break;
			case 2:
				games = 2;
				break;
			case 3:
				games = 3;
				break;
			case 4:
				games = 4;
				break;
			case 5:
				games = 5;
				break;
			case 6:
				games = 6;
				break;
			case 7:
				games = 10;
				break;
			case 8:
				games = 20;
				break;
			case 9:
				games = 50;
				break;
			case 10:
				games = 100;
				break;
			case 11:
				games = 200;
				break;
			default:
				break;
		}
		return games;
	}

	@Override
	public Set<Integer> runADraw() {
		Set<Integer> drawNumbers = new TreeSet<>();
//		for (int i = 0; i < 20; i++) {
		while (drawNumbers.size() < 20) {
			Random random = new Random();
			drawNumbers.add(random.ints(MIN, (MAX + 1)).findFirst().getAsInt());
		}
		showDrawNumbers(drawNumbers);
		return drawNumbers;
	}

	@Override
	public void showDrawNumbers(Set<Integer> numbers) {
		System.out.println("---------------------------------------------------");
		System.out.print("|");
		for (int i = 1; i < 81; i++) {
			if (numbers.contains(i)) {

				System.out.printf("[%2d] ", i);
			} else {
				System.out.printf(" %2d  ", i);
			}
			if (i % 10 == 0) {
				System.out.print("|");
				System.out.println();
				if (i % 80 != 0) {
					System.out.print("|");
				}
			}
		}
		System.out.println("\b");
		System.out.println("Draw Numbers are: ");
		for (Integer number : numbers) {
			System.out.printf("%2d ", number);
		}
		System.out.println("");
		System.out.println("");
	}

	@Override
	public Integer calculateEarnings(Integer bet) {
		Integer earnings = -moneyBet;
		switch (bet) {
			case 1:
			case 2:
				earnings = moneyBet * 2;
				break;
			case 3:
				earnings = moneyBet * 4;
				break;
		}
		return earnings;
	}

	public int getMoneyBet() {
		return moneyBet;
	}

	public void setMoneyBet(Integer moneyBet) {
		this.moneyBet = moneyBet;
	}

	public int getNumberOfDraws() {
		return numberOfDraws;
	}

	public void setNumberOfDraws(Integer numberOfDraws) {
		this.numberOfDraws = numberOfDraws;
	}

	public int getTotalEarnings() {
		return totalEarnings;
	}

	public void setTotalEarnings(Integer totalEarnings) {
		this.totalEarnings = totalEarnings;
	}
}
