package com.selectorhub.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ExtentReports Manager for HTML test reporting
 */
public class ExtentReportManager {
    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private static final String REPORT_DIR = "test-output/reports/";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

    public static void initReports() {
        if (extent == null) {
            String timestamp = LocalDateTime.now().format(DATE_FORMAT);
            String reportPath = REPORT_DIR + "ExtentReport_" + timestamp + ".html";
            
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setDocumentTitle("SelectorHub XPath Practice Automation Report");
            sparkReporter.config().setReportName("Test Execution Report");
            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setTimeStampFormat("yyyy-MM-dd HH:mm:ss");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("User", System.getProperty("user.name"));
            extent.setSystemInfo("Application", "SelectorHub XPath Practice");
        }
    }

    public static ExtentTest createTest(String testName, String description) {
        ExtentTest test = extent.createTest(testName, description);
        extentTest.set(test);
        return test;
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }

    public static void logInfo(String message) {
        getTest().log(Status.INFO, message);
    }

    public static void logPass(String message) {
        getTest().log(Status.PASS, message);
    }

    public static void logFail(String message) {
        getTest().log(Status.FAIL, message);
    }

    public static void logSkip(String message) {
        getTest().log(Status.SKIP, message);
    }

    public static void logWarning(String message) {
        getTest().log(Status.WARNING, message);
    }

    public static void addScreenshot(String screenshotPath) {
        if (screenshotPath != null) {
            try {
                getTest().addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {
                logWarning("Failed to attach screenshot: " + e.getMessage());
            }
        }
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }

    public static void endTest() {
        extentTest.remove();
    }
}
