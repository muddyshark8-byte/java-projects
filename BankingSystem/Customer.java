package BankingSystem;

public class Customer {
    private int id;
    private String name;
    private String phone;
    private String Email;
    public Customer(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        Email = email;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return Email;
    }
    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + ", Email=" + Email + "]";
    }


    

    
}
