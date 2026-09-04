package com.selenium.webdriver.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class TechBeamersIFrame {
    public static void main(String[] args) throws InterruptedException {
        String initialUrl = "https://techbeamers.com/selenium-practice-test-page/";
        String browser = (args.length > 0) ? args[0].toLowerCase() : "firefox";
        InitializeWebDriver init = new InitializeWebDriver();
        WebDriver driver = null;

        driver = init.InitializeWebBrowserDriver(browser);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(initialUrl);

        driver.switchTo().defaultContent();

        driver.findElement(By.id("load-iframe")).click();
        driver.findElement(By.id("interact-iframe")).click();

        Thread.sleep(2000);

        driver.switchTo().frame("sample-iframe");
        Thread.sleep(2000);
        driver.findElement(By.id("iframe-btn")).click();
        Thread.sleep(2000);

        driver.quit();

    }
}
