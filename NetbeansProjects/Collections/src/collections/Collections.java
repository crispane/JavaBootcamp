/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.ArrayList;

/**
 *
 * @author f3nix
 */
public class Collections {

	public static void main(String[] args) {
		ArrayList <String> list = new ArrayList(); 
		list.add("Jack");
		list.add("Peter");
		list.add("Kevin");
		list.add("Mary");
		list.add("Katherine");
		for (String s: list) {
			System.out.println(s);
		}
	}
	
}
