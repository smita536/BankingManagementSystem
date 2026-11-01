
import java.time.LocalDate;

public class Transaction {

    private int tid;
    private String transaction_type;
    private int acno;
    private LocalDate transaction_date;

    // Constructor
    public Transaction(int tid, String transaction_type,
                       int acno, LocalDate transaction_date) {

        this.tid = tid;
        this.transaction_type = transaction_type;
        this.acno = acno;
        this.transaction_date = transaction_date;
    }

    // Getter methods
    public int getTid() {
        return tid;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public int getAcno() {
        return acno;
    }

    public LocalDate getTransaction_date() {
        return transaction_date;
    }

    // Display transaction details
    public void displayTransaction() {
        System.out.println("Transaction ID: " + tid);
        System.out.println("Transaction Type: " + transaction_type);
        System.out.println("Account Number: " + acno);
        System.out.println("Transaction Date: " + transaction_date);
    }
}
