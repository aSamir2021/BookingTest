package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class BookingPage {
    private WebDriver driver;
    private WebDriverWait wait;


    public BookingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // =========== Locators ================
    private By dateFromField = By.name("from");
    private By dateToField = By.name("to");
    public By adultsField = By.xpath("//*[@id=\"adult\"]");
    private By childrenField = By.xpath("//input[@id='child' or @name='child']");
    private By searchButton = By.name("search_product");

    // Method 1: Set the FROM date
    public void setDateFrom(String date) {
        try {
            WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(dateFromField));
            dateElement.clear();
            dateElement.sendKeys(date);
            System.out.println("Date From set to: " + date);
        } catch (Exception e) {
            System.out.println("Failed to set Date From: " + e.getMessage());
            takeScreenshot("setDateFrom_failure");
        }
    }

    // Method 2: Set the TO date
    public void setDateTo(String date) {
        try {
            WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(dateToField));
            dateElement.clear();
            dateElement.sendKeys(date);
            System.out.println("Date To set to: " + date);
        } catch (Exception e) {
            System.out.println("Failed to set Date To: " + e.getMessage());
            takeScreenshot("setDateTo_failure");
        }
    }

    // Method 3: Set number of adults
    public void setAdults(String numberOfAdults) {
        try {
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).build().perform();
            WebElement adultsElement = wait.until(ExpectedConditions.elementToBeClickable(adultsField));
            adultsElement.click();
            String optionXPath = "//ul[contains(@class, 'number-people')]/li[text()='" + numberOfAdults + "']";
            WebElement optionElement = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(optionXPath))
            );
            optionElement.click();
            System.out.println("Adults set to: " + numberOfAdults);
        } catch (Exception e) {
            System.out.println("Failed to set Adults: " + e.getMessage());
            takeScreenshot("setAdults_failure");
        }
        //WebElement dropdownElement = driver.findElement(By.xpath("//*[@id=\"adult\"]"));
        // Select selectObject = new Select(dropdownElement);
        // selectObject.selectByVisibleText(numberOfAdults);
        // adultsElement.sendKeys(numberOfAdults);
    }

    // Method 4: Set number of children
    public void setChildren(int numberOfChildren) {
        try {

            WebElement childrenElement = wait.until(ExpectedConditions.elementToBeClickable(childrenField));
            childrenElement.click();
            String optionXPath = "//li[@class='number-people child' and @data-num='" + numberOfChildren + "']";
            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXPath)));
            option.click();
            System.out.println("Dropdown list container is visible.");

            WebElement optionElement = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(optionXPath))
            );
            //*[@id="ap_booking_wrapper"]/div[5]/ul
            //*[@id="ap_booking_wrapper"]/div[5]/ul/li[3]
            optionElement.click();
            System.out.println("Children set to: " + numberOfChildren);
        } catch (Exception e) {
            System.out.println("Failed to set Children: " + e.getMessage());
            takeScreenshot("setChildren_failure");
        }
    }

    // Method 5: Click search button
    public void clickSearch() {
        try {
            WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            searchBtn.click();
            System.out.println("Search button clicked successfully");
            // Wait a bit for results to load
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Failed to click Search: " + e.getMessage());
            takeScreenshot("clickSearch_failure");
        }
    }

    // Method 6: Take screenshot on failure
    private void takeScreenshot(String screenshotName) {
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("screenshots/" + screenshotName + "_" + System.currentTimeMillis() + ".png");

            // Create screenshots directory if it doesn't exist
            destFile.getParentFile().mkdirs();

            FileUtils.copyFile(sourceFile, destFile);
            System.out.println(" Screenshot saved: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println(" Failed to take screenshot: " + e.getMessage());
        }
    }

    public void AssertSamir (String ChildValue_){
        WebElement childrenElement = wait.until(ExpectedConditions.elementToBeClickable(childrenField));
        String actualValue = childrenElement.getAttribute("value");
        Assert.isTrue(actualValue.equals(ChildValue_), "Children count should be 4");
        System.out.println("Assertion passed: Children count is " + actualValue);

    }

}