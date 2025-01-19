package B_after;

public class Client {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Character c1 = new Character('h', "white", factory.getFont("nanum:12"));
        Character c2 = new Character('e', "white", factory.getFont("nanum:12"));
        Character c3 = new Character('l', "white", factory.getFont("nanum:12"));
    }
}
