package uz.shox.authorizationfundamentalsendpoints.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 11/11/22 20:09 (Friday)
 * spring-secutiy-from-scratch/IntelliJ IDEA
 */
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.httpBasic().and()
//                .authorizeRequests().anyRequest().authenticated()
//                .authorizeRequests().anyRequest().permitAll()
//                .authorizeRequests().anyRequest().denyAll()
//                .authorizeRequests().anyRequest().access("isAuthenticated() and hasAnyAuthority('write')")
                .authorizeRequests().anyRequest().hasAnyAuthority("read")
                .and().build();

    }
@Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        UserDetails userDetails = User.withUsername("shox").password(passwordEncoder().encode("777")).authorities("read").build();
        UserDetails userDetails1 = User.withUsername("ogabek").password(passwordEncoder().encode("877")).authorities("read","write").build();

        inMemoryUserDetailsManager.createUser(userDetails);
        inMemoryUserDetailsManager.createUser(userDetails1);

        return inMemoryUserDetailsManager;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }







}
