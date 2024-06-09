package prac;

public class Bank {
    private int balance;

    public Bank(int balance) {
        this.balance = balance;
    }

    public void setBalance(int input) {
        this.balance = input;
    };

    public int getBalance() {
        return this.balance;
    };

    public void work(BankOperInterface bankInterface, int money) {
        bankInterface.work(this, money);
        bankInterface.balancePrint();
    }
}
