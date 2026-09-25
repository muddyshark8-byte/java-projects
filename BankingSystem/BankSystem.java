package BankingSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class BankSystem {

     final List <Account>accounts;
     final List <Customer>customers;
     final List <Transaction>transactions;
     Scanner scanner;
     private int nextAccountId;

    public BankSystem() {
        accounts = new ArrayList<>();
        customers = new ArrayList<>();
        transactions = new ArrayList<>();
        nextAccountId = 1;
        seedData();
    }
    public void seedData(){
        customers.add(new Customer(123, "Adelaide", "0916533216", "handelohia17@gmail.com"));
    }

    public static void main(String[] args) {
        
        BankSystem banking = new BankSystem();
        banking.start();
 
    }

    public void start() {
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to Frendy. Whatchu wanna do today?");
            System.out.println("Options: ");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    Login();
                    break;
                case 3:
                    Exit();
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

    public void createAccount() {
        System.out.println("Please input your name: ");
        String name = scanner.nextLine();
        System.out.println("Your Id comes next: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("What's your number darlin: ");
        String phone = scanner.nextLine();
        System.out.println("Almost there. Your E-mail next: ");
        String email = scanner.nextLine();
        System.out.println("Create a Password: ");
        String password = scanner.nextLine();

        String accountNumber = "Frendy" + nextAccountId;
        nextAccountId++;
        System.out.println("That's your account number. Take good care of it: " + accountNumber);

        Customer customer = new Customer(id, name, phone, email);
        customers.add(customer);

        Account account = new Account(accountNumber, id, 0, password);
        accounts.add(account);

        System.out.println("Alright " + name + ", your account has been created! Now go fill me up.");
    }

    public void Login() {
        System.out.println("Account number next: ");
        String accountNumber = scanner.nextLine();
        System.out.println("Password please: ");
        String password = scanner.nextLine();

        Account matchedAccount = null;
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber) && account.getPassword().equals(password))
                System.out.println("Login Sucessful"); {
                matchedAccount = account;
                break;
            }
        }
        

        System.out.println("Hey, this is your account, right? " + matchedAccount);
        System.out.println("Welcome to your Frendy login page. What do you wanna do?");

        while (true) {
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Transactions");
            System.out.println("6. Delete Account");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Here you go: " + matchedAccount.getBalance());
                    break;

                case 2:
                    System.out.println("How much do you want to deposit?");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    matchedAccount.deposit(depositAmount);
                    System.out.println("You have added " + depositAmount + " to your account");
                    break;

                case 3:
                    System.out.println("How much do you want to withdraw?");
                    double moneygone = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Input your password: ");
                    String pass = scanner.nextLine();
                    

                    if (moneygone > matchedAccount.getBalance() && matchedAccount.getPassword().equals(password)) {
                        System.out.println("Insufficient funds. You cannot withdraw more than your balance.");
                        break;
                    }
                    else{
                    matchedAccount.Withdraw(moneygone);
                    System.out.println("You have withdrawn " + moneygone + " from your account");
                    break;
                    }

                case 4:
                    System.out.println("Input the account number you want to send it to: ");
                    String targetAccountNumber = scanner.nextLine();
                    System.out.println("Input the amount you want to send: ");
                    double transferAmount = scanner.nextDouble();
                    scanner.nextLine();

                    Account targetAccount = null;
                    for (Account account : accounts) {
                        if (account.getAccountNumber().equals(targetAccountNumber)) {
                            targetAccount = account;
                            break;
                        }
                    }

                    if (targetAccount == null) {
                        System.out.println("Target account not found.");
                        break;
                    }

                    if (transferAmount > matchedAccount.getBalance()) {
                        System.out.println("Insufficient funds. Go work.");
                        break;
                    }

                    matchedAccount.Withdraw(transferAmount);
                    targetAccount.deposit(transferAmount);
                    System.out.println("Transfer successful.");
                    break;

                case 5:
                        if (transactions.isEmpty()) {
                            System.out.println("No transactions yet.");
                            break;
                        }

                        for (Transaction t : transactions) {
                            if (t.getAccountNumber() == matchedAccount.getCustomerId()) { // or use account number if you store it properly
                                System.out.println(t);
                            }
                        }
                        break;

                    case 6:
                        System.out.println("Password please: ");
                        String confirmPassword = scanner.nextLine();

                        if (!matchedAccount.getPassword().equals(confirmPassword)) {
                            System.out.println("Incorrect password.");
                            break;
                        }

                        System.out.println("Are you sure you want to delete this account? (yes/no)");
                        String answer = scanner.nextLine();

                        if (answer.equalsIgnoreCase("yes")) {
                            accounts.remove(matchedAccount);
                            System.out.println("Account deleted successfully.");
                            return;
                        } else {
                            System.out.println("Account not deleted.");
                        }
                            break;
                   

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

    public void Exit() {
        System.out.println("Thanks for banking with Frendy. Goodbye!");
        scanner.close();
        System.exit(0);
    }
    public void saveAccounts(){
        try (PrintWriter pw = new PrintWriter("accounts.txt")){
            for (Account a : accounts){
                pw.println(a.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Could not save accounts");
        }
    }
    public void loadAccounts(){
        try (BufferedReader br = new BufferedReader(new FileReader(("accounts.txt")))){
            String line;
            while ((line = br.readLine()) != null) {
                accounts.add(Account.fromFileString(line));
            }
        } catch (IOException e) {
            System.out.println("Error somewhere...");
        }
    }

    
}