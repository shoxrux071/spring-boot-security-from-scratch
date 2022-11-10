package uz.shox.lesson3.security.manager;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import uz.shox.lesson3.security.providers.CustomAuthenticationProvider;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 10/11/22 16:53 (Thursday)
 * customizing-authentication-system/IntelliJ IDEA
 */
@AllArgsConstructor
@Component
public class CustomAuthenticationManager implements AuthenticationManager {
    private final CustomAuthenticationProvider provider;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
       if (provider.supports(authentication.getClass())){
         return provider.authenticate(authentication);
       }
       throw new BadCredentialsException("oh noo");
    }
}
//@Component
//@AllArgsConstructor
//public class CustomAuthenticationManager implements AuthenticationManager {
//
//    private final CustomAuthenticationProvider provider;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        if (provider.supports(authentication.getClass())) {
//            return provider.authenticate(authentication);
//        }
//
//        throw new BadCredentialsException("Oh No!");
//    }
//}