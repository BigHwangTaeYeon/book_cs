package prac;

public class DiceSumStrategy extends SumPrintStrategy {

    @Override
    public void print(NumberStrategy num) {
        int sum = num.getNumb() + num.getNumb();
        System.out.println("Sum to Dice : " + sum);
    }

}
