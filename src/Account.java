/* The parent class for both the Savings & Checking accounts
 This class is defined as abstract as we'll not create objects of this class
 Also, it implements the interface InterestBaseRate to access the base rate*/
public abstract class Account implements InterestBaseRate {
    private static int index = 10000;
    private final String name;
    private final String ssn;
    private double balance;
    protected String accNum;
    protected double rate;

    public Account(String name, String ssn, double initDeposit) {
        index++;
        this.name = name;
        this.ssn = ssn;
        this.balance = initDeposit;
        this.accNum = this.setAccountNum(); // this is a method that returns a string
        this.setRate(); // this is a method that sets the rate
    }

    private String setAccountNum() {
        String lastTwoSsn = ssn.substring(ssn.length() - 2);
        int uniqueFive = index;
        int randThree = (int) (Math.random() * 1000);
        return lastTwoSsn + uniqueFive + randThree;
    }

    // this is an abstract method that will be implemented in the child classes
    public abstract void setRate();

    // this is a method that will be inherited by the child classes
    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Depositing $" + amount);
        this.printBalance();
    }

    // this is a method that will be inherited by the child classes
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal denied.");
        } else {
            this.balance -= amount;
            System.out.println("Withdrawing $" + amount);
            this.printBalance();
        }
    }

    // this is a method that will be inherited by the child classes
    public void transfer(Account toAccount, double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Transfer denied.");
        } else {
            this.balance -= amount;
            toAccount.deposit(amount);
            System.out.println("Transferring $" + amount + " to " + toAccount.accNum);
            this.printBalance();
        }
    }

    // this is a method that will be inherited by the child classes
    public void compound() {
        double accruedInterest = this.balance * (this.rate / 100);
        balance += accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        this.printBalance();
    }

    public void printBalance() {
        System.out.println("Your Balance: $" + this.balance);
    }

    public void showInfo() {
        System.out.println("NAME: " + this.name + "\nACCOUNT NUMBER: " + this.accNum + "\nBALANCE: $" +
                this.balance + "\nRATE: " + this.rate + "%");
    }
}