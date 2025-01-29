package com.sqat.pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookingTest {
    WebDriver driver;
    FlightFindPage flightFindPage;
    FlightChoosePage flightChoosePage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.blazedemo.com/");
        flightFindPage = new FlightFindPage(driver);
        flightChoosePage = new FlightChoosePage(driver);
    }

    @Test
    public void testFlightBooking() throws InterruptedException {
        flightFindPage.selectFromPort("Philadelphia");
        flightFindPage.selectToPort("Rome");
        flightFindPage.clickFindFlights();

        Thread.sleep(2000);
        System.out.println("Page title after search: " + driver.getTitle());

        flightChoosePage.chooseFlight();
        Thread.sleep(1000);
        System.out.println("Flight booking title checkpoint: " + flightChoosePage.getPageTitle());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
