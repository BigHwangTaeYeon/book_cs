public class App {
    public static void main(String[] args) throws Exception {
        Strings strings = new Strings();

        strings.add("123");
        strings.add("234");
        strings.add("345");
        strings.add("456");
        strings.add("567");

        // strings.print();

        Item decorator = new SideDecorator(strings, '\"');
        decorator = new LineNumberDecorator(decorator);
        decorator = new BoxDecorator(decorator);

        decorator.print();

    }
}
