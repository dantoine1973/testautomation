package com.example;

import java.awt.*;
import java.util.Arrays;
import com.microsoft.playwright.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;

public abstract class PlaywrightBase {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chromium") String browserName) {
        startPlaywright(browserName);
    }

    protected void startPlaywright() {
        String browserName = System.getProperty("browser", "chromium");
        startPlaywright(browserName);
    }

    protected void startPlaywright(String browserName) {
        playwright = Playwright.create();

        browserName = browserName.toLowerCase();
        String channel = null;

        BrowserType browserType = switch (browserName) {
            case "chromium" -> playwright.chromium();
            case "chrome", "google-chrome" -> {
                channel = "chrome";
                yield playwright.chromium();
            }
            case "msedge", "edge" -> {
                channel = "msedge";
                yield playwright.chromium();
            }
            case "firefox" -> playwright.firefox();
            case "webkit" -> playwright.webkit();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browserName);
        };

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setArgs(Arrays.asList("--start-maximized"));

        if (channel != null) {
            launchOptions.setChannel(channel);
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        browser = browserType.launch(launchOptions);
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(width, height));
        page = context.newPage();
    }

    @AfterMethod
    public void tearDown() {
        stopPlaywright();
    }

    protected void stopPlaywright() {
        if (page != null)
            page.close();
        if (context != null)
            context.close();
        if (browser != null)
            browser.close();
        if (playwright != null)
            playwright.close();
    }
}