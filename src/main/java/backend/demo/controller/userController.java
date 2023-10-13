package backend.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class userController {
    @RequestMapping("/api/user")
    public Principal userUser(Principal user){
        return user;

    }
}
