# 🧪 ParaBank Automation Testing Project

Automated testing project for the ParaBank application using Selenium WebDriver, Cucumber BDD, and Java.

## 📋 Description

This project contains end-to-end automated tests for the [ParaBank](https://parabank.parasoft.com/parabank/index.htm) application, covering the following functionalities:
- 📝 User Registration
- 🔐 Authentication (Login/Logout)
- 💳 Bank Account Operations
- 💰 Loan Applications

## 🛠️ Technologies Used

- **Java 17** - Programming Language
- **Selenium WebDriver 4.28.1** - Browser Automation
- **Cucumber 7.20.1** - BDD Framework (Behavior Driven Development)
- **JUnit 4.13.2** - Testing Framework
- **Maven** - Build Tool and Dependency Management
- **ExtentReports** - Interactive HTML Reports
- **Page Object Model (POM)** - Design Pattern

## 📁 Project Structure

```
ProiectFinal/
├── src/test/java/
│   ├── hooks/                 # Setup and TearDown for tests
│   ├── pageObjects/           # Page Object Model classes
│   ├── stepDefinitions/       # Cucumber step definitions
│   ├── runner/                # Test runner
│   └── utilities/             # Utility classes
├── src/test/resources/
│   └── features/              # Cucumber feature files
├── run_tests_menu.bat         # Script to run tests (Windows)
└── pom.xml                    # Maven configuration
```

## 🚀 How to Run Tests

### Prerequisites
- Java JDK 17 or higher
- Maven 3.6+ installed
- ChromeDriver (automatically downloaded via Selenium Manager)

### Option 1: Using .bat Script (Recommended for Windows)

1. Double-click on `run_tests_menu.bat`
2. Choose the test type from menu (1-7)
3. Reports will open automatically

### Option 2: Via Command Line (Maven)

```bash
# Run all tests
mvn clean test

# Run specific tests (by tag)
mvn test -Dcucumber.filter.tags="@RegPoz"
mvn test -Dcucumber.filter.tags="@logPoz"
mvn test -Dcucumber.filter.tags="@newAcc"
```

### Option 3: From IntelliJ IDEA

1. Open the project in IntelliJ
2. Navigate to `src/test/java/runner/TestRunner.java`
3. Right-click on the `TestRunner` class → **Run 'TestRunner'**

## 🏷️ Cucumber Tags

| Tag | Description |
|-----|-----------|
| `@RegPoz` | Positive registration tests |
| `@RegNeg` | Negative registration tests |
| `@logPoz` | Positive login tests |
| `@logNeg` | Negative login tests |
| `@newAcc` | New account creation tests |
| `@newLoan` | Loan application tests |
| `@logOut` | Logout tests |

## 📊 Reports

After running tests, reports are generated in:

- **ExtentReport**: `Report/CucumberExtentReport.html`
- **Cucumber HTML**: `reports/myreport.html`
- **Spark Report**: `test-output/SparkReport/`

## ✨ Features

### Test Scenarios Covered

#### ✅ Registration Flow
- Successful registration
- Missing required field validation
- Password mismatch validation

#### ✅ Login Flow
- Login with valid credentials
- Login with missing username
- Login with missing password
- Login with invalid password
- Login with invalid username

#### ✅ Account Operations
- Open new account
- Apply for loan
- Logout

## 🎯 Design Patterns Used

- **Page Object Model (POM)** - Separation of page logic from tests
- **Singleton Pattern** - WebDriver instance management
- **Factory Pattern** - For page object initialization
- **Data-Driven Testing** - Using Cucumber Data Tables

## 📝 Configuration

### pom.xml
All Maven dependencies are configured in `pom.xml`

### extent.properties
ExtentReports configuration can be found in `src/test/resources/extent.properties`

## 🐛 Troubleshooting

### Issue: Tests can't find .feature files
**Solution**: Make sure to run tests through `TestRunner.java`, not directly from `.feature` files

### Issue: ChromeDriver doesn't start
**Solution**: Selenium 4.x automatically downloads the appropriate ChromeDriver. Make sure you have Chrome installed.

### Issue: userCounter.txt generates errors
**Solution**: The file is created automatically on first run. It shouldn't exist in the repository.

## 👤 Author

Sorin Hus

## 📄 License

This project is for educational purposes.

---

**Notes**: 
- Tests run on the ParaBank demo application
- Make sure you have an active internet connection
- Reports are generated automatically after each run