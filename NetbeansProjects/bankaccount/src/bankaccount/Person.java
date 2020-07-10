/*
1. Create class Person with variables name, age, account.
2.  account is of type BankAccount from previous exercise.
2. Getter/setters
3. Constructors (default, name, name-age, all)
4. Create 2-3 Persons. Get their amount and print a message ("Bary has $1000 in his account").
5. Create Mary. She married Bary. So she also got his account!!! (How can you achieve that)
6. If you print Mary's account, she must have the same ammount as Bary's account.
 */
package bankaccount;

/**
 *
 * @author f3nix
 */
public class Person {
	String name;
	int age;
	BankAccount account;

	//Constructors
	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public Person(String name, int age) {
		this(name);
		this.age = age;
	}

	public Person(String name, int age, BankAccount account) {
		this(name, age);
		this.account = account;
	}

	//Print Account balance
	public void printAccount(){
		System.out.println(name + " has " + getAccount().getAmount() + "€ in his account.");
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}
	
	
	

	
}
