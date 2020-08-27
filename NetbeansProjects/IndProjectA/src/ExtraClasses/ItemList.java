package ExtraClasses;
import java.util.LinkedList;

/**
 *
 * @author Chrysanthos Panagakos
 * @param <T>
 * @param <S>
 */

// A Class that stores a *list* of Items, and an *Owner* for that *list*. It is an Item itself.
// A key class for the project that allows for the abstraction of critical methods. 
public class ItemList<T extends Item, S extends Item> extends Item {
	private S Owner;
	private LinkedList<T> list;

	public ItemList() {
		this.list = new LinkedList<>();
	}

	public Item getOwner() {
		return Owner;
	}

	public void setOwner(S item) {
		this.Owner = item;
	}

	public LinkedList<T> getList() {
		return list;
	}

	public void setList(LinkedList<T> list) {
		this.list = list;
	}

	@Override
	public String getName() {
		return Owner.getName();
	}
}
