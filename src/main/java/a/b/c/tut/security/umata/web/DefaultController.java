package a.b.c.tut.security.umata.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DefaultController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/noSecurity")
    public String noSecurity(){
        return "noSecurity";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }
}