package uz.shox.springsecuritytraining.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import uz.shox.springsecuritytraining.repo.UserRepository;
import uz.shox.springsecuritytraining.service.JpaUserDetailsService;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 08/11/22 17:39 (Tuesday)
 * spring-security-training/IntelliJ IDEA
 */
@Configuration
public class WebPassword {
@Bean
    public PasswordEncoder passwordEncoder(){
    return NoOpPasswordEncoder.getInstance();
    }

}
