/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

/**
 *
 * @author f3nix
 */
public class Director extends Employee implements Advisable, Driving{

	public Director(String name, int salary) {
		super(name, salary);
	}

	public static void guide(){
		System.out.println(" guides.");
	}


	@Override
	public void giveAdvice() {
		System.out.println(" advises about directing.");
	}


	@Override
	public void drive() {
		System.out.println(" drives to places.");
	}

	@Override
	public void work(){
		guide();
	}

	@Override
	public String toString() {
		return "Director{" + getName() + '}';
	}
	
}
