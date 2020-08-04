package WorkingClasses;

import ExtraClasses.*;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author f3nix
 */
public class Printers {

	// Prints Lists that contain an ItemList
	public static void printItemLists(String itemType, List<Item> list) {
		for (Item itemlist : list) {
			ItemList castlist = (ItemList) itemlist;
			System.out.println(itemType + "s in " + castlist.getOwner().getName() + ": ");
			for (int i = 0; i < castlist.getList().size(); i++) {
				System.out.println("-- " + castlist.getList().get(i));
			}
			pressEnterToReturn("Press Enter to continue");
		}
			System.out.println("");
			System.out.println("Done Printing.");
			pressEnterToReturn("Press Enter to return to menu");
	}

	// Prints simple Lists
	public static void printList(String itemType, List<Item> list) {
		System.out.println("All " + itemType + "s: ");
		list.forEach(item -> {
			System.out.println(item);
		});
		pressEnterToReturn("Press Enter to return to menu");
	}

	// Clears the screen (Doesn't work for NetBeans Output. For terminals and command prompts only.)
	public static void clearScreen() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\u001b[H\u001b[2J");
				System.out.flush();
			}
		} catch (IOException | InterruptedException ex) {
			System.out.println("Screen couldn't be cleared. Sorry!");
		}
	}

	public static void pressEnterToReturn(String message) {
		try {
			System.out.print("::" + message);
			System.in.read();
			//System.in.skip(System.in.available());
		} catch (IOException ex) {
			System.out.println("IO Error!");
		}
	}

}
