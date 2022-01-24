package org.laserhub.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.sql.Timestamp;

public class ExtentReporterNG {
    static ExtentReports extent;


    public static ExtentReports getReportObject() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String path = System.getProperty("user.dir") + "//reports//index" + timestamp + ".html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Sajid Mehmood");
        return extent;

    }
}
