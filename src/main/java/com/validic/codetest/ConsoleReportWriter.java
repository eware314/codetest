package com.validic.codetest;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ConsoleReportWriter implements IReportWriter {

    @Override
    public void generateReportToConsole(Map<String, Map<String, Map<String, List<Job>>>> jobMap) {

        //loop over the job map and print out city, then in the inner loop, print language and stats

        //track the total jobs processed
        int grandTotal = 0;

        for (String city : jobMap.keySet()) {
            int jobTotalByCity = getJobTotalByCity(jobMap, city);

            System.out.println(city);
            Map<String, Map<String, List<Job>>> languageMap = jobMap.get(city);
            for (String language : languageMap.keySet()) {
                System.out.println("\t- " + language);
                Map<String, List<Job>> jobTypeMap = languageMap.get(language);
                for (String jobType : jobTypeMap.keySet()) {
                    //capture list size to get total by city and update total jobs
                    int size = jobTypeMap.get(jobType).size();
                    //int rounding is not very accurate, could use BigDecimal instead
                    System.out.println("\t\t- " + jobType + "    " + (size * 100 / jobTotalByCity) + " %");
                }
            }

            grandTotal += jobTotalByCity;
        }
        System.out.println("\n\n Sourced " + grandTotal + " total jobs");

    }

    private int getJobTotalByCity(Map<String, Map<String, Map<String, List<Job>>>> jobMap, String city) {
        int jobTotalByCity = 0;
        Collection<Map<String, List<Job>>> languages = jobMap.get(city).values();
        for (Map<String, List<Job>> language : languages) {
            for (List<Job> jobs : language.values()) {
                jobTotalByCity += jobs.size();
            }
        }
        return jobTotalByCity;
    }

}
