package uz.shox.authorizationfundamentalsendpoints2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 11/11/22 23:24 (Friday)
 * spring-secutiy-from-scratch/IntelliJ IDEA
 */
@RestController
@RequestMapping("demo")

public class DemoController {

    @GetMapping("/demo1")
    public String demo1(){
        return "demo1";
    }

    @GetMapping("/demo2")
    public String demo2(){
        return "demo2";
    }
}
