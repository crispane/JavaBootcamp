package bankaccount;

/**
 *
 * @author Chrysanthos Panagakos
 */
public class Main {

	public static void main(String[] args) {
		BankAccount bAccOne = new BankAccount();
		BankAccount bAccTwo= new BankAccount("Gordon Gekko", 20000.0);
		BankAccount bAccThree= new BankAccount("Michael Burry", 1000.0, 314159265);

		bAccTwo.deposit(100.0);
		bAccTwo.withdraw(10.0);
		bAccTwo.deposit(50.0);
		bAccTwo.deposit(1000.0);
		bAccTwo.withdraw(20000.0);

		bAccThree.withdraw(500.0);
		bAccThree.deposit(200.0);
		bAccThree.withdraw(500.0);
		bAccThree.withdraw(30.0);
		bAccThree.deposit(100000000.0);

		bAccTwo.printTransactions();
		bAccThree.printTransactions();

		BankAccount p1Acc = new BankAccount("Barry", 1000);
		Person p1 = new Person(p1Acc.getName(), 30, p1Acc);
		Person p2 = new Person("Mary", 28, p1Acc);

		p1.printAccount();
		p2.printAccount();
	}
	
}
