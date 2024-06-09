package prac;

public class DepositOper implements BankOperInterface{
    private int result = 0;
    private int balance = 0;
    private int deposit = 0;

    @Override
    public void work(Bank bank, int money) {
        balance = bank.getBalance();
        deposit = money;
        result = balance + deposit;
        bank.setBalance(result);
    }

    @Override
    public void balancePrint() {
        System.out.println(deposit + "원이 입금되어 잔고는 " + result + "원 입니다.");
    }
}
