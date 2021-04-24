package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping(value = "/test")
    public String getAllUser(){
        throw new RuntimeException("user Not Found");
    }

}
