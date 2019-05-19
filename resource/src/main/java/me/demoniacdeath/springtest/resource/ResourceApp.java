package me.demoniacdeath.springtest.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@SpringBootApplication
@RestController
public class ResourceApp extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(ResourceApp.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.NEVER)
        ;
    }

    @ResponseBody
    @RequestMapping("/")
    public Greeting home() {
        return new Greeting("Hello World");
    }

    public static class Greeting {
        private String id = UUID.randomUUID().toString();
        private String content;

        public String getId() {
            return id;
        }

        public String getContent() {
            return content;
        }

        Greeting(String content) {
            this.content = content;
        }
    }
}
