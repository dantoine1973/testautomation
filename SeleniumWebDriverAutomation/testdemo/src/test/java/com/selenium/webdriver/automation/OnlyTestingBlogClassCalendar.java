package com.selenium.webdriver.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OnlyTestingBlogClassCalendar {

    public static void main(String[] args) {

        String browser = (args.length > 0) ? args[0].toLowerCase() : "chrome";
        InitializeWebDriver init = new InitializeWebDriver();
        WebDriver driver = null;

        driver = init.InitializeWebBrowserDriver(browser);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://only-testing-blog.blogspot.com");
        // driver.findElement(By.id("nativeDate")).click();
        driver.findElement(By.id("nativeDate")).click();
        driver.findElement(By.id("nativeDate")).clear();
        driver.findElement(By.id("nativeDate")).sendKeys("2026-08-01");

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(d -> true);

        driver.quit();

    }
}
