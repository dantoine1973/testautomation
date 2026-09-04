package com.selenium.webdriver.automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class OnlyTestingBlogClass {
    public static void main(String[] args) {

        String browser = (args.length > 0) ? args[0].toLowerCase() : "chrome";
        InitializeWebDriver init = new InitializeWebDriver();
        WebDriver driver = null;

        driver = init.InitializeWebBrowserDriver(browser);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://only-testing-blog.blogspot.com");
        driver.findElement(By.xpath("//button[text()='Alert']")).click();

        while (true) {
            try {
                Alert alert = driver.switchTo().alert();
                System.out.println(alert.getText());
                alert.accept();
                Thread.sleep(5000);
            } catch (NoAlertPresentException e) {
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        driver.quit();
    }

}
