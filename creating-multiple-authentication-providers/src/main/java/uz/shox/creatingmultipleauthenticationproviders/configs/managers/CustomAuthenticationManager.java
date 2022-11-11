package uz.shox.creatingmultipleauthenticationproviders.configs.managers;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import uz.shox.creatingmultipleauthenticationproviders.configs.providers.ApiKeyProvider;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 11/11/22 05:13 (Friday)
 * spring-secutiy-from-scratch/IntelliJ IDEA
 */
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {
    private final String key;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var provider = new ApiKeyProvider(key);
        if (provider.supports(authentication.getClass())){
            return provider.authenticate(authentication);
        }
        return authentication;
    }
}
