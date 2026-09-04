package com.selenium.webdriver.automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Listeners;

import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Listeners({ io.qameta.allure.testng.AllureTestNg.class })
public class OrbitzTripPlanner {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    @Parameters("browser")
    public void OpenBrowser(@Optional("firefox") String browser) {

        String initialUrl = "https://www.orbitz.com/";

        InitializeWebDriver init = new InitializeWebDriver();
        driver = init.InitializeWebBrowserDriver(browser);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(initialUrl);
    }

    @Test
    public void TripDetails() throws InterruptedException {
        
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("destination_form_field-input")));

        driver.findElement(By.id("destination_form_field-input"))
                .sendKeys("Las Vegas, Nevada", Keys.ENTER);

        Thread.sleep(1000);
        driver.findElement(By.id("destination_form_field-input"))
                .sendKeys(Keys.ESCAPE);

        Thread.sleep(5000);
    }

    @AfterMethod
    public void CloseBrowser() {
        driver.quit();
    }
}