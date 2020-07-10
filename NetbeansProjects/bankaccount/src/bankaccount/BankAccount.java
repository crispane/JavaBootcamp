package bankaccount;

import java.util.ArrayList;

/*
* Create a class BankAccount with variables
* number :int,
* amount :double,
* name   :String,
* active :boolean,
* transactions: List<String>
* Getters/Setters
* 2. Create methods deposit(), withdraw(). Do we need the setter for amount?
* 3. Store each action (deposit, withdraw, creation) in the transactions.
* 4. Create static/class variable accountsOpened. This variable shows how many accounts have been opened. How to access it??? With an object or class?
* 5. Create 3 constructors (default, name-number, all(except transactions)). When created all will be active.
* 6. Create 3 BankAccounts in MainClass.
* 7. print transactions of 2 bank accounts. (printTransactions???).
*
* @author Chrysanthos Panagakos
*/
public class BankAccount {

	private int number;
	private double amount;
	private String name;
	private boolean active;
	private ArrayList<String> transactions;

	private static int accountsOpened;

	public BankAccount() {
		accountsOpened++;
		this.active = true;
		transactions = new ArrayList<>();
		transactions.add("creation");
	}

	public BankAccount(String name, double amount) {
		this();
		this.name = name;
		this.amount = amount;
	}

	public BankAccount(String name, double amount, int number) {
		this(name, amount);
		this.number = number;
	}

	public void deposit(double amount) {
		this.amount += amount;
		transactions.add("deposit");
	}

	public void withdraw(double amount) {
		this.amount -= amount;
		transactions.add("withdraw");
	}

	public void printTransactions() {
		System.out.print("Transactions of " + name + ":\n");
		for (int i = 0; i < transactions.size(); i++) {
			System.out.println(transactions.get(i));
		}
		System.out.println();
	}

	public int getNumber() {
		return number;
	}

	public double getAmount() {
		return amount;
	}

	public String getName() {
		return name;
	}

	public boolean isActive() {
		return active;
	}

	public ArrayList<String> getTransactions() {
		return transactions;
	}

	public static int getAccountsOpened() {
		return accountsOpened;
	}

	// We should only be able to change the name and status of the account. Not balance or transactions.
	public void setName(String name) {
		this.name = name;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
