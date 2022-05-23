package com.efecte.postit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Application to serve RESTful API for a Post (Note)
 */
@SpringBootApplication
public class PostItApplication {

    /**
     * Main method for JVM to trigger the application
     *
     * @param args String array args.
     */
    public static void main(String[] args) {
        SpringApplication.run(PostItApplication.class, args);
    }

}
