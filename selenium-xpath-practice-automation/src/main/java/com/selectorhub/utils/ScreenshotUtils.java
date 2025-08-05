package com.selectorhub.utils;

import com.selectorhub.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for taking screenshots
 */
public class ScreenshotUtils {
    private static final String SCREENSHOT_DIR = "test-output/screenshots/";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

    static {
        // Create screenshots directory if it doesn't exist
        File screenshotDir = new File(SCREENSHOT_DIR);
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }
    }

    public static String takeScreenshot(String testName) {
        WebDriver driver = DriverManager.getDriver();
        if (driver == null) {
            return null;
        }

        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            
            String timestamp = LocalDateTime.now().format(DATE_FORMAT);
            String fileName = testName + "_" + timestamp + ".png";
            File destFile = new File(SCREENSHOT_DIR + fileName);
            
            FileUtils.copyFile(sourceFile, destFile);
            
            return destFile.getAbsolutePath();
        } catch (IOException e) {
            System.err.println("Failed to take screenshot: " + e.getMessage());
            return null;
        }
    }

    public static String takeScreenshot() {
        return takeScreenshot("screenshot");
    }

    public static void takeScreenshotOnFailure(String testName) {
        String screenshotPath = takeScreenshot(testName + "_FAILED");
        if (screenshotPath != null) {
            System.out.println("Screenshot saved: " + screenshotPath);
        }
    }
}
