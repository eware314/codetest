package com.validic.codetest;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

import static java.util.stream.Collectors.groupingBy;

@Component
public class JobListProcessor {

    public Map<String, Map<String, Map<String, List<Job>>>> groupByCityLanguageAndType(List<Job> jobs) {
        Map<String, Map<String, Map<String, List<Job>>>> jobsByCityLanguageAndType = jobs.stream().collect(
                groupingBy(Job::getCity,
                        groupByLanguageAndType()
                )
        );

        return jobsByCityLanguageAndType;
    }

    private Collector<Job, ?, Map<String, Map<String, List<Job>>>> groupByLanguageAndType() {
        return groupingBy(Job::getLanguage, groupingBy(Job::getType));
    }


}
