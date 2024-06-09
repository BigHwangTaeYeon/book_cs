import prac.DiceGetNumber;
import prac.DiceSumStrategy;
import prac.SumPrintStrategy;

public class App {
    public static void main(String[] args) throws Exception {

        // SumPrinter cal = new SumPrinter();
        // cal.print(new SimpleSumStrategy(), 10);
        // cal.print(new GaussSumStrategy(), 10);

        // NumberStrategy num = new DiceGetNumber();
        // SumPrintStrategy ss = new DiceSumStrategy(num.getNumb(), num.getNumb());
        // ss.print();
        // SumPrintStrategy ss1 = new DiceSumStrategy(num.getNumb(), num.getNumb());
        // ss1.print();
        // SumPrintStrategy ss2 = new DiceSumStrategy(num.getNumb(), num.getNumb());
        // ss2.print();

        SumPrintStrategy sumPrint = new DiceSumStrategy();
        sumPrint.print(new DiceGetNumber());
    }
}
