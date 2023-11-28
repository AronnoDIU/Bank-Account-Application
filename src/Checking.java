public class Checking extends Account {
    private long debitCardNum;
    private int debitCardPIN;

    public Checking(String name, String ssn, double initDeposit) {
        super(name, ssn, initDeposit);
        this.accNum = "2" + this.accNum;
        this.setDebitCard();
    }

    @Override
    public void setRate() {
        this.rate = getBaseRate() * 0.15;
    }

    private void setDebitCard() {
        this.debitCardNum = (long) (Math.random() * Math.pow(10, 12));
        this.debitCardPIN = (int) (Math.random() * Math.pow(10, 4));
    }

    public void showInfo() {
        System.out.println("ACCOUNT TYPE: Checking");
        super.showInfo();
        System.out.println("Your Checking Account Features:\n  Debit Card Number: " + this.debitCardNum
                + "\n  Debit Card PIN: " + this.debitCardPIN);
    }
}
