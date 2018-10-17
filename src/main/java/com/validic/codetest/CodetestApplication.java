package com.validic.codetest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CodetestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodetestApplication.class, args);
    }

    @Bean
    CommandLineRunner run() {
        return args -> {

            //hand in list of languages and list of cities we care about
            List<String> languages = Arrays.asList("c#", "python", "java", "ruby", "node", "groovy", "javascript", "swift", "scala", "rust");

            List<String> cities = Arrays.asList("Boston", "San Francisco", "Los Angeles", "Denver", "Boulder", "Chicago", "New York");

            new JobStatsGenerator().generateJobStats(languages, cities);

        };
    }

}
