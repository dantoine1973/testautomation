package com.selenium.webdriver.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.time.Duration;

public class TechBeamersLinkTestClass {

    public static void main(String[] args) {

        String initialUrl = "https://techbeamers.com/selenium-practice-test-page/";
        String browser = (args.length > 0) ? args[0].toLowerCase() : "firefox";
        InitializeWebDriver init = new InitializeWebDriver();
        WebDriver driver = null;
        List<WebElement> allLinks = null;
        int i;

        driver = init.InitializeWebBrowserDriver(browser);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(initialUrl);

        allLinks = driver.findElements(By.xpath("//a"));
        System.out.println(allLinks.size());

        for (i = 0; i < allLinks.size(); i++) {
            System.out.println(allLinks.get(i).getText());
        }

        driver.findElement(By.linkText("Selenium Website (New Tab)")).click();

        driver.quit();
    }

}
