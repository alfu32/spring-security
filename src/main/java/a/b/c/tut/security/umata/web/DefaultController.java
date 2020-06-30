package a.b.c.tut.security.umata.web;

import org.springframework.context.annotation.Role;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @RequestMapping("/secure/index")
    public String index() {
        return "You can only see this if you're logged in !";
    }

    @RequestMapping("/pub/index")
    public String noSecurity(){
        return "Everybody can see this !";
    }
}
