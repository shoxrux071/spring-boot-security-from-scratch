package uz.shox.springsecuritytraining;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;
import uz.shox.springsecuritytraining.domains.User;

import java.util.Collection;
import java.util.List;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 16:38 (Wednesday)
 * spring-security-training/IntelliJ IDEA
 */
@AllArgsConstructor
public class SecurityUser implements UserDetails {

    private  User user;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "read");
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
