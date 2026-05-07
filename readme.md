# QA Automation Suite — ParaBank

End-to-end test automation suite for [ParaBank](https://parabank.parasoft.com) — a demo banking application used as a test target. Built with Java 17, Selenium WebDriver 4, Cucumber BDD, and Maven.

---

## Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Language |
| Selenium WebDriver 4 | Browser automation |
| Cucumber (BDD) | Test scenarios in Gherkin syntax |
| JUnit 5 | Test runner |
| Maven | Build & dependency management |
| ExtentReports | HTML test reports with screenshots |
| Page Object Model | Design pattern for maintainability |

---

## Test Coverage

Scenarios are organized by feature area using Cucumber tags:

| Tag | Feature Area |
|---|---|
| `@registration` | New user registration flow |
| `@login` | Login, logout, invalid credentials |
| `@accounts` | Open account, account overview, account details |
| `@transfer` | Fund transfers between accounts |
| `@loans` | Loan request, approval, account creation |

---

## Project Structure

```
QA_project/
├── src/
│   ├── main/java/org/example/
│   │   └── App.java
│   └── test/
│       ├── java/
│       │   ├── hooks/
│       │   │   └── GlobalHooks.java        # Before/After (driver init, screenshots)
│       │   ├── pageObjects/                # Page Object Model classes
│       │   │   ├── BasePage.java
│       │   │   ├── HomePage.java
│       │   │   ├── AccountPage.java
│       │   │   └── RegistrationPage.java
│       │   ├── runner/
│       │   │   └── TestRunner.java         # CucumberOptions, tags, reports
│       │   ├── stepDefinitions/
│       │   │   ├── AccountStepDefinitions.java
│       │   │   ├── LoginStepDefinitions.java
│       │   │   └── RegStepDefinitions.java
│       │   └── utilities/
│       │       └── userCounter.java        # Test data utilities
│       └── resources/
│           ├── features/                   # Gherkin .feature files
│           └── extent.properties           # ExtentReports config
├── reports/                                # ExtentReports HTML output
├── pom.xml
├── run_tests_menu.bat                      # Windows menu for running tag subsets
└── README.md
```

---

## Design Patterns

**Page Object Model** — each page of the application has a dedicated class encapsulating its locators and interactions. Tests interact with pages through these classes, not directly with WebDriver. This keeps tests readable and isolates UI changes to a single file.

**BDD with Gherkin** — scenarios are written in plain English using Given/When/Then syntax, making them readable by non-technical stakeholders. Step definitions map Gherkin steps to Selenium actions.

**Hooks** — `@Before` initializes ChromeDriver and navigates to base URL; `@After` captures a screenshot on failure and quits the driver.

---

## Sample Scenario

```gherkin
Feature: User Login

  @login
  Scenario: Successful login with valid credentials
    Given the user is on the ParaBank login page
    When the user enters valid username and password
    And clicks the login button
    Then the user should be redirected to the account overview page

  @login
  Scenario: Login fails with invalid credentials
    Given the user is on the ParaBank login page
    When the user enters an invalid username and password
    And clicks the login button
    Then an error message should be displayed
```

---

## Running the Tests

**Prerequisites:** Java 17, Maven, Google Chrome

```bash
# Clone the repo
git clone https://github.com/sorinHus/QA_project.git
cd QA_project

# Run all tests
mvn test

# Run a specific tag
mvn test -Dcucumber.filter.tags="@login"

# Run multiple tags
mvn test -Dcucumber.filter.tags="@login or @registration"
```

Reports are generated in the `reports/` folder after each run.

**Windows shortcut:** double-click `run_tests_menu.bat` for an interactive menu to select which tag to run — no need to type Maven commands manually.

---

## Context

Built as a portfolio project to demonstrate QA automation skills alongside backend and full-stack development experience. ParaBank is a publicly available demo banking app maintained by Parasoft, commonly used as a test target in automation courses and certifications.

---

## Related Projects

- **[MED487](https://github.com/sorinHus/med487)** — Full-stack medical practice app (Django 6 + React)
- **[MRU_Tracker](https://github.com/sorinHus/MRU_Tracker)** — Multi-user HR file tracking tool · [Live demo](https://sorinhus.github.io/MRU_Tracker/hr_file_manager_DEMO.html)

---

## License

MIT — free to use and adapt.
