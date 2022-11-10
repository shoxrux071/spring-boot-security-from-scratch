package uz.shox.springsecuritytraining.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 08/11/22 16:21 (Tuesday)
 * spring-security-training/IntelliJ IDEA
 */
@RestController
public class HomeController {
    @GetMapping("/hello")
    public String hello(){
        return "hello buddy";
    }
}
