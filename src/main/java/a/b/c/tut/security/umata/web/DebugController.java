package a.b.c.tut.security.umata.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebugController {

    @Autowired
    private ApplicationContext applicationContext;
    @RequestMapping("/secure/beans")
    public String[] beans(@RequestParam(value="key", required=false, defaultValue="World") String name, Model model) {

        String[] beanNames = applicationContext.getBeanDefinitionNames();

        return beanNames;
    }
}
