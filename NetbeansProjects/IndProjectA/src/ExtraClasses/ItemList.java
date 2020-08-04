package ExtraClasses;
import java.util.ArrayList;

/**
 *
 * @author f3nix
 * @param <T>
 */

// An Item Class that stores Lists of Items
public class ItemList<T extends Item> extends Item {
	private String name;
	private Item item;
	private ArrayList<Item> list;

	public ItemList() {
		this.list = new ArrayList<Item>();
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public ArrayList<Item> getList() {
		return list;
	}

	public void setList(ArrayList<Item> list) {
		this.list = list;
	}

	public void add(Item item){
		list.add(item);
	}

	@Override
	public String getName() {
		return name;
	}
}
