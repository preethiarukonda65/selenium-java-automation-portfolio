🧪 Selenium Java Automation Framework – SauceDemo

📌 Project Overview
This project is a Selenium WebDriver automation framework built using Java, TestNG, and Maven to automate end- to- end test scenarios for the SauceDemo e- commerce application.
The framework follows the Page Object Model (POM) design pattern to ensure scalability, maintainability, and clean test architecture.

🚀 Tech Stack
* Java 11
* Selenium WebDriver 4
* TestNG
* Maven
* WebDriverManager
* Page Object Model (POM)
* GitHub
* AI

🌐 Application Under Test
🔗 https://www.saucedemo.com/
SauceDemo is a sample e- commerce web application used to automate:
* Login functionality
* Product listing validation
* Add to cart
* Remove from cart
* Complete checkout flow

🧱 Framework Architecture
* src/test/java
* ├── base
* │    └── BaseTest.java
* ├── pages
* │    ├── LoginPage.java
* │    ├── ProductsPage.java
* │    ├── CartPage.java
* │    ├── CheckoutInformationPage.java
* │    ├── CheckoutOverviewPage.java
* │    └── CheckoutCompletePage.java
* ├── tests
* │    ├── LoginTests.java
* │    ├── CartTests.java
* │    └── CheckoutTests.java

🧠 Design Principles
Page Object Model for separation of concerns
* Reusable WebDriver initialization using BaseTest
* Clean test methods mapped to manual test cases
* Assertions at each critical validation point
* Maintainable and scalable structure

🧪 Automated Test Scenarios
🔐 Login Tests
* Valid login
* Invalid password
Blank login validation
* Locked user validation

🛒 Cart Tests
* Add single product to cart
* Add multiple products
* Remove product from cart
* Cart count validation

💳 Checkout Tests
* Navigate to cart page
* Enter checkout details
* Complete order
* Verify order confirmation message

🔄 Manual to Automation Mapping
* Manual Test Case  -> Automated Method
* TC_LOGIN_01	      -> testValidLogin()
* TC_CART_01        ->	testAddSingleProductToCart()
* TC_CHECKOUT_04	   -> testCompleteCheckoutFlow()

▶️ How to Run the Project
* Clone the repository
* Open in IntelliJ / Eclipse
* Run testng.xml or individual test classes
* Maven command: mvn clean test
