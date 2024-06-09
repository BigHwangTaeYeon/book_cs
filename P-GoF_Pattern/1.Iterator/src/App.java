import test.ArrayDeposit;
import test.Deposit;
import test.Iterator;

public class App {
    public static void main(String[] args) throws Exception {

        // Item[] items = {
        //     new Item("CPU", 100),
        //     new Item("Keyboard", 2000),
        //     new Item("Mouse", 3000),
        //     new Item("HDD", 50)
        // };

        // Array array = new Array(items);
        // Iterator it = array.iterator();

        // while (it.next()) {
        //     Item item = (Item) it.current();
        //     System.out.println(item);
        // }

        Deposit[] dp = {
            new Deposit(100, "hwang"),
            new Deposit(100, "bang"),
            new Deposit(100, "QQQQ"),
            new Deposit(100, "WWWW")
        };

        ArrayDeposit array = new ArrayDeposit(dp);
        Iterator itDp = array.iterator();

        while (itDp.next()) {
            Deposit deposit = (Deposit)itDp.current();
            System.out.println(deposit);
            System.out.println(deposit.getName());
            System.out.println(deposit.getMoney());
        }

    }
}
