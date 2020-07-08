/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testbed;

/**
 *
 * @author f3nix
 */
public class TestBed {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		int x = 5;
		changeInt(x);
		Integer y = 5;
		changeInteger(y);
		System.out.println(x);
		System.out.println(y);
	}

	public static void changeInteger(Integer x) {
		x = 6;

	}
	public static void changeInt(int x) {
		x = 6;
	}
}
