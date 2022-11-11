package uz.shox.creatingmultipleauthenticationproviders.configs.authentication;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.security.auth.Subject;
import java.util.Collection;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 11/11/22 04:53 (Friday)
 * spring-secutiy-from-scratch/IntelliJ IDEA
 */
@RequiredArgsConstructor
public class ApiKeyAuthentication implements Authentication {

    private final String key;
    private boolean authenticated;

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
        this.authenticated = authenticated;
    }

    public String getKey() {
        return key;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean implies(Subject subject) {
        return Authentication.super.implies(subject);
    }

    @Override
    public String getName() {
        return null;
    }
}