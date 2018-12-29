package Bank;

import java.util.Scanner;

public class BankApp {

	public static void main(String[] args) {

		Account obj = new Account("Alan Turing", 12345);
		obj.display();

	}

}

class Account {

	int balance, withdraw, lastTrans, accountNum;
	String customerName;

	Account(String customerName, int accountNum) {
		this.customerName = customerName;
		this.accountNum = accountNum;
	}

	private void deposit(int deposit) {

		balance += deposit;
		lastTrans = deposit;

	}

	private void withdraw(int withdraw) {

		if (withdraw > 0 && ((balance - withdraw) > 0)) {
			balance -= withdraw;
			lastTrans = -withdraw;
		} else {
			System.out.println("Your withdrawal request exceeds your account balance. Request must be rejected.");
		}

	}

	private void prevTrans() {

		if (lastTrans > 0) {

			System.out.println("Deposit: " + lastTrans + "\n");
		}
		else if (lastTrans < 0) {

			System.out.println("Withdraw: " + lastTrans + "\n");
		} else {

			System.out.println("No prior transaction on record.");
		}

	}

	void display() {

		int selectDeposit, selectWithdraw;
		char select;
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to Exchange Place Banking");
		System.out.println("Your Name: " + customerName);
		System.out.println("Your Account Number: " + accountNum + "\n");
		System.out.println("Menu Options:");
		System.out.println("A. Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Prior Transaction");
		System.out.println("E. Exit \n");

		do {

			System.out.println("\nHow may we assist you? Please enter an option from above.\n");
			select = scan.next().charAt(0);

			if (select == 'A' || select == 'a') {
				System.out.println("Balance: " + balance);
			}
			else if (select == 'B' || select == 'b') {
				System.out.println("Enter Deposit Amount: ");
				selectDeposit = scan.nextInt();
				deposit(selectDeposit);
			}
			else if (select == 'C' || select == 'c') {
				System.out.println("Enter Withdraw Amount: ");
				selectWithdraw = scan.nextInt();
				withdraw(selectWithdraw);
			}
			else if (select == 'D' || select == 'd') {
				System.out.println("Prior Transcation:");
				prevTrans();
			}
			else if (select == 'E' || select == 'e') {
				System.out.println("Thank you. Enjoy your day.");
				break;	
			} 
			else {
				System.out.println("\nInvalid Selection");
			}

		} while (select != 'E' || select != 'e');

	}
}
