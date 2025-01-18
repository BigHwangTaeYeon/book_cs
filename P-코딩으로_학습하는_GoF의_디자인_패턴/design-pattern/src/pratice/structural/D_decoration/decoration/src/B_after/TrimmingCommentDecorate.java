package B_after;

public class TrimmingCommentDecorate extends CommentDecorate{
    public TrimmingCommentDecorate(CommentService commentService) {
        super(commentService);
    }

    @Override
    public void addComment(String comment) {
        super.addComment(trim(comment));
    }

    private String trim(String comment) {
        return comment.replace("...", "");
    }
}
