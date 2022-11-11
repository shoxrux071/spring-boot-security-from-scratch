package uz.shox.authorizationfundamentalsendpoints2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 11/11/22 23:27 (Friday)
 * spring-secutiy-from-scratch/IntelliJ IDEA
 */
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("test1")
    public String test1(){
        return "test1";
    }
    @GetMapping("test2")
    public String test2(){
        return "test2";
    }


}
