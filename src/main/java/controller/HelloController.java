package controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/user/hello")
    @Secured("USER")
    public String helloUser() {
        return "Hello, user!";
    }

    @GetMapping("/admin/hello")
    @Secured("ADMIN")
    public String helloAdmin() {
        return "Hello, admin!";
    }
}
