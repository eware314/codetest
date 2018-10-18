package com.validic.codetest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobListProcessorTest {

    //process file with results retrieved from API for two cities with two languages each (San Francisco and New York, java and python)
    @Autowired
    JobListProcessor jobListProcessor;

    @Test
    public void testJobListProcessor() throws IOException {
        //verify the list of jobs is processing into the map objects used for output

        List<Job> jobs = testList();
        Map<String, Map<String, Map<String, List<Job>>>> jobMap = jobListProcessor.groupByCityLanguageAndType(jobs);

        //there should be two maps, one for each city
        Assert.assertEquals(2, jobMap.size());
        //there should be 4 languages in Boston
        Assert.assertEquals(4, jobMap.get("Boston").size());
        //there should be 6 languages in Denver
        Assert.assertEquals(6, jobMap.get("Denver").size());
        //there should be 4 FT python jobs, 1 PT and 1 Unknown in Boston
        Assert.assertEquals(4, jobMap.get("Boston").get("python").get("Full Time").size());
        Assert.assertEquals(1, jobMap.get("Boston").get("python").get("Part Time").size());
        Assert.assertEquals(1, jobMap.get("Boston").get("python").get("Unknown").size());
        Assert.assertEquals(3, jobMap.get("Denver").get("python").get("Full Time").size());
        Assert.assertEquals(1, jobMap.get("Denver").get("python").get("Part Time").size());
        Assert.assertEquals(1, jobMap.get("Denver").get("python").get("Unknown").size());
        Assert.assertEquals(1, jobMap.get("Denver").get("scala").get("Unknown").size());
        Assert.assertEquals(1, jobMap.get("Denver").get("java").get("Full Time").size());
        Assert.assertEquals(2, jobMap.get("Denver").get("groovy").get("Full Time").size());
        Assert.assertEquals(1, jobMap.get("Denver").get("node").get("Full Time").size());
        Assert.assertEquals(1, jobMap.get("Denver").get("html").get("Full Time").size());

    }


    private List<Job> testList() {
        List<Job> jobs = new ArrayList<>();

        jobs.add(new Job("Boston", "python", "Full Time"));
        jobs.add(new Job("Boston", "java", "Full Time"));
        jobs.add(new Job("Boston", "groovy", "Full Time"));
        jobs.add(new Job("Boston", "python", "Full Time"));
        jobs.add(new Job("Boston", "python", "Full Time"));
        jobs.add(new Job("Boston", "groovy", "Full Time"));
        jobs.add(new Job("Boston", "python", "Full Time"));
        jobs.add(new Job("Boston", "html", "Full Time"));
        jobs.add(new Job("Boston", "python", "Part Time"));
        jobs.add(new Job("Boston", "python", "Unknown"));
        jobs.add(new Job("Denver", "python", "Full Time"));
        jobs.add(new Job("Denver", "java", "Full Time"));
        jobs.add(new Job("Denver", "groovy", "Full Time"));
        jobs.add(new Job("Denver", "node", "Full Time"));
        jobs.add(new Job("Denver", "python", "Full Time"));
        jobs.add(new Job("Denver", "groovy", "Full Time"));
        jobs.add(new Job("Denver", "python", "Full Time"));
        jobs.add(new Job("Denver", "html", "Full Time"));
        jobs.add(new Job("Denver", "python", "Part Time"));
        jobs.add(new Job("Denver", "python", "Unknown"));
        jobs.add(new Job("Denver", "scala", "Unknown"));

        return jobs;

    }
}
