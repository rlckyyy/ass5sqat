package com.sqat.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightChoosePage {
    WebDriver driver;

    By chooseFlightButton = By.xpath("//input[@value='Choose This Flight']");

    public FlightChoosePage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseFlight() {
        driver.findElement(chooseFlightButton).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}