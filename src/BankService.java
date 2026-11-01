
import java.util.ArrayList;
import java.time.LocalDate;

public class BankService {

    private ArrayList<Customer> customers;
    private ArrayList<Transaction> transactions;
    private int nextTransactionId = 1;

    public BankService() {
        customers = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    // Find an account or throw an exception
    private Customer findAccount(int acno)
            throws InvalidAccountException {

        for (Customer customer : customers) {
            if (customer.getAcno() == acno) {
                return customer;
            }
        }

        throw new InvalidAccountException(
            "Account number " + acno + " not found."
        );
    }

    // 1. Create Account
    public void createAccount(Customer customer) {

        try {
            for (Customer existing : customers) {
                if (existing.getAcno() == customer.getAcno()) {
                    throw new InvalidAccountException(
                        "Account number already exists!"
                    );
                }
            }

            if (customer.getBalance() < 0) {
                throw new InvalidAmtException(
                    "Initial balance cannot be negative."
                );
            }

            customers.add(customer);
            System.out.println("Account created successfully!");

        } catch (InvalidAccountException | InvalidAmtException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 2. View All Accounts
    public void viewAccounts() {

        if (customers.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        for (Customer customer : customers) {
            customer.displayCustomer();
            System.out.println("--------------------");
        }
    }

    // 3. Search Account
    public void searchAccount(int acno) {

        try {
            Customer customer = findAccount(acno);
            customer.displayCustomer();

        } catch (InvalidAccountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Record successful transactions
    private void recordTransaction(String type, int acno) {

        Transaction transaction = new Transaction(
            nextTransactionId,
            type,
            acno,
            LocalDate.now()
        );

        transactions.add(transaction);
        nextTransactionId++;
    }

    // 4. Deposit Money
    public void deposit(int acno, double amount) {

        try {
            Customer customer = findAccount(acno);

            if (amount <= 0) {
                throw new InvalidAmtException(
                    "Deposit amount must be greater than zero."
                );
            }

            customer.setBalance(customer.getBalance() + amount);

            recordTransaction("DEPOSIT", acno);

            System.out.println("Deposit successful!");
            System.out.println(
                "Updated Balance: Rs. " + customer.getBalance()
            );

        } catch (InvalidAccountException | InvalidAmtException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 5. Withdraw Money
    public void withdraw(int acno, double amount) {

        try {
            Customer customer = findAccount(acno);

            if (amount <= 0) {
                throw new InvalidAmtException(
                    "Withdrawal amount must be greater than zero."
                );
            }

            if (amount > customer.getBalance()) {
                throw new InsufficientFundsException(
                    "Insufficient balance!"
                );
            }

            customer.setBalance(customer.getBalance() - amount);

            recordTransaction("WITHDRAW", acno);

            System.out.println("Withdrawal successful!");
            System.out.println(
                "Updated Balance: Rs. " + customer.getBalance()
            );

        } catch (InvalidAccountException
                | InvalidAmtException
                | InsufficientFundsException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    // 6. Delete Account
    public void deleteAccount(int acno) {

        try {
            Customer customer = findAccount(acno);
            customers.remove(customer);
            System.out.println("Account deleted successfully!");

        } catch (InvalidAccountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 7. View All Transactions
    public void viewTransactions() {

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        for (Transaction transaction : transactions) {
            transaction.displayTransaction();
            System.out.println("--------------------");
        }
    }
}
