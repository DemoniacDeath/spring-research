package me.demoniacdeath.springtest.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@SpringBootApplication
@EnableWebSecurity
@Controller
@EnableZuulProxy
public class UIApp {
    public static void main(String[] args) {
        SpringApplication.run(UIApp.class, args);
    }

    @Configuration
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .httpBasic()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/index.html", "/", "/home", "/login", "/**/*.js", "/**/*.css").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .csrf()
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                    .and()
                    .formLogin().loginPage("/login")
            ;
        }
    }

    @SuppressWarnings("MVCPathVariableInspection")
    @GetMapping(value = "/**/{path:[^.]*}")
    public String redirect() {
        return "forward:/";
    }

    @ResponseBody
    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
