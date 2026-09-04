package com.selenium.webdriver.automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class AmazonAppTestNgClass {

    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void OpenBrowser(@Optional("firefox") String browser) {

        String initialUrl = "https://www.amazon.com/ref=nav_logo";

        InitializeWebDriver init = new InitializeWebDriver();
        driver = init.InitializeWebBrowserDriver(browser);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(initialUrl);
    }

    @Test(priority = 0)
    public void navLogo() {
        driver.findElement(By.id("nav-logo-sprites")).click();
    }

    @Test(priority = 1)
    public void navOrders() {
        driver.findElement(By.id("nav-orders")).click();
    }

    @AfterMethod
    public void CloseBrowser() {
        driver.quit();
    }
}
