package me.demoniacdeath.springtest.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
    @CrossOrigin(value = "*", maxAge = 3600)
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
