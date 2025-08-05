package com.selectorhub.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object Model for SelectorHub XPath Practice Page
 */
public class XPathPracticePage extends BasePage {

    // Form Elements
    @FindBy(id = "userId")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(name = "company")
    private WebElement companyField;

    @FindBy(id = "mobile")
    private WebElement mobileNumberField;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField2;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElement submitButton;

    // Checkboxes and Radio buttons
    @FindBy(xpath = "//input[@value='td']")
    private WebElement testingDomainCheckbox;

    @FindBy(xpath = "//input[@value='sd']")
    private WebElement softwareDevelopmentCheckbox;

    @FindBy(xpath = "//input[@value='other']")
    private WebElement otherDomainCheckbox;

    @FindBy(xpath = "//input[@value='java']")
    private WebElement javaSkillCheckbox;

    @FindBy(xpath = "//input[@value='python']")
    private WebElement pythonSkillCheckbox;

    @FindBy(xpath = "//input[@value='javascript']")
    private WebElement javascriptSkillCheckbox;

    // Dropdown
    @FindBy(id = "cars")
    private WebElement carsDropdown;

    // Buttons
    @FindBy(xpath = "//button[normalize-space()='Click']")
    private WebElement clickButton;

    @FindBy(xpath = "//button[contains(text(),'Click me to check Java Script Alert')]")
    private WebElement alertButton;

    // Links
    @FindBy(linkText = "Confirm pop up is open")
    private WebElement confirmPopupLink;

    @FindBy(partialLinkText = "Partial Link Test")
    private WebElement partialLinkTest;

    // Text elements
    @FindBy(xpath = "//div[@id='userName']")
    private WebElement userNameDisplay;

    @FindBy(xpath = "//p[contains(text(),'Joe.Root')]")
    private WebElement joeRootText;

    // Methods for interacting with elements
    public void enterEmail(String email) {
        sendKeys(emailField, email);
    }

    public void enterPassword(String password) {
        sendKeys(passwordField, password);
    }

    public void enterCompany(String company) {
        sendKeys(companyField, company);
    }

    public void enterMobileNumber(String mobile) {
        sendKeys(mobileNumberField, mobile);
    }

    public void enterSecondEmail(String email) {
        sendKeys(emailField2, email);
    }

    public void clickSubmitButton() {
        click(submitButton);
    }

    public void selectTestingDomain() {
        click(testingDomainCheckbox);
    }

    public void selectSoftwareDevelopment() {
        click(softwareDevelopmentCheckbox);
    }

    public void selectOtherDomain() {
        click(otherDomainCheckbox);
    }

    public void selectJavaSkill() {
        click(javaSkillCheckbox);
    }

    public void selectPythonSkill() {
        click(pythonSkillCheckbox);
    }

    public void selectJavaScriptSkill() {
        click(javascriptSkillCheckbox);
    }

    public void selectCarFromDropdown(String carName) {
        selectByVisibleText(carsDropdown, carName);
    }

    public void clickMainButton() {
        click(clickButton);
    }

    public void clickAlertButton() {
        click(alertButton);
    }

    public void clickConfirmPopupLink() {
        click(confirmPopupLink);
    }

    public void clickPartialLinkTest() {
        click(partialLinkTest);
    }

    public String getUserNameDisplayText() {
        return getText(userNameDisplay);
    }

    public String getJoeRootText() {
        return getText(joeRootText);
    }

    public boolean isEmailFieldDisplayed() {
        return isElementDisplayed(emailField);
    }

    public boolean isPasswordFieldDisplayed() {
        return isElementDisplayed(passwordField);
    }

    public boolean isSubmitButtonDisplayed() {
        return isElementDisplayed(submitButton);
    }

    public void fillCompleteForm(String email, String password, String company, String mobile, String email2) {
        enterEmail(email);
        enterPassword(password);
        enterCompany(company);
        enterMobileNumber(mobile);
        enterSecondEmail(email2);
    }

    public void selectAllDomains() {
        selectTestingDomain();
        selectSoftwareDevelopment();
        selectOtherDomain();
    }

    public void selectAllSkills() {
        selectJavaSkill();
        selectPythonSkill();
        selectJavaScriptSkill();
    }
}
