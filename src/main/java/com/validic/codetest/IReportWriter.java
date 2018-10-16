package com.validic.codetest;

import java.util.List;
import java.util.Map;

public interface IReportWriter {

    public void generateReportToConsole(Map<String, Map<String, Map<String, List<Job>>>> jobMap);
}
