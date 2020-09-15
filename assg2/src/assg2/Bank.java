package assg2;

import java.util.Scanner;

class Account {
	private String memberName;
	private String accountNumber;
	protected double accountBalance;

	Account(String memberName, String accountNumber, double accountBalance) {

		this.memberName = memberName;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}

	public void deposit(double amount) {
		accountBalance += amount;
	}
}

class SavingsAccount extends Account {
	private int interest = 5;
	private double maxWithdrawLimit;

	SavingsAccount(String memberName, String accountNumber, double accountBalance, double maxWithdrawLimit) {
		super(memberName, accountNumber, accountBalance);
		this.maxWithdrawLimit = maxWithdrawLimit;
	}

	public double getBalance() {
		return (accountBalance + ((interest * accountBalance) / 100));
	}

	public void withdraw(double amount) {
		if (amount <= maxWithdrawLimit && accountBalance - amount >= 5000) {
			accountBalance -= amount;
			System.out.println("New balace: " + accountBalance);
		} else {
			System.out.println("Withdraw not possible");
		}
	}

}

class CurrentAccount extends Account {
	private int tradeLiscenceNumber;

	CurrentAccount(String memberName, String accountNumber, double accountBalance, int tradeLiscenceNumber) {
		super(memberName, accountNumber, accountBalance);
		this.tradeLiscenceNumber = tradeLiscenceNumber;

	}

	public double getBalance() {
		return accountBalance;
	}

	public void withdraw(double amount) {
		if (accountBalance - amount >= 0) {
			accountBalance -= amount;
			System.out.println("New balace: " + accountBalance);
		} else {
			System.out.println("Withdraw not possible");
		}
	}
}

public class Bank {

	public static void main(String[] args) {

		String num = 10000 + (int) (Math.random() * 89999) + "";
		SavingsAccount sa = null;
		CurrentAccount ca = null;
		Scanner input = new Scanner(System.in);

		System.out.println("Enter Name");
		System.out.println("Enter 1-Savings Acc.------ Enter 2-Current Acc.");
		System.out.println("Enter opening balance");
		String name = input.next();
		int type = input.nextInt();
		double bal = input.nextDouble();

		if (type == 1 && bal < 5000) {
			System.out.println("Low Balance for savings acc.");
		} else if (type == 1 && bal >= 5000) {
			System.out.println("Enter Max Withdraw Limit");
			double limit = input.nextDouble();
			sa = new SavingsAccount(name, num, bal, limit);
		} else if (type == 2) {
			System.out.println("Enter Licsence number");
			int lic = input.nextInt();
			ca = new CurrentAccount(name, num, bal, lic);
		}

		System.out.println("Enter “1”, to deposit");
		System.out.println("Enter “2”, to withdraw");
		System.out.println("Enter “3”, to display balance");
		System.out.println("Enter “0”, to exit the system.");

		int ch = input.nextInt();

		switch (ch) {
		case 1:
			System.out.println("Enter amount to deposit:");
			double amount = input.nextDouble();
			if (type == 1) {
				System.out.println("Balace before deposit: " + sa.getBalance());
				sa.deposit(amount);
				System.out.println("Balace after deposit: " + sa.getBalance());
			}
			else if( type ==2) {
				System.out.println("Balace before deposit: " + ca.getBalance());
				ca.deposit(amount);
				System.out.println("Balace after deposit: " + ca.getBalance());
			}
			break;
		case 2:
			System.out.println("Enter amount to withdraw:");
			double amount1 = input.nextDouble();
			if (type == 1) {
				System.out.println("Balace before withdraw: " + sa.getBalance());
				sa.withdraw(amount1);
			}
			else if( type ==2) {
				System.out.println("Balace before withdraw: " + ca.getBalance());
				ca.withdraw(amount1);
			}
			break;
		case 3:
			if (type == 1) {
				System.out.println("Balace: " + sa.getBalance());
			}
			else if( type ==2) {
				System.out.println("Balace: " + ca.getBalance());
			}
			break;
		case 0:
			System.out.println("You have exited");
			break;
		default:
			System.out.println("Wrong input");
		}
	}

}
