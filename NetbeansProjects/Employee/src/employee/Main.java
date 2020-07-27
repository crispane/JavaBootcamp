/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author f3nix
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		
		Employee t1 = new Teacher("Richard Feynman", 10000);
		Employee t2 = new Teacher("Carl Sagan", 15000);
		Employee r1 = new Receptionist("Peper Potts", 13000);
		Employee d1 = new Director("Stanley Kubrick", 20000);
		Employee d2 = new Director("Ridley Scott", 21000);

		list.add(t1);
		list.add(t2);
		list.add(r1);
		list.add(d1);
		list.add(d2);

		List<Employee> driveList = new ArrayList<>();
		List<Employee> adviceList = new ArrayList<>();

		for(Employee emp: list) {
			System.out.print(emp.getName());
			emp.work();

			if ((emp instanceof Receptionist) || (emp instanceof Director)) driveList.add(emp);
			if ((emp instanceof Teacher) || (emp instanceof Director)) adviceList.add(emp);
		}

		System.out.println("Employees that drive: " + driveList);
		System.out.println("Employees that give advice: " + adviceList);
		
	}
	
}
