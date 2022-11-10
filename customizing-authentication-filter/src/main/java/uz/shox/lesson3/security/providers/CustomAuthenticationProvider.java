package uz.shox.lesson3.security.providers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import uz.shox.lesson3.security.authentication.CustomAuthentication;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 10/11/22 18:41 (Thursday)
 * customizing-authentication-system/IntelliJ IDEA
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Value("${our.very.very.secret.key}")
    private String key;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        CustomAuthentication authentication1 = (CustomAuthentication) authentication;
        String headerKey = authentication1.getKey();

        if (key.equals(headerKey)){
           return new CustomAuthentication(true,null);
        }
        throw new BadCredentialsException("oh no ");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuthentication.class.equals(authentication);
    }
}
//@Component
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//    @Value("${our.very.very.secret.key}")
//    private String key;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        CustomAuthentication ca = (CustomAuthentication) authentication;
//
//        String headerKey = ca.getKey();
//
//        if (key.equals(headerKey)) {
//            return new CustomAuthentication(true, null);
//        }
//
//        throw new BadCredentialsException("Oh No!");
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return CustomAuthentication.class.equals(authentication);
//    }
//}