package B_after;

public class Client {
    public static void main(String[] args) {
        Item aa = new Item("doran", 450);
        Item bb = new Item("potion", 50);

        Bag bag = new Bag();
        bag.add(aa);
        bag.add(bb);

        Client client = new Client();
        client.printPrice(aa);
        client.printPrice(bb);
    }
    private void printPrice(Component component) {
        System.out.println("component = " + component.getPrice());
    }
}
