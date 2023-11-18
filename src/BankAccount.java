import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    public static void main(String[] args) {
        // Create an empty list of accounts
        List<Account> accounts = new ArrayList<>();

        // Read a CSV File, then create new accounts based on that data
        String file = "C:\\Users\\aronn\\IdeaProjects\\zzzLinksFolder\\NewBankAccounts.csv";

        // Read the CSV file and get the data in a 2D array called newAccountHolders.
        List<String[]> newAccountHolders = CSV.read(file);

        // For each row in the CSV file, create a new account
        for (String[] accountHolder : newAccountHolders) {

            String NamesAH = accountHolder[0];
            String socialSecurityNumbers = accountHolder[1];
            String accountType = accountHolder[2];
            double initialDeposit = Double.parseDouble(accountHolder[3]);

            // Create new accounts based on that data
            if (accountType.equals("Savings")) {
                accounts.add(new Savings(NamesAH, socialSecurityNumbers, initialDeposit));
            }
            else if (accountType.equals("Checking")){
                accounts.add(new Checking(NamesAH, socialSecurityNumbers, initialDeposit));
            }
            else {
                System.out.println("ERROR IN CREATING NEW ACCOUNT. PLEASE TRY AGAIN!");
            }
        }

        // Show information of each account in the list.
        for (Account accountInfo : accounts) {
            System.out.println("\n**********************");
            accountInfo.showInfo();
        }
    }
}