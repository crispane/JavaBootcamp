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
public class Receptionist extends Employee implements Driving{

	public Receptionist(String name, int salary) {
		super(name, salary);
	}

	public static void greet() {
		System.out.println(" greets.");
	}


	@Override
	public void drive() {
		System.out.println(" drives to hotel.");
	}
	
	@Override
	public void work(){
		greet();
	}

	@Override
	public String toString() {
		return "Receptionist{" + getName() + '}';
	}
}
