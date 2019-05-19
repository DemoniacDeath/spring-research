package me.demoniacdeath.springtest.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.session.web.http.HeaderHttpSessionIdResolver;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@SpringBootApplication
@RestController
public class ResourceApp {
    public static void main(String[] args) {
        SpringApplication.run(ResourceApp.class, args);
    }

    @ResponseBody
    @RequestMapping("/")
    @CrossOrigin(value = "*", maxAge = 3600, allowedHeaders = {"x-auth-token", "x-requested-with", "x-xsrf-token"})
    public Greeting home() {
        return new Greeting("Hello World");
    }

    @Configuration
    public static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .exceptionHandling()
                    .defaultAuthenticationEntryPointFor(entryPoint(), new AntPathRequestMatcher("/**"))
            .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.NEVER)
            .and()
                .httpBasic()
            .and()
                .cors()
            .and()
                .authorizeRequests()
                    .anyRequest().authenticated()
            ;
        }

        @Bean
        AuthenticationEntryPoint entryPoint() {
            return new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED);
        }
    }

    @Bean
    HeaderHttpSessionIdResolver sessionIdResolver() {
        return HeaderHttpSessionIdResolver.xAuthToken();
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
