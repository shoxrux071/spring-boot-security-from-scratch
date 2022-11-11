package uz.shox.creatingmultipleauthenticationproviders.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 11/11/22 05:01 (Friday)
 * spring-secutiy-from-scratch/IntelliJ IDEA
 */
@RestController
public class DemoController {
    @GetMapping("/demo")
    public String demo(){
        return "demor";
    }
}
