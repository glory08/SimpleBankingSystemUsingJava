import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Account{
	private String accountNumber;
	private String accountHolderName;
	private double balance;
	public void  setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void  setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public void  setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public double getBalance() {
		return balance;
	}
	public Account(String accountNumber, String accountHolderName, double balance) {
		super();
		this.accountNumber=accountNumber;
		this.accountHolderName=accountHolderName;
		this.balance=balance;
	}
	public void deposit(String accountNumber,double transactionAmount) {
		balance=balance+transactionAmount;
	}
	public void withdraw(String accountNumber,double transactionAmount) {
		if(balance>=transactionAmount)
		{
			balance=balance-transactionAmount;
		}
		else {
			System.out.println("Insufficient Balance");
		}
	}
}
class Bank{
	private Map<String, Account> accounts;
	public Bank(){                //Constructor
		accounts = new HashMap<>();
	}
	public void createAccount(String accountNumber, String accountHolderName, double initialBalance) {
		Account account = new Account(accountNumber, accountHolderName, initialBalance);
		accounts.put(accountNumber, account);
	}
	public void displayAccountDetails(String accountNumber) {
		Account account = accounts.get(accountNumber);
		if (account != null) {
			System.out.println("Account Number: " + account.getAccountNumber());
			System.out.println("Account Holder's Name: " + account.getAccountHolderName());
			System.out.println("Current Balance: " + account.getBalance());
		} else {
			System.out.println("Account not found.");
		}
	}
	public Account searchByAccountNumber(String accountNumber) {
		return accounts.get(accountNumber);
	}
	public void deposit(String accountNumber,double transactionAmount) {
		Account account = accounts.get(accountNumber);
		if(account!=null) {
			account.deposit(accountNumber, transactionAmount);
			System.out.println("New Balance:"+account.getBalance());	
		}
		else {
			System.out.println("Account not found!");
		}
	}
	public void withdraw(String accountNumber,double transactionAmount) {
		Account account = accounts.get(accountNumber);
		if(account!=null) {
			account.withdraw(accountNumber, transactionAmount);
			System.out.println("New Balance:"+account.getBalance());	
		}
		else {
			System.out.println("Account not found!");
		}
	}
}
public class BankingSystemApp {

	public static void main(String[] args) {
		Bank bank = new Bank();
		Scanner scan = new Scanner(System.in);
		for(;;)
		{
			System.out.println("*****************************");
			System.out.println("Welcome to the Banking System");
            System.out.println("1. Create Account");
            System.out.println("2. Display Account Details");
            System.out.println("3. Search by Account Number");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");
            System.out.println("*****************************");
            
            int choice = scan.nextInt();
            
            switch (choice) {
            case 1:
            	System.out.println("Enter the account number:");
            	String accountNumber = scan.next();
            	System.out.println("Enter the account holders name:");
            	String accountHolderName = scan.nextLine();
            	scan.nextLine();
            	System.out.println("Enter the initial Balance:");
            	double initialBalance = scan.nextDouble();
            	scan.nextLine();
            	bank.createAccount(accountNumber, accountHolderName, initialBalance);
            	break;
            case 2:
            	System.out.println("Enter the account number:");
            	String displayaccountNumber = scan.next();
            	scan.nextLine();
            	bank.displayAccountDetails(displayaccountNumber);
            	break;
            case 3:
            	System.out.println("Enter the account number to search:");
            	String searchaccountNumber = scan.next();
            	Account account = bank.searchByAccountNumber(searchaccountNumber);
            	if(account!=null) {
            		System.out.println("Account found!");
            		System.out.println("Account Number:"+account.getAccountNumber());
            		System.out.println("Current Balance:"+account.getBalance());
            	}
            	else {
            		System.out.println("Account not found!");
            	}
            	break;
            case 4:
            	System.out.println("Enter the account Number:");
            	String accountNumbertodeposit = scan.next();
            	System.out.println("Enter the amount to be deposited: ");
            	double depositAmount = scan.nextDouble();
            	bank.deposit(accountNumbertodeposit, depositAmount);
            	break;
            case 5:
            	System.out.println("Enter the account Number:");
            	String accountNumbertowithdraw = scan.next();
            	System.out.println("Enter the amount to be withdrawn: ");
            	double withdrawAmount = scan.nextDouble();
            	bank.withdraw(accountNumbertowithdraw, withdrawAmount);
            	break;
            case 6:
            	System.out.println("Exiting....");
            	System.exit(0);
            	break;
            	
            default:
            	System.out.println("Invalid choice please try again...");
            	break;
            }
		}
		
	}
}

