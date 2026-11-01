
public class Customer {

    private int acno;
    private String cname;
    private String email;
    private String accounttype;
    private double balance;

    // Constructor
    public Customer(int acno, String cname, String email,
                    String accounttype, double balance) {

        this.acno = acno;
        this.cname = cname;
        this.email = email;
        this.accounttype = accounttype;
        this.balance = balance;
    }

    // Getters
    public int getAcno() {
        return acno;
    }

    public String getCname() {
        return cname;
    }

    public String getEmail() {
        return email;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public double getBalance() {
        return balance;
    }

    // Setters
    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Display customer details
    public void displayCustomer() {
        System.out.println("Account Number: " + acno);
        System.out.println("Customer Name: " + cname);
        System.out.println("Email: " + email);
        System.out.println("Account Type: " + accounttype);
        System.out.println("Balance: Rs. " + balance);
    }
}
