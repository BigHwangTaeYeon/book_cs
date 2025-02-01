package A_before;

import java.time.LocalDateTime;

public class Post {
    private String title;
    private String content;
    private LocalDateTime createDateTime;

    public Post(String content) {
        this.content = content;
        this.createDateTime = LocalDateTime.now();
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public LocalDateTime getCreateDateTime() {
        return this.createDateTime;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createDateTime=" + createDateTime +
                '}';
    }
}
