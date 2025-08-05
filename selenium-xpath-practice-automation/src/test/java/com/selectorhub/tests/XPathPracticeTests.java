package com.selectorhub.tests;

import com.selectorhub.data.TestDataProvider;
import com.selectorhub.data.UserData;
import com.selectorhub.pages.XPathPracticePage;
import com.selectorhub.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Test class for XPath Practice Page automation
 */
public class XPathPracticeTests extends BaseTest {

    @Test(priority = 1, description = "Verify page elements are displayed")
    public void testPageElementsVisibility() {
        ExtentReportManager.logInfo("Testing page elements visibility");
        
        XPathPracticePage xpathPage = new XPathPracticePage();
        SoftAssert softAssert = new SoftAssert();
        
        softAssert.assertTrue(xpathPage.isEmailFieldDisplayed(), "Email field should be displayed");
        ExtentReportManager.logInfo("Email field visibility verified");
        
        softAssert.assertTrue(xpathPage.isPasswordFieldDisplayed(), "Password field should be displayed");
        ExtentReportManager.logInfo("Password field visibility verified");
        
        softAssert.assertTrue(xpathPage.isSubmitButtonDisplayed(), "Submit button should be displayed");
        ExtentReportManager.logInfo("Submit button visibility verified");
        
        softAssert.assertAll();
        ExtentReportManager.logPass("All page elements are visible");
    }

    @Test(priority = 2, dataProvider = "userData", dataProviderClass = TestDataProvider.class,
          description = "Fill and submit the complete form")
    public void testCompleteFormFilling(UserData userData) {
        ExtentReportManager.logInfo("Testing complete form filling with user data: " + userData.getEmail());
        
        XPathPracticePage xpathPage = new XPathPracticePage();
        
        // Fill form fields
        xpathPage.fillCompleteForm(
            userData.getEmail(),
            userData.getPassword(),
            userData.getCompany(),
            userData.getMobile(),
            userData.getEmail2()
        );
        ExtentReportManager.logInfo("Form fields filled successfully");
        
        // Select domains
        xpathPage.selectAllDomains();
        ExtentReportManager.logInfo("All domains selected");
        
        // Select skills
        xpathPage.selectAllSkills();
        ExtentReportManager.logInfo("All skills selected");
        
        // Select car preference
        xpathPage.selectCarFromDropdown(userData.getCarPreference());
        ExtentReportManager.logInfo("Car preference selected: " + userData.getCarPreference());
        
        ExtentReportManager.logPass("Complete form filling test completed successfully");
    }

    @Test(priority = 3, description = "Test individual form field interactions")
    public void testIndividualFieldInteractions() {
        ExtentReportManager.logInfo("Testing individual field interactions");
        
        XPathPracticePage xpathPage = new XPathPracticePage();
        
        // Test email field
        xpathPage.enterEmail("test@example.com");
        ExtentReportManager.logInfo("Email field interaction tested");
        
        // Test password field
        xpathPage.enterPassword("testPassword123");
        ExtentReportManager.logInfo("Password field interaction tested");
        
        // Test company field
        xpathPage.enterCompany("Test Company");
        ExtentReportManager.logInfo("Company field interaction tested");
        
        // Test mobile field
        xpathPage.enterMobileNumber("1234567890");
        ExtentReportManager.logInfo("Mobile field interaction tested");
        
        ExtentReportManager.logPass("Individual field interactions completed successfully");
    }

    @Test(priority = 4, description = "Test checkbox and radio button selections")
    public void testCheckboxAndRadioButtonSelections() {
        ExtentReportManager.logInfo("Testing checkbox and radio button selections");
        
        XPathPracticePage xpathPage = new XPathPracticePage();
        
        // Test domain checkboxes
        xpathPage.selectTestingDomain();
        ExtentReportManager.logInfo("Testing domain checkbox selected");
        
        xpathPage.selectSoftwareDevelopment();
        ExtentReportManager.logInfo("Software development checkbox selected");
        
        // Test skill checkboxes
        xpathPage.selectJavaSkill();
        ExtentReportManager.logInfo("Java skill checkbox selected");
        
        xpathPage.selectPythonSkill();
        ExtentReportManager.logInfo("Python skill checkbox selected");
        
        ExtentReportManager.logPass("Checkbox and radio button selections completed successfully");
    }

    @Test(priority = 5, description = "Test dropdown selection functionality")
    public void testDropdownSelection() {
        ExtentReportManager.logInfo("Testing dropdown selection functionality");
        
        XPathPracticePage xpathPage = new XPathPracticePage();
        
        // Test different car selections
        String[] cars = {"Audi", "BMW", "Mercedes"};
        
        for (String car : cars) {
            xpathPage.selectCarFromDropdown(car);
            ExtentReportManager.logInfo("Selected car: " + car);
        }
        
        ExtentReportManager.logPass("Dropdown selection test completed successfully");
    }

    @Test(priority = 6, description = "Test button click functionality")
    public void testButtonClicks() {
        ExtentReportManager.logInfo("Testing button click functionality");
        
        XPathPracticePage xpathPage = new XPathPracticePage();
        
        // Test main click button
        xpathPage.clickMainButton();
        ExtentReportManager.logInfo("Main button clicked successfully");
        
        ExtentReportManager.logPass("Button click test completed successfully");
    }

    @Test(priority = 7, description = "Test link click functionality")
    public void testLinkClicks() {
        ExtentReportManager.logInfo("Testing link click functionality");
        
        XPathPracticePage xpathPage = new XPathPracticePage();
        
        // Test partial link
        xpathPage.clickPartialLinkTest();
        ExtentReportManager.logInfo("Partial link clicked successfully");
        
        ExtentReportManager.logPass("Link click test completed successfully");
    }

    @Test(priority = 8, description = "Verify page title and URL")
    public void testPageTitleAndUrl() {
        ExtentReportManager.logInfo("Testing page title and URL verification");
        
        XPathPracticePage xpathPage = new XPathPracticePage();
        
        String pageTitle = xpathPage.getPageTitle();
        String currentUrl = xpathPage.getCurrentUrl();
        
        Assert.assertNotNull(pageTitle, "Page title should not be null");
        Assert.assertNotNull(currentUrl, "Current URL should not be null");
        
        ExtentReportManager.logInfo("Page title: " + pageTitle);
        ExtentReportManager.logInfo("Current URL: " + currentUrl);
        
        ExtentReportManager.logPass("Page title and URL verification completed successfully");
    }
}
