package com.selectorhub.tests;

import com.selectorhub.config.ConfigManager;
import com.selectorhub.driver.DriverManager;
import com.selectorhub.utils.ExtentReportManager;
import com.selectorhub.utils.ScreenshotUtils;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * Base Test class with TestNG lifecycle management
 */
public class BaseTest {
    protected ConfigManager config;

    @BeforeSuite
    public void beforeSuite() {
        ExtentReportManager.initReports();
        System.out.println("=== Test Suite Started ===");
    }

    @BeforeClass
    public void beforeClass() {
        config = ConfigManager.getInstance();
        System.out.println("Test Class: " + this.getClass().getSimpleName() + " initialized");
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        String testName = method.getName();
        String className = this.getClass().getSimpleName();
        
        // Initialize WebDriver
        DriverManager.setDriver(config.getBrowser());
        
        // Create ExtentTest
        ExtentReportManager.createTest(testName, "Test method: " + testName + " in " + className);
        ExtentReportManager.logInfo("Starting test: " + testName);
        ExtentReportManager.logInfo("Browser: " + config.getBrowser());
        ExtentReportManager.logInfo("Base URL: " + config.getBaseUrl());
        
        // Navigate to base URL
        DriverManager.getDriver().get(config.getBaseUrl());
        ExtentReportManager.logInfo("Navigated to: " + config.getBaseUrl());
        
        System.out.println("Starting test: " + testName);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        
        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentReportManager.logFail("Test Failed: " + result.getThrowable().getMessage());
            String screenshotPath = ScreenshotUtils.takeScreenshotOnFailure(testName);
            if (screenshotPath != null) {
                ExtentReportManager.addScreenshot(screenshotPath);
            }
            System.out.println("Test FAILED: " + testName);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentReportManager.logPass("Test Passed Successfully");
            System.out.println("Test PASSED: " + testName);
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExtentReportManager.logSkip("Test Skipped: " + result.getThrowable().getMessage());
            System.out.println("Test SKIPPED: " + testName);
        }
        
        // Quit WebDriver
        DriverManager.quitDriver();
        ExtentReportManager.endTest();
        
        System.out.println("Finished test: " + testName);
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Test Class: " + this.getClass().getSimpleName() + " completed");
    }

    @AfterSuite
    public void afterSuite() {
        ExtentReportManager.flushReports();
        System.out.println("=== Test Suite Completed ===");
    }
}
