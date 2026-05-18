# AI Agent Guidelines for QA Automation Web JIP

## Architecture Overview
This is a Selenium WebDriver-based test automation project for the JIP CMS web application (https://cms-jip.folkatech.com). It uses Cucumber BDD with TestNG for test execution and Page Object Model for UI interactions.

Key components:
- `BaseTest.java`: Manages static WebDriver instance (Chrome) and WebDriverWait (15s timeout)
- `page/`: Page Object classes (e.g., `LoginPage.java`) with locators and action methods
- `StepDefinitions/`: Cucumber step implementations that orchestrate page interactions
- `CucumberHooks.java`: Setup/teardown - initializes driver before all scenarios, captures screenshots on failure, pauses 10s after each scenario, quits driver

## Test Execution
Run tests with: `mvn test`
- Executes via `TestRunner.java` (CucumberOptions: features in `src/test/resources/features/`, glue in `AutomationWEBSITE_JIP`)
- Generates HTML report at `target/report-cucumber.html` and JSON at `target/cucumber-json.json`
- Tests run sequentially (static driver prevents parallelism)

## Coding Patterns
- **Page Objects**: Extend `BaseTest`, take `WebDriver` in constructor, use `BaseTest.wait` for explicit waits
- **Locators**: Prefer `By.id()` for simple elements, `By.xpath()` for complex (e.g., `//button[.//span[normalize-space()='Sign In']]`)
- **Assertions**: Use TestNG `Assert.assertTrue()` with descriptive messages
- **Error Handling**: Catch `NoSuchElementException` in helper methods like `isElementDisplayed()`
- **State Tracking**: In step definitions, track input values (e.g., `currentUsername`) to determine validation logic
- **Validation Logic**: Differentiate inline alerts (empty fields) vs. notification alerts (wrong credentials) using specific locators

## Adding New Features
1. Create feature file in `src/test/resources/features/` with `@tag` and Scenario/Scenario Outline
2. Add page object in `page/` with locators (By.id/By.xpath) and methods using `wait.until(ExpectedConditions...)`
3. Implement steps in `StepDefinitions/` extending `BaseTest`, initialize page in `@Before` hook
4. Update `TestRunner.java` if needed (rarely, as glue covers package)

## Dependencies & Environment
- Java 17, Maven build
- Selenium 4.34.0, TestNG 7.8.0, Cucumber 7.15.0
- ChromeDriver (managed by Selenium Manager)
- No external config files; URL hardcoded in `CucumberHooks.beforeAll()`

## Debugging Tips
- Screenshots auto-captured on scenario failure and attached to Cucumber report
- Use `Thread.sleep(10000)` for manual pauses (common in hooks and steps)
- Check `target/surefire-reports/` for TestNG XML reports
- Browser remains open 10s after each scenario for visual inspection</content>
<parameter name="filePath">/Users/herlan/Documents/AUTOMATION /JIP/qa_automation_web/AGENTS.md
