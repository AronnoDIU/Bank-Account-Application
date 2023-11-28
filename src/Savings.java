public class Savings extends Account {
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    public Savings(String name, String ssn, double initDeposit) {
        super(name, ssn, initDeposit);
        this.accNum = "1" + this.accNum;
        this.setSafetyDepositBox();
    }

    @Override
    public void setRate() {
        this.rate = getBaseRate() - 0.25;
    }

    private void setSafetyDepositBox() {
        this.safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
        this.safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
    }

    public void showInfo() {
        System.out.println("ACCOUNT TYPE: Savings");
        super.showInfo();
        System.out.println("Your Savings Account Features:\n  Safety Deposit Box ID: " + this.safetyDepositBoxID
                + "\n  Safety Deposit Box Key: " + this.safetyDepositBoxKey);
    }
}
