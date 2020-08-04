package ExtraClasses;
import java.util.ArrayList;

/**
 *
 * @author f3nix
 * @param <T>
 * @param <S>
 */

// An Item Class that stores Lists of Items
public class ItemList<T extends Item, S extends Item> extends Item {
	private String name;
	private S Owner;
	private ArrayList<T> list;

	public ItemList() {
		this.list = new ArrayList<T>();
	}

	public Item getOwner() {
		return Owner;
	}

	public void setOwner(S item) {
		this.Owner = item;
	}

	public ArrayList<T> getList() {
		return list;
	}

	public void setList(ArrayList<T> list) {
		this.list = list;
	}

	@Override
	public String getName() {
		return name;
	}
}
