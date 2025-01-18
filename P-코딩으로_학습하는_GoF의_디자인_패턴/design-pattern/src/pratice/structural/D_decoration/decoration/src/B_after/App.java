package B_after;

public class App {
    private static boolean enableSpan = false;
    private static boolean enableTrim = false;

    public static void main(String[] args) {
        CommentService commentService = new DefaultCommentService();
        if(enableSpan) {
            commentService = new SpamFilteringDecorate(commentService);
        }
        if(enableTrim) {
            commentService = new TrimmingCommentDecorate(commentService);
        }
        Client client = new Client(commentService);
        client.writeComment("O game");
        client.writeComment("no fun...");
        client.writeComment("http://utteok.com");
    }
}
