/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtraClasses;

import java.util.HashMap;

/**
 *
 * @author f3nix
 * @param <T>
 */
public class ItemMap<T> extends Item{
	private HashMap<T,T> map;

	public ItemMap() {
		this.map = new HashMap<>();
	}

	@Override
	public String getName() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public HashMap<T,T> getMap() {
		return map;
	}

	public void setMap(HashMap<T,T> map) {
		this.map = map;
	}

	
	
}
