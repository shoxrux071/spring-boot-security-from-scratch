package uz.shox.creatingmultipleauthenticationproviders.configs.filters;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.shox.creatingmultipleauthenticationproviders.configs.authentication.ApiKeyAuthentication;
import uz.shox.creatingmultipleauthenticationproviders.configs.managers.CustomAuthenticationManager;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 11/11/22 04:47 (Friday)
 * spring-secutiy-from-scratch/IntelliJ IDEA
 */
@Component
@AllArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter {

    private final String key;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        CustomAuthenticationManager manager = new CustomAuthenticationManager(key);

        var requestKey = request.getHeader("x-api-key");

        if (requestKey == null || "null".equals(requestKey)) {
            filterChain.doFilter(request, response);
        }

        var auth = new ApiKeyAuthentication(requestKey);

        try {
            var a = manager.authenticate(auth);
            if (a.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(a);
                filterChain.doFilter(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } catch (AuthenticationException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}