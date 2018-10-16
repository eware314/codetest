package com.validic.codetest;

import java.util.List;
import java.util.Map;

public class ConsoleReportWriter implements IReportWriter {

    @Override
    public void generateReportToConsole(Map<String, Map<String, Map<String, List<Job>>>> jobMap) {

        //loop over the job map and print out city, then in the inner loop, print language and stats

        //track the total jobs processed
        int grandTotal = 0;

        for (String city : jobMap.keySet()) {
            int jobTotalByCity = 0;
            System.out.println(city);
            Map<String, Map<String, List<Job>>> languageMap = jobMap.get(city);
            for (String language : languageMap.keySet()) {
                System.out.println("\t- " + language);
                Map<String, List<Job>> jobTypeMap = languageMap.get(language);
                for (String jobType : jobTypeMap.keySet()) {
                    //capture list size to get total by city and update total jobs
                    int size = jobTypeMap.get(jobType).size();
                    jobTotalByCity += size;
                    System.out.println("\t\t- " + jobType + "    " + size / jobTotalByCity * 100 + " %");
                }
            }

            grandTotal += jobTotalByCity;
        }
        System.out.println("\n\n Sourced " + grandTotal + "total jobs");

    }

}
