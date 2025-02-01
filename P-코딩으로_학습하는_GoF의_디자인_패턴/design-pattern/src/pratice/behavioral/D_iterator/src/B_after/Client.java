package B_after;

import A_before.Board;
import A_before.Post;

import java.util.Iterator;

public class Client {
    public static void main(String[] args) {
        Board board = new Board();
        board.addPost("content1");
        board.addPost("content2");
        board.addPost("content3");

        Iterator<Post> iterator = board.getRecentPostIterator();
        while (iterator.hasNext()) {
            System.out.println("iterator.next() = " + iterator.next());
        }
    }
}
