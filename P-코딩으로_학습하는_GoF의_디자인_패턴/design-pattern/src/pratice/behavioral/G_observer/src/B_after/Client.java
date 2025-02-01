package B_after;

public class Client {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        User user1 = new User("keesun");
        User user2 = new User("whiteship");

        chatServer.register("오겜", user1);
        chatServer.register("오겜", user2);
        chatServer.register("디패", user1);

        chatServer.senMessage(user1, "오겜", "아..");
    }
}
