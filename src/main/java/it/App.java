package it;

import controller.SpringBootWebApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App
{
    public static void main( String[] args )    {
        SpringApplication.run(SpringBootWebApplication.class,args);
    }
}
