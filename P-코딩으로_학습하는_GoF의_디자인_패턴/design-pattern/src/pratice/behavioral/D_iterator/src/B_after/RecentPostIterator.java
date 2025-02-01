package B_after;

import A_before.Board;
import A_before.Post;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RecentPostIterator implements Iterator<Post> {
    private Iterator<Post> internalIterator;

    public RecentPostIterator(Board board) {
        List<Post> posts = board.getPosts();
        Collections.sort(posts, (p1, p2) -> p2.getCreateDateTime().compareTo(p1.getCreateDateTime()));
        this.internalIterator = posts.iterator();
    }

    @Override
    public boolean hasNext() {
        return this.internalIterator.hasNext();
    }

    @Override
    public Post next() {
        return this.internalIterator.next();
    }
}
