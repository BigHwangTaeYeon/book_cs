package A_Before;

public class SpamFilteringCommentService extends CommentService{
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
