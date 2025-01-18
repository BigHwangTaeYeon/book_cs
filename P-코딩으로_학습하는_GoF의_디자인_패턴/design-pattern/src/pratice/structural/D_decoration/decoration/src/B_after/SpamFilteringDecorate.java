package B_after;

public class SpamFilteringDecorate extends CommentDecorate{
    public SpamFilteringDecorate(CommentService commentService) {
        super(commentService);
    }

    @Override
    public void addComment(String comment) {
        boolean isSpam = isSpam(comment);
        if(!isSpam) {
            super.addComment(comment);
        }
    }

    private boolean isSpam(String comment) {
        return comment.contains("http");
    }
}
