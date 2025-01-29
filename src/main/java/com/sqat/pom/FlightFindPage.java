package com.sqat.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightFindPage {
    WebDriver driver;

    By fromPort = By.name("fromPort");
    By toPort = By.name("toPort");
    By findFlightsButton = By.cssSelector("input[type='submit']");

    public FlightFindPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFromPort(String city) {
        driver.findElement(fromPort).sendKeys(city);
    }

    public void selectToPort(String city) {
        driver.findElement(toPort).sendKeys(city);
    }

    public void clickFindFlights() {
        driver.findElement(findFlightsButton).click();
    }
}