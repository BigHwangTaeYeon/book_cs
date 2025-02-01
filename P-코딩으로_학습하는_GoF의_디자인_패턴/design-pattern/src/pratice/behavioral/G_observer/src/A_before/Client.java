package A_before;

public class Client {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();

        User user1 = new User(chatServer);
        user1.sendMessage("디자인 패턴1", "옵저버 패턴");
        user1.sendMessage("디자인 패턴2", "메멘토 패턴");

        User user2 = new User(chatServer);
        System.out.println("user2.getMessage(\"디자인 패턴1\") = " + user2.getMessage("디자인 패턴1"));

        user1.sendMessage("디자인 패턴1", "예제 보는 중");
        System.out.println("user2.getMessage(\"디자인 패턴1\") = " + user2.getMessage("디자인 패턴1"));
    }
}
