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
public class Teacher extends Employee implements Advisable{

	public Teacher(String name, int salary) {
		super(name, salary);
	}


	public static void teach() {
		System.out.println(" teaches.");
	}

	@Override
	public void giveAdvice() {
		System.out.println(" advises about teaching.");
	}
	
	@Override
	public void work(){
		teach();
	}

	@Override
	public String toString() {
		return "Teacher{" + getName() + '}';
	}

	
}
