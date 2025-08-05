# SelectorHub XPath Practice Automation Framework

A comprehensive Selenium WebDriver automation framework built with Java, Maven, TestNG, and ExtentReports for testing the SelectorHub XPath Practice Page.

## 🚀 Features

- **Page Object Model (POM)** design pattern for maintainable code
- **ThreadLocal WebDriver** management for parallel execution
- **ExtentReports** integration for detailed HTML reporting
- **TestNG** framework for test organization and execution
- **WebDriverManager** for automatic driver management
- **JSON-based test data** management with Builder pattern
- **Screenshot capture** on test failures
- **Configurable browser support** (Chrome, Firefox, Edge)
- **Headless execution** capability
- **Parallel test execution** support

## 🛠 Tech Stack

- **Java 11+**
- **Maven 3.6+**
- **Selenium WebDriver 4.15.0**
- **TestNG 7.8.0**
- **ExtentReports 5.1.1**
- **WebDriverManager 5.6.2**
- **Jackson 2.15.2** (JSON processing)

## 📁 Project Structure

```
selenium-xpath-practice-automation/
├── src/
│   ├── main/java/com/selectorhub/
│   │   ├── config/
│   │   │   └── ConfigManager.java
│   │   ├── driver/
│   │   │   └── DriverManager.java
│   │   ├── pages/
│   │   │   ├── BasePage.java
│   │   │   └── XPathPracticePage.java
│   │   └── utils/
│   │       ├── ExtentReportManager.java
│   │       └── ScreenshotUtils.java
│   └── test/
│       ├── java/com/selectorhub/
│       │   ├── data/
│       │   │   ├── TestDataProvider.java
│       │   │   └── UserData.java
│       │   └── tests/
│       │       ├── BaseTest.java
│       │       └── XPathPracticeTests.java
│       └── resources/
│           ├── config.properties
│           ├── testng.xml
│           └── testdata/
│               └── users.json
├── test-output/
│   ├── reports/
│   └── screenshots/
├── pom.xml
└── README.md
```

## 🚦 Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- Git

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/usha-reddy22/selenium-xpath-practice-automation.git
   cd selenium-xpath-practice-automation
   ```

2. **Install dependencies:**
   ```bash
   mvn clean install
   ```

### Configuration

Edit `src/test/resources/config.properties` to customize test execution:

```properties
# Browser Configuration
browser=chrome
headless=false

# Timeout Configuration (in seconds)
implicit.wait=10
explicit.wait=20

# Application URL
base.url=https://selectorshub.com/xpath-practice-page/
```

## 🏃‍♂️ Running Tests

### Run all tests:
```bash
mvn clean test
```

### Run with specific browser:
```bash
mvn clean test -Dbrowser=firefox
```

### Run in headless mode:
```bash
mvn clean test -Dheadless=true
```

### Run specific test class:
```bash
mvn clean test -Dtest=XPathPracticeTests
```

### Run with TestNG XML:
```bash
mvn clean test -DsuiteXmlFile=src/test/resources/testng.xml
```

## 📊 Test Reports

After test execution, reports are generated in:
- **ExtentReports:** `test-output/reports/ExtentReport_[timestamp].html`
- **Screenshots:** `test-output/screenshots/`
- **TestNG Reports:** `target/surefire-reports/`

## 🧪 Test Scenarios

The framework includes comprehensive test scenarios:

1. **Page Elements Visibility Test** - Verifies all form elements are displayed
2. **Complete Form Filling Test** - Tests end-to-end form submission with data-driven approach
3. **Individual Field Interactions** - Tests each form field separately
4. **Checkbox and Radio Button Selections** - Validates selection functionality
5. **Dropdown Selection Test** - Tests dropdown interactions
6. **Button Click Functionality** - Verifies button click operations
7. **Link Click Functionality** - Tests link navigation
8. **Page Title and URL Verification** - Validates page properties

## 🔧 Framework Components

### ConfigManager
- Centralized configuration management
- Property file loading and parsing
- Environment-specific settings

### DriverManager
- ThreadLocal WebDriver management
- Multi-browser support (Chrome, Firefox, Edge)
- Automatic driver setup with WebDriverManager

### BasePage
- Common WebDriver operations
- Explicit wait implementations
- Element interaction methods

### XPathPracticePage
- Page Object Model implementation
- Element mappings using @FindBy annotations
- Business logic methods

### ExtentReportManager
- HTML report generation
- Screenshot integration
- Test step logging

### TestDataProvider
- JSON-based test data management
- Builder pattern implementation
- Data-driven testing support

## 🔄 Parallel Execution

The framework supports parallel test execution. Configure in `testng.xml`:

```xml
<suite name="Test Suite" parallel="methods" thread-count="3">
```

## 🐛 Debugging

- **Screenshots:** Automatically captured on test failures
- **Logs:** Detailed logging in ExtentReports
- **Console Output:** Real-time test execution status

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 Best Practices Implemented

- **Page Object Model** for maintainable code structure
- **ThreadLocal** for thread-safe parallel execution
- **Explicit waits** for reliable element interactions
- **Soft assertions** for comprehensive test validation
- **Builder pattern** for flexible test data creation
- **Configuration management** for environment flexibility
- **Comprehensive reporting** for test analysis

## 🔗 Useful Links

- [SelectorHub XPath Practice Page](https://selectorshub.com/xpath-practice-page/)
- [Selenium Documentation](https://selenium-python.readthedocs.io/)
- [TestNG Documentation](https://testng.org/doc/)
- [ExtentReports Documentation](https://www.extentreports.com/)

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Bharath Kumar Reddy B**
- Email: bharathkumar.reddy@example.com
- GitHub: [@usha-reddy22](https://github.com/usha-reddy22)

---

⭐ **Star this repository if you find it helpful!**
