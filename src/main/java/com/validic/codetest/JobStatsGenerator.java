package com.validic.codetest;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public class JobStatsGenerator {

    private JobListRetriever jobListRetriever;
    private JobListProcessor jobListProcessor;
    private IReportWriter reportWriter;


    @Autowired
    public JobStatsGenerator(JobListRetriever jobListRetriever, JobListProcessor jobListProcessor, IReportWriter reportWriter) {
        this.jobListRetriever = jobListRetriever;
        this.jobListProcessor = jobListProcessor;
        this.reportWriter = reportWriter;
    }


    public void generateJobStats(List<String> languages, List<String> cities) throws UnsupportedEncodingException {

        //Retrieve list of jobs from github API
        List<Job> jobList = jobListRetriever.getJobList(languages, cities);


        //Process list into job report
        Map<String, Map<String, Map<String, List<Job>>>> jobMap = jobListProcessor.groupByCityLanguageAndType(jobList);


        //output job report
        reportWriter.generateReportToConsole(jobMap);

    }

}
