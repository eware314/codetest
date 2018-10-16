package com.validic.codetest;

import java.util.List;
import java.util.Map;

public class JobStatsGenerator {

    public void generateJobStats(List<String> languages, List<String> cities) {

        //Retrieve list of jobs from github API
        List<Job> jobList = new JobListRetriever().getJobList(languages, cities);


        //Process list into job report
        Map<String, Map<String, Map<String, List<Job>>>> jobMap = new JobListProcessor().groupByCityLanguageAndType(jobList);


        //output job report
        ConsoleReportWriter reportWriter = new ConsoleReportWriter();
        reportWriter.generateReportToConsole(jobMap);

    }

}
