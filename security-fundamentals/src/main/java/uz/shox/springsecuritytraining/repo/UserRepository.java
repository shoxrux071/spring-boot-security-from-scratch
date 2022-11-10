package uz.shox.springsecuritytraining.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.shox.springsecuritytraining.domains.User;

import java.util.Optional;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 16:19 (Wednesday)
 * spring-security-training/IntelliJ IDEA
 */
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("""
        select u from User u where u.username =:username
          """)

     Optional<User> findUserByUsername(String username);

}
