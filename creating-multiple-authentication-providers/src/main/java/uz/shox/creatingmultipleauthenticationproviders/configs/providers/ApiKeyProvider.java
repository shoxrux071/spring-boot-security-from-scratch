package uz.shox.creatingmultipleauthenticationproviders.configs.providers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import uz.shox.creatingmultipleauthenticationproviders.configs.authentication.ApiKeyAuthentication;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 11/11/22 05:21 (Friday)
 * spring-secutiy-from-scratch/IntelliJ IDEA
 */
@RequiredArgsConstructor
public class ApiKeyProvider implements AuthenticationProvider {
    @Value("${the.secret}")
    private final String key;

    @Override
    public boolean supports(Class<?> authentication) {
        return ApiKeyAuthentication.class.equals(authentication.getClass());
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ApiKeyAuthentication apiKeyAuthentication= (ApiKeyAuthentication)authentication;

        if (apiKeyAuthentication.getKey().equals(key)) {
            apiKeyAuthentication.setAuthenticated(true);
            return apiKeyAuthentication;
        }
        throw new BadCredentialsException("oh no");



    }
}
