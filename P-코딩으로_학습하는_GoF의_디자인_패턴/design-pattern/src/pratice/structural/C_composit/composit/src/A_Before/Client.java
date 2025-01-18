package A_Before;

public class Client {
    public static void main(String[] args) {
        Item doran = new Item("doran", 450);
        Item potion = new Item("potion", 50);

        Bag bag = new Bag();
        bag.add(doran);
        bag.add(potion);

        Client client = new Client();
        client.printPrice(doran);
        client.printPrice(bag);
    }

    private void printPrice(Item item) {
        System.out.println("item = " + item.getPrice());
    }
    private void printPrice(Bag bag) {
        int sum = bag.getItems()
                .stream()
                .mapToInt(Item::getPrice)
                .sum();
        System.out.println("sum = " + sum);
    }
}
