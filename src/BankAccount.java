import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        String file = "C:\\Users\\aronn\\IdeaProjects\\zzzLinksFolder\\NewBankAccounts.csv";
        List<String[]> newAccountHolders = CSV.read(file);

        for (String[] accountHolder : newAccountHolders) {
            String name = accountHolder[0];
            String ssn = accountHolder[1];
            String accountType = accountHolder[2];
            double initialDeposit = Double.parseDouble(accountHolder[3]);

            switch (accountType) {
                case "Savings":
                    accounts.add(new Savings(name, ssn, initialDeposit));
                    break;
                case "Checking":
                    accounts.add(new Checking(name, ssn, initialDeposit));
                    break;
                default:
                    System.out.println("ERROR IN CREATING NEW ACCOUNT. PLEASE TRY AGAIN!");
            }
        }

        for (Account account : accounts) {
            System.out.println("\n**********************");
            account.showInfo();
            account.deposit(1000); // Deposit $1000
            account.withdraw(500); // Withdraw $500
            account.transfer(accounts.get(0), 200); // Transfer $200 to the first account in the list
            account.compound(); // Compound interest
        }
    }
}