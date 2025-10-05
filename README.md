BookingTest - Selenium WebDriver Automation Project
This project demonstrates functional test automation for a booking form, built using the Page Object Model (POM) pattern in Java. The primary focus is on reliable interaction with complex, non-standard web elements.

🎯 Target Application
URL: https://demo1.leotheme.com/ap_booking_demo/en/

🌟 Key Features Demonstrated
This project showcases expertise in building robust, maintainable automation scripts by solving common real-world challenges:

Page Object Model (POM): Clean separation of element locators and test logic across BookingPage.java and BookingTesting.java.

Handling Custom Dropdowns: The setAdults and setChildren methods implement a two-step click sequence with Explicit Waits to reliably select options from the non-standard, JavaScript-driven dropdown menus.

Cross-Platform Setup: Uses WebDriverManager to automatically manage and configure the browser driver (ChromeDriver), eliminating manual setup issues.

Error Handling & Reporting: Includes custom logic to take screenshots on failure and robust try-catch blocks to log exceptions clearly.

Data-Driven Interaction: Uses sendKeys(Keys.TAB) to simulate user interactions and close date pickers after date input.

⚙️ Tech Stack
Technology

Purpose

Language

Java 17+

Automation Framework

Selenium WebDriver

Test Framework

JUnit 4

Driver Management

WebDriverManager (io.github.bonigarcia)

Utilities

Apache Commons IO (FileUtils for screenshots)

Design Pattern

Page Object Model (POM)

🚀 Setup and Execution
Prerequisites
Java Development Kit (JDK) 17 or newer.

Maven (for dependency management).

IntelliJ IDEA (Recommended IDE).

1. Cloning the Repository
Use your preferred Git client or the command line to clone the project:

git clone [https://github.com/aSamir2021/BookingTest.git](https://github.com/aSamir2021/BookingTest.git)


2. Running the Test Case
The project is configured to run directly as a JUnit test from your IDE.

Open the project in IntelliJ IDEA. Maven will automatically resolve all dependencies defined in pom.xml.

Navigate to the test file: src/test/java/org/example/BookingTesting.java.

Right-click on the testValidInputs() method within the class and select Run 'testValidInputs' from the context menu.

The test will perform the full booking flow using the data defined within the test method (e.g., noOfAdults = "10", noOfChildren = "3").

📂 Project Structure (Page Object Model)
Class

Location

Responsibility

BookingTesting.java

src/test/java/org/example/

Contains the JUnit test setup, teardown (@Before, @Test), test data, and the sequence of interactions with the page methods.

BookingPage.java

src/main/java/org/example/

Represents the web page. Contains all element Locators and reusable Methods for interacting with the booking form elements.

