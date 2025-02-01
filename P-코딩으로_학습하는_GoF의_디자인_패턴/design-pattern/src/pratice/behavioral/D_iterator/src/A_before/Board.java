package A_before;

import B_after.RecentPostIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board {
    List<Post> posts = new ArrayList<>();

    public List<Post> getPosts() {
        return posts;
    }

    public void addPost(String content) {
        this.posts.add(new Post(content));
    }

    public Iterator<Post> getRecentPostIterator() {
        return new RecentPostIterator(this);
    }

    // 이렇게도 사용할 수 있다.
    public Iterator<Post> getDefaultIterator() {
        return posts.iterator();
    }
}
