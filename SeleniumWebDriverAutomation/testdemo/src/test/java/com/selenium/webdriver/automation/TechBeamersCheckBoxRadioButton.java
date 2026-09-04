package com.selenium.webdriver.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class TechBeamersCheckBoxRadioButton {
    public static void main(String[] args) {
        String initialUrl = "https://techbeamers.com/selenium-practice-test-page/";
        String browser = (args.length > 0) ? args[0].toLowerCase() : "firefox";
        InitializeWebDriver init = new InitializeWebDriver();
        WebDriver driver = null;

        driver = init.InitializeWebBrowserDriver(browser);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(initialUrl);

        driver.findElement(By.cssSelector("label[for='male']")).click();
        System.out.println(driver.findElement(By.id("male")).isSelected());

        driver.findElement(By.cssSelector("label[for='female']")).click();
        System.out.println(driver.findElement(By.id("female")).isSelected());

        driver.findElement(By.cssSelector("label[for='other']")).click();
        System.out.println(driver.findElement(By.id("other")).isSelected());

        driver.findElement(By.id("sports")).click();
        driver.findElement(By.id("music")).click();
        driver.findElement(By.id("reading")).click();
        driver.findElement(By.id("travel")).click();

        driver.findElement(By.id("travel")).click();
        System.out.println(driver.findElement(By.id("travel")).isSelected());

        driver.findElement(By.id("reading")).click();
        System.out.println(driver.findElement(By.id("reading")).isSelected());

        driver.findElement(By.id("music")).click();
        System.out.println(driver.findElement(By.id("music")).isSelected());

        System.out.println(driver.findElement(By.id("sports")).isSelected());

        driver.quit();
    }
}
