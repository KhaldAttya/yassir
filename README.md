# Yassir Test Automation Challenge

This project contains automated tests for API and Web Automation, using Java, TestNG, RestAssured, and Selenium. The setup is integrated with GitHub Actions for CI.

To run the workflow, navigate to [GitHub Actions Workflow](https://github.com/KhaldAttya/yassir/actions/workflows/maven.yml), choose **Run Workflow**, and then select the branch.

## Bonus Task: Running Tests within Docker (Optional)

The GitHub Actions workflow already uses Docker containers under the hood.

## Part 3 (Theoretical Questions)

### 1. API Test Automation for Web and Mobile Testing

To use the same API test automation for both web and mobile testing, I would:

- **Use the Same API Client**:  
  Fetch data via the API to prepare test data or validate data shown in the UI. For example, get product info from the API and check if it’s displayed correctly on the website or mobile app.

- **Reuse Models**:  
  Use the same data models (like product details) in both API and UI tests. This ensures that data from the API can be used directly in UI testing, such as filling forms or checking values on the screen.

- **Combine API and UI Tests**:  
  Use API calls to set up test data, like creating users or orders, and then test the related UI actions (e.g., log in as the created user or check order history).

### 2. Contract Testing in E-commerce

In an e-commerce application, contract testing ensures that the front-end app (consumer) and the back-end API (provider) communicate correctly by verifying their interactions against a defined agreement. 

Instead of full integration tests, contract tests function like unit tests. The mobile app specifies what data it needs (like product details), and the API confirms it provides that data as expected, preventing compatibility issues.

**Tool: Pact**  
**Pact** is a contract testing tool that captures the app's expectations and verifies them with the API. This ensures that any updates to the API do not disrupt how the app retrieves product information or processes orders for example.
