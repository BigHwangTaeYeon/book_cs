package B_after;

import A_before.AccountService;
import A_before.security.LoginHandler;
import A_before.security.UserDetailsService;

public class App {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        UserDetailsService userDetailsService = new AccountUserDetailsService(accountService);
        LoginHandler loginHandler = new LoginHandler(userDetailsService);

        String user = loginHandler.login("hwang", "hwang");
        System.out.println("user = " + user);
    }
}
