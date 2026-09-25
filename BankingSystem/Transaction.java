package BankingSystem;

public class Transaction {
    private int id;
    private int accountNumber;
    private String type;
    private int amount;
    private String date;
    private String reason;
    private String status;

    public Transaction(int id, int accountNumber, String type, int amount, String date, String reason, String status) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.reason = reason;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getReason() {
        return reason;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Transaction [id=" + id + ", accountNumber=" + accountNumber + ", type=" + type + ", amount=" + amount
                + ", date=" + date + ", reason=" + reason + ", status=" + status + "]";
    }




    

}
