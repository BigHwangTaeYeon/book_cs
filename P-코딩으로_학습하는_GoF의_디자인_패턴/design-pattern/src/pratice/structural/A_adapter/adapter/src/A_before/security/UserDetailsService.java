package A_before.security;

public interface UserDetailsService {
    UserDetails loadUser(String username);
}
