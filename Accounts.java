import java.util.Scanner;
public class Accounts
{
   String AccountHolder;
   double Balance; 

public Accounts (String accountHolder, double balance)
    {
    this.AccountHolder = accountHolder;
    this.Balance = balance;

    }

    public void Deposit(double amount)
    {
      System.out.println( "Dear " + AccountHolder + ", Money has been added to your account");
      System.out.println();
      return;
    }
    public void Withdraw(double amount)
    {
        if (amount <= 0)
        {
            System.out.println("Dear " + AccountHolder + ", Insufficient funds. Go work, nothing for you");
            System.out.println();
            return;
        }
        else
        { 
            Balance -= amount;
            System.out.println("Dear " + AccountHolder + ", Withdrawal of " + amount + " in progress");
        }

    }    
    public void displayAccount()
    {
        System.out.println("Dear " + AccountHolder + ", Here is your account balance: " + Balance);
        System.out.println();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Accounts account1 = new Accounts("Franklin", 0);
        System.out.println("Enter deposit amount for franklin");
        account1.Deposit (sc.nextDouble());

        System.out.println("Enter withdrawal Amount for Franklin");
        account1.Withdraw(sc.nextDouble());
        account1.displayAccount();

        Accounts account2 = new Accounts("David", 42000);
        account2.displayAccount();

        System.out.println("Enter withdrawal Amount for David");
        account2.Withdraw(sc.nextDouble());
        account2.displayAccount();

        Accounts account3 = new Accounts("Bernice", 91000);
        account3.displayAccount();
        System.out.println("Enter withdrawal Amount for Michael (or 0 to skip): ");
        double amt = sc.nextDouble();
        if (amt>0)
        {
            account3.Withdraw(amt);
            account3.displayAccount();
        }
        
        sc.close();
    }
        
      
        
    




}