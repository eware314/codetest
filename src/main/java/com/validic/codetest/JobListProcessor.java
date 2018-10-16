package com.validic.codetest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

import static java.util.stream.Collectors.groupingBy;

public class JobListProcessor {

    public Map<String, Map<String, Map<String, List<Job>>>> groupByCityLanguageAndType(List<Job> persons) {
        Map<String, Map<String, Map<String, List<Job>>>> jobsByCityLanguageAndType = persons.stream().collect(
                groupingBy(Job::getCity,
                        groupByLanguageAndType()
                )
        );
//        System.out.println("" +
//                jobsByCityLanguageAndType.get("Boston").get("Java").get("fullTime").size());

        return jobsByCityLanguageAndType;
    }

    private Collector<Job, ?, Map<String, Map<String, List<Job>>>> groupByLanguageAndType() {
        return groupingBy(Job::getLanguage, groupingBy(Job::getType));
    }


}
