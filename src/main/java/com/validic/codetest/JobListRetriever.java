package com.validic.codetest;

import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class JobListRetriever {

    public List<Job> getJobList(List<String> languages, List<String> cities) {

        RestTemplate restTemplate = new RestTemplate();
        Job[] jobs = restTemplate.getForObject("https://jobs.github.com/positions.json?description=python&location=new+york", Job[].class);

        List<Job> jobList = Arrays.asList(jobs);
        return jobList;
    }
}
