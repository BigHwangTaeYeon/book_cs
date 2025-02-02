package B_after;

public class Client {
    public static void main(String[] args) {
        FileProcessor fileProcessor = new Plus("num.txt");
        int result = fileProcessor.process();
        System.out.println("result = " + result);
    }
}
