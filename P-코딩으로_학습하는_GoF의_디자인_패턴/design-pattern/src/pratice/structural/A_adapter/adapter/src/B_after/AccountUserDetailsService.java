package B_after;

import A_before.Account;
import A_before.AccountService;
import A_before.security.UserDetails;
import A_before.security.UserDetailsService;

public class AccountUserDetailsService implements UserDetailsService {
    private AccountService accountService;

    public AccountUserDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUser(String username) {
        Account account = accountService.findAccountByUsername(username);
        return new AccountUserDetails(account);
    }
}
