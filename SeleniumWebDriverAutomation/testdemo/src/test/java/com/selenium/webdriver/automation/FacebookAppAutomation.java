package com.selenium.webdriver.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class FacebookAppAutomation {
    public static void main(String[] args) throws InterruptedException {
        String initialUrl = "https://www.facebook.com/";
        String browser = (args.length > 0) ? args[0].toLowerCase() : "firefox";
        InitializeWebDriver init = new InitializeWebDriver();
        WebDriver driver = null;

        driver = init.InitializeWebBrowserDriver(browser);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(initialUrl);

        driver.findElement(By.name("email")).sendKeys("a2it@gmail.com");
        driver.findElement(By.name("pass")).sendKeys("Password1");

        Thread.sleep(3000);

        driver.findElement(By.cssSelector(".xtvsq51")).click();

        Thread.sleep(10000);

        System.out.println(driver.findElement(By.cssSelector("svg.x1a1m0xk")).isDisplayed());

        System.out.println(driver.findElement(By.cssSelector("span.xt0psk2")).isDisplayed());

        driver.quit();
    }
}
