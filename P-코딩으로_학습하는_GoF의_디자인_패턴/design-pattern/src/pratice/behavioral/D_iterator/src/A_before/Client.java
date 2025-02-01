package A_before;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Board board = new Board();
        board.addPost("content1");
        board.addPost("content2");
        board.addPost("content3");

        List<Post> posts = board.getPosts();
        for (int i = 0; i < posts.size(); i++) {
            Post post = posts.get(i);
            System.out.println("post = " + post.getTitle());
        }

        Collections.sort(posts, (p1, p2) -> p2.getCreateDateTime().compareTo(p1.getCreateDateTime()));
        for (int i = 0; i < posts.size(); i++) {
            Post post = posts.get(i);
            System.out.println("post.getTitle() = " + post.getTitle());
        }
    }
}
