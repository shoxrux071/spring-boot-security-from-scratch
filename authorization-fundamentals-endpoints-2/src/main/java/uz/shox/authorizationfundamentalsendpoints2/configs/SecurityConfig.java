package uz.shox.authorizationfundamentalsendpoints2.configs;

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
 * @since 11/11/22 23:30 (Friday)
 * spring-secutiy-from-scratch/IntelliJ IDEA
 */
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
       return httpSecurity.httpBasic().and()
                .authorizeRequests()
                .mvcMatchers("/demo/demo1").authenticated()
                .anyRequest().hasAnyAuthority("write")
                .and().build();
    }



    @Bean
    public UserDetailsService userDetailsService(){
      var manager  =  new InMemoryUserDetailsManager();


        UserDetails user1 = User.withUsername("asal").password(passwordEncoder().encode("1")).authorities("write").build();
        UserDetails user2 = User.withUsername("kiyik").password(passwordEncoder().encode("2")).authorities("read","write").build();
        UserDetails user3 = User.withUsername("3").password(passwordEncoder().encode("3")).authorities("detele").build();
        manager.createUser(user1);
        manager.createUser(user2);
        manager.createUser(user3);
        return manager;

    }
@Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
