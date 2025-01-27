package A_before;

public class RequestHandler {
    public void handler(Request request) {
        System.out.println("request = " + request.getBody());
    }
}
