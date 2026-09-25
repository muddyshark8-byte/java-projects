package BankingSystem;

public class Account {
    private String accountNumber;
    private int customerId;
    private int balance;
    private String password;

    public Account(String accountNumber, int customerId, int balance, String password) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.balance = balance;
        this.password = password;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }

    public void deposit(double amount) {
        balance += amount; //Deposit logic
    }
    public void Withdraw(double amount){
        balance -= amount;
    }

    @Override
    public String toString() {
        return "Account [accountNumber=" + accountNumber + ", customerId=" + customerId + ", balance=" + balance
                + ", password=" + password + "]";
    }

	public char[] toFileString() {

		throw new UnsupportedOperationException("Unimplemented method 'toFileString'");
	}

    public static Account fromFileString(String line) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fromFileString'");
    }

    
    
    
    

    
}
