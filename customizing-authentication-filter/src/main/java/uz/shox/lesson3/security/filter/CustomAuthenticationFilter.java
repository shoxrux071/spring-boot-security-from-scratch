package uz.shox.lesson3.security.filter;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.shox.lesson3.security.authentication.CustomAuthentication;
import uz.shox.lesson3.security.manager.CustomAuthenticationManager;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 10/11/22 16:45 (Thursday)
 * customizing-authentication-system/IntelliJ IDEA
 */
@Component
@AllArgsConstructor
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private final CustomAuthenticationManager authenticationManager;
    @Override
    protected void doFilterInternal(HttpServletRequest request
            , HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        filterChain.doFilter(request,response); // only for the authentication worked;
        String key = String.valueOf(request.getHeader("key"));

        CustomAuthentication authentication = new CustomAuthentication(false,key);


        var authenticate =  authenticationManager.authenticate(authentication);

        if (authenticate.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            filterChain.doFilter(request,response);
        }

    }
}
//@Component
//@AllArgsConstructor
//public class CustomAuthenticationFilter extends OncePerRequestFilter {
//
//    private final CustomAuthenticationManager customAuthenticationManager;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain) throws ServletException, IOException {
//        // 1. create an authentication object which is not yet authenticated
//        // 2. delegate the authentication object to the manager
//        // 3. get back the authentication from the manager
//        // 4. if the object is authenticated then send request to the next filter in the chain
//        String key = String.valueOf(request.getHeader("key"));
//        CustomAuthentication ca = new CustomAuthentication(false, key);
//
//        var a = customAuthenticationManager.authenticate(ca);
//
//        if (a.isAuthenticated()) {
//            SecurityContextHolder.getContext().setAuthentication(a);
//            filterChain.doFilter(request, response); // only when authentication worked
//        }
//    }
//}