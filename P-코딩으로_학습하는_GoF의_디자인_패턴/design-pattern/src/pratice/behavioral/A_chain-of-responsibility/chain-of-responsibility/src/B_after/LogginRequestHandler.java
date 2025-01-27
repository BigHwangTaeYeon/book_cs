package B_after;

import A_before.Request;

public class LogginRequestHandler extends RequestHandler{
    public LogginRequestHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Request request) {
        System.out.println("로깅");
        super.handle(request);
    }
}
