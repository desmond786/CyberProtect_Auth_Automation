# CyberProtect_Auth_Automation

**Authentication Automation Suite**
This project is a Selenium-based automation framework designed to validate the core authentication flows for the CyberProtect platform. It covers Secure Login, Input Validation, and Forgot Password workflows.

🛠 **Tech Stack**
Language: Java 11+
Framework: TestNG (Test management)
Build Tool: Maven
Browser Engine: Selenium WebDriver
Design Pattern: Page Object Model (POM)
📋 **Prerequisites**
Before running the tests, ensure you have the following installed:

Java Development Kit (JDK): Version 11 or higher.
Apache Maven: For dependency management and test execution.
Google Chrome: Latest stable version.
WebDriver: The framework uses automatic driver management, but ensure Chrome is installed in the default path.

⚙️ **Configuration & Test Data**
All environment-specific data is managed in src/test/resources/config.properties.

Environment URL: Update base.url to switch between staging and production.
User Credentials: Update valid.email and valid.password for the login flow.
Reset Link: The resetPassword.link must be updated if testing the password reset completion flow manually, as tokens typically expire.

🚀 **Execution Instructions**
Running Locally
Open your terminal in the project root folder (auth-automation)and use the following commands:

**Run All Tests (Suite):**
Bash
mvn clean test

**Run Login Flow Only:**
Bash
mvn clean test -Dtest=LoginTest

**Run Forgot Password Flow Only:**
Bash
mvn clean test -Dtest=ForgotPasswordTest

**Running in CI/CD (Headless)**
To run tests on a server (like Jenkins or GitHub Actions) without a GUI:
(But we have to setup jenkins first)
Bash
mvn clean test -Dheadless=true

🧪 **Test Coverage**
**1. Login Flow**
**Valid Login**: Verifies successful access with correct credentials.
**Invalid Login:** Ensures the system denies access with wrong credentials.
**Empty Field Validation:** Checks for "Required Field" errors.
**Email Format Check:** Validates that the system rejects improperly formatted emails.
**2. Forgot Password Flow**
**Request Reset**: Tests the submission of the reset request.
**Password Update:** (If link is active) Sets a new password.

📊 **Reports & Troubleshooting**
Viewing Results
After the tests complete, a detailed HTML report is generated:
Path: target/surefire-reports/index.html
Action: Open this file in any web browser to see pass/fail status and stack traces.

**Note**: Our frameworks follow POM structure so these are two POM files : **ForgotPasswordPage** and **LoginPage** where locators and action methods are defined. **ForgotPasswordTest** and **LoginTest** are the files where test methods are written.
