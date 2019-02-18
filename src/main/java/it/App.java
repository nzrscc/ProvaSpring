package it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Hello world!
 *
 */
@Controller
@SpringBootApplication
public class App 
{

    @RequestMapping("/")
    String home() {
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
