package com.sqat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task1Test {
    WebDriver driver;

    @BeforeClass
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    void loginTest() {
        driver.get("https://github.com/login");
        String[][] strings = Task1.readExcel("/Users/relucky/Documents/creds.xlsx");
        WebElement loginElem = driver.findElement(By.id("login_field"));
        loginElem.sendKeys(Task1.retrieveUsername(strings));
        WebElement passElem = driver.findElement(By.id("password"));
        passElem.sendKeys(Task1.retrievePassword(strings));
        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/main/div/div[4]/form/div/input[13]"));
        submitButton.click();
        WebElement newRepo = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/aside/div/div/loading-context/div/div[1]/div/div[1]/a/span"));
        Assert.assertNotNull(newRepo);
    }

    @AfterClass
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
