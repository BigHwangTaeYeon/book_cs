package A_before;

import java.util.Properties;

public class Client {
    public static void main(String[] args) {
        String to = "to@naver.com";
        String from = "from@gmail.com";
        String host = "127.0.0.1";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);

    }
}
