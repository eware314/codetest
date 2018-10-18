package com.validic.codetest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CodetestApplication {

    @Autowired
    private JobStatsGenerator jobStatsGenerator;

    @Bean
    public JobStatsGenerator jobStatsGenerator(JobListRetriever jobListRetriever, JobListProcessor jobListProcessor, IReportWriter reportWriter) {

        return new JobStatsGenerator(jobListRetriever, jobListProcessor, reportWriter);
    }

    @Bean
    public IReportWriter reportWriter() {
        return new ConsoleReportWriter();
    }

    @Bean
    public JobListProcessor jobListProcessor() {
        return new JobListProcessor();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public JobListRetriever jobListRetriever(RestTemplate restTemplate) {
        return new JobListRetriever(restTemplate);
    }


    public static void main(String[] args) {
        SpringApplication.run(CodetestApplication.class, args);
    }

    @Bean
    CommandLineRunner run() {
        return args -> {

            //hand in list of languages and list of cities we care about
            List<String> languages = Arrays.asList("c#", "python", "java", "ruby", "node", "groovy", "javascript", "swift", "scala", "rust");

            List<String> cities = Arrays.asList("Boston", "San Francisco", "Los Angeles", "Denver", "Boulder", "Chicago", "New York");

            jobStatsGenerator.generateJobStats(languages, cities);

        };
    }

}
