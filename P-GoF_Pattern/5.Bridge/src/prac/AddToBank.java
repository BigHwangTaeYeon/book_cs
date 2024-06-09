package prac;

public class AddToBank extends Bank {
    private int balance;
    private String fund;
    private Bank fundBak;

    public AddToBank(int balance, String fund) {
        super(balance);
        this.fund = fund;
        this.fundBak = new Bank(balance);
    }
    
    public void fundWork(BankOperInterface bankInterface){
        switch (fund) {
            case "A":
                fundBak.work(bankInterface, balance);
                break;
            case "B":
                fundBak.work(bankInterface, balance);
                break;
            case "C":
                fundBak.work(bankInterface, balance);
                break;
            default:
                System.out.println("없는 상품입니다.");
                break;
        }
    }
    
}
