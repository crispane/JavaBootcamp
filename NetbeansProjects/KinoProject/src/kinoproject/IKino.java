package kinoproject;

import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author f3nix
 */
public interface IKino {

	public Integer betAmount(Scanner sc);

	public Integer numberOfGames(Scanner sc);

	public Set<Integer> runADraw();

	public void showDrawNumbers(Set<Integer> numbers);

	public Integer calculateEarnings(Integer bet);
}
