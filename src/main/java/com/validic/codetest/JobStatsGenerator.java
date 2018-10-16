package com.validic.codetest;

import java.util.List;

public class JobStatsGenerator {

    public void generateJobStats(List<String> languages, List<String> cities) {

        //Retrieve list of jobs from github API
        List<Job> jobList = new JobListRetriever().getJobList(languages, cities);



        //Process list into job report
        new JobListProcessor().groupJobsByCityAndLanguage(jobList);


        //output job report

    }

}
