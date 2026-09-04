package com.selenium.webdriver.automation;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AmazonAppClass {

    public static void verifyHomepageTitle(WebDriver driver) {
        String expectedTitle = "Amazon.com. Spend less. Smile more.";
        String actualTitle = driver.getTitle();
        try {
            Assert.assertEquals(expectedTitle, actualTitle);
            System.out.println("Test Passed");
        } catch (Throwable e) {
            System.out.println("Test Failed");
        }

    }
    public static void main(String[] args) throws InterruptedException {

        String initialUrl = "https://www.amazon.com/ref=nav_logo";
        String browser = (args.length > 0) ? args[0].toLowerCase() : "firefox";
        InitializeWebDriver init = new InitializeWebDriver();
        WebDriver driver = null;

        driver = init.InitializeWebBrowserDriver(browser);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(initialUrl);

        verifyHomepageTitle(driver);

        Thread.sleep(3000);

        driver.quit();
    }


}
