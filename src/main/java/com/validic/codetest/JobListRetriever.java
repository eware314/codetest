package com.validic.codetest;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Component
public class JobListRetriever {

    private RestTemplate restTemplate;

    public JobListRetriever(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Job> getJobList(List<String> languages, List<String> cities) throws UnsupportedEncodingException {

        List<Job> jobList = new ArrayList<>();
        for (String city : cities) {
            for (String language : languages) {
                boolean search = true;
                int pageNumber = 0;
                while (search) {
                    HashMap<String, String> params = new HashMap<>();
                    params.put("language", language);
                    params.put("city", city);
                    params.put("pageNumber", "" + pageNumber);
                    Job[] jobs = restTemplate
                            .getForObject
                                    ("https://jobs.github.com/positions.json?description={language}&location={city}&page={pageNumber}", Job[].class, params);
                    for (Job job : jobs) {
                        job.setCity(city);
                        job.setLanguage(language);
                    }
                    Collections.addAll(jobList, jobs);
                    if (jobs.length == 50) {
                        pageNumber++;
                    } else {
                        search = false;
                    }
                }
            }
        }

        return jobList;
    }
}
