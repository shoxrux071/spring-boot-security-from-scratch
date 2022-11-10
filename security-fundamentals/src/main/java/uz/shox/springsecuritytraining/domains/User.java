package uz.shox.springsecuritytraining.domains;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 16:17 (Wednesday)
 * spring-security-training/IntelliJ IDEA
 */
@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
}
