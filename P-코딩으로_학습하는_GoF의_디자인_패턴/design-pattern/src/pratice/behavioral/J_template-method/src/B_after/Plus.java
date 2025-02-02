package B_after;

public class Plus extends FileProcessor{
    public Plus(String path) {
        super(path);
    }

    @Override
    protected int getResult(int result, String line) {
        return result += Integer.parseInt(line);
    }
}
