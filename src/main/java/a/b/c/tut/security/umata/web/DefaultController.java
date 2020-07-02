package a.b.c.tut.security.umata.web;

import a.b.c.tut.security.umata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class DefaultController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping("/user-details")
    public String userDetails(Model model, @Autowired Principal principal) {
        model.addAttribute("user", userRepository.findByUsername(principal.getName()));
        return "user-details";
    }

    @RequestMapping("/noSecurity")
    public String noSecurity(){
        return "noSecurity";
    }

    @RequestMapping("/noSecurity/index")
    public String noSecurityIndex(){
        return "noSecurity";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }
}