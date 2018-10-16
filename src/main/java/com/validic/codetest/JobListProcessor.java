package com.validic.codetest;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class JobListProcessor {


    public void groupJobsByCityAndLanguage(List<Job> jobs) {

        final Map<String, Map<String, List<Job>>> jobsByCityAndLanguage = jobs.stream().collect(
                groupingBy(Job::getCity,
                        groupingBy(Job::getLanguage)
                )
        );
        System.out.println("");
    }

}
