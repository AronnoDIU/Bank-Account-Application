import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();

        //Read a CSV File, then create new accounts based on that data
        String file = "C:\\Users\\aronn\\IdeaProjects\\zzzLinksFolder\\NewBankAccounts.csv";
        List<String[]> newAccountHolders = CSV.read(file);
        for (String[] accountHolder : newAccountHolders) {
            String NamesAH = accountHolder[0];
            String socialSecurityNumbers = accountHolder[1];
            String accountType = accountHolder[2];
            double initialDeposit = Double.parseDouble(accountHolder[3]);

            if (accountType.equals("Savings")) {
                accounts.add(new Savings(NamesAH, socialSecurityNumbers, initialDeposit));
            }
            else if (accountType.equals("Checking")){
                accounts.add(new Checking(NamesAH, socialSecurityNumbers, initialDeposit));
            }
            else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }

        for (Account acc : accounts) {
            System.out.println("\n**********************");
            acc.showInfo();
        }
    }
}

/* Expected output:

Application should do the following:

    Read a .csv file of names, social security numbers, account type, and initial deposit
    Use a proper data structure to hold all these accounts
    Both savings and checking accounts share the following properties
        deposit()
        withdraw()
        transfer()
        showInfo()
    Each account has a unique 10-digit account number that is generated with the following process:
        1 or 2 depending on Savings or Checking, last two digits of SSN, unique 5-digit number,
        and random 3-digit number,
        3 or 4 depending on Savings or Checking, last two digits of SSN, unique 5-digit number,
        11-Digit Account Number (generated with the following process: 1 or 2 depending on
        Savings or Checking, last two digits of SSN, unique 5-digit number, and random 3-digit number)
    Savings Account holders are given a Safe deposit box, identified by a 3-digit number and
    assigned a 6-digit account number that is accessed with a 4-digit code
    Checking Account holders are assigned a Debit Card with a 12-digit number and 4-digit PIN
    Both accounts will use an interface that determines the base interest rate.
        Saving an account will use .25 points less than the base rate
        Checking accounts will use 15% of the base rate
    The showInfo() method should reveal relevant account information as well as
    other information specific to the Checking account or Savings account

*/