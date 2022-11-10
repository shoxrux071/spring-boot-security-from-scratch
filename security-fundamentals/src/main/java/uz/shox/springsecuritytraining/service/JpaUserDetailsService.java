package uz.shox.springsecuritytraining.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.shox.springsecuritytraining.SecurityUser;
import uz.shox.springsecuritytraining.domains.User;
import uz.shox.springsecuritytraining.repo.UserRepository;

import java.util.Optional;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 16:16 (Wednesday)
 * spring-security-training/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userByUsername = userRepository.findUserByUsername(username);
        return userByUsername.map(SecurityUser::new).orElseThrow(() -> new UsernameNotFoundException("user not found"));


    }
}
