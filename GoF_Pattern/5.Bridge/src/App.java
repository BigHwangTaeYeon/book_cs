import prac.AddToBank;
import prac.Bank;
import prac.BankOperInterface;
import prac.DepositOper;
import prac.WithdrawOper;

public class App {
    public static void main(String[] args) throws Exception {

        // String title = "복원된 지구";
        // String author = "김형준";
        // String[] content = {
        //       "AAAAAAAAAAAA  AAAAA"
        //     , "BBB BBBBBBBBBBB BB"
        //     , "CCCCCCC CCCCC  CCCCD"
        // };

        // Draft draft = new Draft(title, author, content);
        // Display display = new SimpleDisplay();
        // draft.print(display);

        // System.out.println();

        // Display display2 = new CaptionDisplay();
        // draft.print(display2);

        // System.out.println();

        // String publisher = "북악출판";
        // int cost = 100;

        // // Publication 추가
        // Publication publication = new Publication(title, author, content, publisher, cost);
        // // publication.print(display);
        // publication.print(display2);

        // Bank bank = new Bank(10000);

        // BankOperInterface bankOper1 = new DepositOper();
        // bankOper1.work(bank, 5000);
        // bankOper1.balancePrint();
        
        // BankOperInterface bankOper2 = new WithdrawOper();

        // bankOper2.work(bank, 3000);
        // bankOper2.balancePrint();

        // bank.work(new WithdrawOper(), 2000);

        AddToBank aBank = new AddToBank(20000, "A");
        aBank.fundWork(new DepositOper());
    }
}
