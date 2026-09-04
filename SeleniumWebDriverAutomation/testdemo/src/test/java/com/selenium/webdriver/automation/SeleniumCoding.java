package com.selenium.webdriver.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumCoding {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/ref=nav_logo");
        String title = driver.getTitle();
        System.out.println("Title of the page is: " + title);
        driver.quit();
    }
}
