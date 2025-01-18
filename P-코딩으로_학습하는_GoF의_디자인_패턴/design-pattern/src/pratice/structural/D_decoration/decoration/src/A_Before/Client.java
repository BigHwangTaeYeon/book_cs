package A_Before;

public class Client {
    private CommentService commentService;

    public Client(CommentService commentService) {
        this.commentService = commentService;
    }

    private void writeComment(String comment) {
        commentService.addComment(comment);
    }

    public static void main(String[] args) {
        Client client = new Client(new TrimmingCommentService());
        client.writeComment("O game");
        client.writeComment("no fun...");
        client.writeComment("http://utteok.com");
    }
}
