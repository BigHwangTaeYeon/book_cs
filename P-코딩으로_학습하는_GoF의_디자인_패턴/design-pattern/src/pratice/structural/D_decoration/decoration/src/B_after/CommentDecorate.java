package B_after;

public class CommentDecorate implements CommentService{
    private CommentService commentService;

    public CommentDecorate(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public void addComment(String comment) {
        commentService.addComment(comment);
    }
}
