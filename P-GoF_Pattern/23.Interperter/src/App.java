public class App {
    public static void main(String[] args) throws Exception {

        // String script = "BEGIN   FRONT   LOOP    2   BACK    RIGHT    END    BACK    END";
        // Context context = new Context(script);
        // while (true) {
        //     String keyword = context.getCurrentKeyword();
        //     if (keyword == null)
        //         break;
        //     System.out.println(keyword);
        //     context.readNextKeyword();
        // }
        String script = "BEGIN  FRONT LOOP 2 BACK RIGHT LEFT END    BACK    END FRONT   LOOP 4";
        System.out.println(script);

        Context context = new Context(script);
        Expression expression = new BeginExpression();

        if (expression.parse(context)) {
            System.out.println(expression);
            expression.run();
        }
    }
}
