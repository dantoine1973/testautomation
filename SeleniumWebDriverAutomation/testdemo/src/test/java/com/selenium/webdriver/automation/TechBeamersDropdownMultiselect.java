package com.selenium.webdriver.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.time.Duration;
import org.openqa.selenium.support.ui.Select;

public class TechBeamersDropdownMultiselect {

    public static void main(String[] args) throws InterruptedException {

        String initialUrl = "https://techbeamers.com/selenium-practice-test-page/";
        String browser = (args.length > 0) ? args[0].toLowerCase() : "chrome";
        InitializeWebDriver init = new InitializeWebDriver();
        WebDriver driver = null;

        WebElement dropdown, multiselect;
        Select dd;
        Select ms;
        List<WebElement> allOptions = null;

        driver = init.InitializeWebBrowserDriver(browser);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(initialUrl);

        dropdown = driver.findElement(By.id("country"));
        dd = new Select(dropdown);
        dd.selectByVisibleText("Canada");
        dd.selectByVisibleText("United States");

        allOptions = dd.getOptions();

        for (int i = 0; i < allOptions.size(); i++) {
            System.out.println(allOptions.get(i).getText());
        }

        Thread.sleep(3000);

        multiselect = driver.findElement(By.id("languages"));
        ms = new Select(multiselect);
        ms.selectByVisibleText("English");
//        ms.selectByValue("English");
//        ms.selectByValue("French");
//        ms.selectByValue("Spanish");

        Thread.sleep(2000);

        driver.quit();

    }

}