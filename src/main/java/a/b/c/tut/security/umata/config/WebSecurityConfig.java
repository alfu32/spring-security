package a.b.c.tut.security.umata.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("{noop}password").roles("USER","ADMIN");
    }
    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     auth
    //             .inMemoryAuthentication()
    //             .withUser("bob").password("{noop}1234").roles("USER")
    //             .and()
    //             .withUser("alferio").password("{noop}1234").roles("USER","ADMIN");
    // }
    //////////////// @Bean
    //////////////// @Override
    //////////////// public UserDetailsService userDetailsService() {
    ////////////////
    //////////////// //User Role
    //////////////// UserDetails theUser = User.withUsername("sergey")
    ////////////////         .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
    ////////////////         .password("12345678").roles("USER").build();
    ////////////////
    //////////////// //Manager Role
    //////////////// UserDetails theManager = User.withUsername("john")
    ////////////////         .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
    ////////////////         .password("87654321").roles("MANAGER").build();
    ////////////////
    ////////////////
    //////////////// InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
    ////////////////
    //////////////// userDetailsManager.createUser(theUser);
    //////////////// userDetailsManager.createUser(theManager);
    ////////////////
    //////////////// return userDetailsManager;
    //////////////// }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/secure/*").authenticated()
                .anyRequest().permitAll()
                .and().formLogin().permitAll()
                .and().logout().permitAll()
                .and()
                .csrf().disable();
        // super.configure(http);
    }
}
