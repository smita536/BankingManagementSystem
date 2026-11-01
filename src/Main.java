
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Login credentials
        String correctUserId = "Debasmita";
        String correctPassword = "Smita@123";

        boolean loginSuccess = false;

        // Login validation
        while (!loginSuccess) {

            System.out.print("Enter userId: ");
            String userId = sc.nextLine();

            System.out.print("Enter password: ");
            String password = sc.nextLine();

            if (userId.equals(correctUserId)
                    && password.equals(correctPassword)) {

                System.out.println("Login Successful...");
                loginSuccess = true;

            } else {

                System.out.println("Invalid Login...");

                System.out.print(
                    "Do you want to continue? (1/0): "
                );

                int continueChoice = sc.nextInt();
                sc.nextLine();

                if (continueChoice != 1) {
                    System.out.println("Exiting application...");
                    sc.close();
                    return;
                }
            }
        }

        // Create BankService only after successful login
        BankService bank = new BankService();

        int choice;

        do {
            System.out.println(
                "\n===== BANKING MANAGEMENT SYSTEM ====="
            );
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Search Account");
            System.out.println("4. Deposit Money");
            System.out.println("5. Withdraw Money");
            System.out.println("6. Delete Account");
            System.out.println("7. View Transactions");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter account number: ");
                    int acno = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter account type: ");
                    String type = sc.nextLine();

                    System.out.print("Enter initial balance: ");
                    double balance = sc.nextDouble();

                    Customer customer = new Customer(
                        acno, name, email, type, balance
                    );

                    bank.createAccount(customer);
                    break;

                case 2:
                    bank.viewAccounts();
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    acno = sc.nextInt();

                    bank.searchAccount(acno);
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    acno = sc.nextInt();

                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();

                    bank.deposit(acno, depositAmount);
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    acno = sc.nextInt();

                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();

                    bank.withdraw(acno, withdrawAmount);
                    break;

                case 6:
                    System.out.print(
                        "Enter account number to delete: "
                    );
                    acno = sc.nextInt();

                    bank.deleteAccount(acno);
                    break;

                case 7:
                    bank.viewTransactions();
                    break;

                case 8:
                    System.out.println(
                        "Thank you for using our banking system!"
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice. Please try again."
                    );
            }

        } while (choice != 8);

        sc.close();
    }
}
