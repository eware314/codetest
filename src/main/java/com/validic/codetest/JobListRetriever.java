package com.validic.codetest;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobListRetriever {

    public List<Job> getJobList(List<String> languages, List<String> cities) {

        //use RestTemplate to retrieve job list from github API, returns JSON
        RestTemplate restTemplate = new RestTemplate();

        List<Job> jobList = new ArrayList<>();
        for (String city : cities) {
            for (String language : languages) {
                Job[] jobs = restTemplate
                        .getForObject("https://jobs.github.com/positions.json?description=" + language + "&location=" + city, Job[].class);
                for (Job job : jobs) {
                    job.setCity(city);
                    job.setLanguage(language);
                }
                Collections.addAll(jobList, jobs);
            }
        }

        return jobList;
    }
}
