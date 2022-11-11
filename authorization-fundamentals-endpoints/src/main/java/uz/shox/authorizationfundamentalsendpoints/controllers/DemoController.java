package uz.shox.authorizationfundamentalsendpoints.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 11/11/22 19:28 (Friday)
 * spring-secutiy-from-scratch/IntelliJ IDEA
 */
@RestController

public class DemoController {
    @GetMapping("/demo")
    public String demo(){
        return "shoxrux";
    }
}
