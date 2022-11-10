package uz.shox.lesson3.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import uz.shox.lesson3.security.filter.CustomAuthenticationFilter;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 10/11/22 16:20 (Thursday)
 * lesson-3/IntelliJ IDEA
 */
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomAuthenticationFilter filter;
@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .addFilterAt(filter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests().anyRequest().authenticated().and()
                .build();
    }
}
