package com.example;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import java.util.Arrays;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;

public class PlaywrightExample {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            var browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setArgs(Arrays.asList("--start-maximized")));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setViewportSize(null));
            var page = context.newPage();
            page.navigate("https://webdriveruniversity.com/");
            System.out.println("Page title: " + page.title());
            browser.close();
        }
    }
}
