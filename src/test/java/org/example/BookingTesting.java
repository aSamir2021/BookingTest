package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BookingTesting {
    private WebDriver driver;
    private WebDriverWait wait;
    private BookingPage bookingPage; // Make sure this is properly declared

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Navigate to the website
        driver.get("https://demo1.leotheme.com/ap_booking_demo/en/");

        // Initialize BookingPage AFTER driver is created and navigated
        bookingPage = new BookingPage(driver);

        // Add a small wait to ensure page is loaded
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    @Test
    public void testValidInputs() throws InterruptedException {

        //==== Variables====
        String fromDate = "2025-10-25";
        String toDate = "2025-10-29";
        String noOfAdults = "10";
        String noOfChildren = "3";
        int noOfChildrenINT = Integer.parseInt(noOfChildren);


        // Check if bookingPage is properly initialized
        Assert.assertNotNull("BookingPage should not be null", bookingPage);

        // Use the Page Object Model to fill the form
//        Thread.sleep(10000);
        bookingPage.setDateFrom(fromDate);
//        Thread.sleep(10000);

        bookingPage.setDateTo(toDate);
//        Thread.sleep(10000);

        bookingPage.setAdults(noOfAdults);
//        Thread.sleep(10000);

        bookingPage.setChildren(noOfChildrenINT);
        Thread.sleep(10000);

        bookingPage.AssertSamir(noOfChildren);

//        bookingPage.clickSearch();


    }

//   @After
//    public void tearDown() {
//           driver.quit();
//    }
}