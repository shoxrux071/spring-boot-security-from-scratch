package uz.shox.lesson3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 10/11/22 16:18 (Thursday)
 * lesson-3/IntelliJ IDEA
 */
@RestController
public class DemoController {
    @GetMapping("/demo")
    public String demo(){
        return "demo baby";
    }
}
