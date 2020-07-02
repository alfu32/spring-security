package a.b.c.tut.security.umata.rest;

import a.b.c.tut.security.umata.entity.User;
import a.b.c.tut.security.umata.repository.UserRepository;
import a.b.c.tut.security.umata.security.user.AuthenticatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
public class DebugController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthenticatedUserService authenticatedUserService;
    @Autowired
    private ApplicationContext applicationContext;
    @RequestMapping(path = "/noSecurity/beans")
    public String[] beans(@RequestParam(value="key", required=false, defaultValue="World") String name, Model model) {

        String[] beanNames = applicationContext.getBeanDefinitionNames();

        return beanNames;
    }
    @RequestMapping(path = "/noSecurity/users")
    public List<User> users() {

        ArrayList<User> users = new ArrayList<>();

        userRepository.findAll().forEach( u -> users.add(u));
        return users;
    }
    @RequestMapping(path = "/noSecurity/user/{username}")
    public User userByName(
            @PathVariable String username
    ) {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            return new User("not","found");
        } else {
            return user;
        }
    }
}
