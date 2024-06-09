public class DigitFactory {
    private Digit[] pool = new Digit[] {
        null, null, null, null, null, null, null, null, null, null
    };

    // 인자(n)로 Digit 객체를 전달
    public Digit getDigit(int n) {
        if (pool[n] != null) {
            return pool[n];
        } else {
            String fileName = String.format("C:\\workspace_vs\\GoF_Pattern\\7.Flyweight\\src\\data\\%d.txt", n);
            Digit digit = new Digit(fileName);
            pool[n] = digit;
            return digit;
        }
    }
}
