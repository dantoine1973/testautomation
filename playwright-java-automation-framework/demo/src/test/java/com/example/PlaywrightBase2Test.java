package com.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BrowserProperty {
    String value();
}

public class PlaywrightBase2Test {

    private PlaywrightBase2 playwrightBase2;
    private String previousBrowserProperty;

    @BeforeEach
    void startPlaywrightBeforeTest(TestInfo testInfo) {
        previousBrowserProperty = System.getProperty("browser");
        Method testMethod = testInfo.getTestMethod().orElseThrow();
        BrowserProperty browserProperty = testMethod.getAnnotation(BrowserProperty.class);

        if (browserProperty == null) {
            System.clearProperty("browser");
        } else {
            System.setProperty("browser", browserProperty.value());
        }

        playwrightBase2 = new PlaywrightBase2() {
        };
        playwrightBase2.startPlaywright();
    }

    @AfterEach
    void stopPlaywrightAfterTest() {
        try {
            if (playwrightBase2 != null) {
                playwrightBase2.stopPlaywright();
            }
        } finally {
            if (previousBrowserProperty == null) {
                System.clearProperty("browser");
            } else {
                System.setProperty("browser", previousBrowserProperty);
            }
        }
    }

    @Test
    @BrowserProperty("chromium")
    void browserShouldUseChromiumWhenChromiumIsSpecified() {
        assertEquals("chromium", System.getProperty("browser"));
    }

    @Test
    @BrowserProperty("firefox")
    void browserShouldUseFirefoxWhenFirefoxIsSpecified() {
        assertEquals("firefox", System.getProperty("browser"));
    }

    @Disabled("Edge is not supported in this test environment")
    @Test
    @BrowserProperty("edge")
    void browserShouldUseEdgeWhenEdgeIsSpecified() {
        assertEquals("edge", System.getProperty("browser"));
    }

    @Test
    @BrowserProperty("chrome")
    void browserShouldUseChromeWhenChromeIsSpecified() {
        assertEquals("chrome", System.getProperty("browser"));
    }

    @Test
    @BrowserProperty("webkit")
    void browserShouldUseWebkitWhenWebkitIsSpecified() {
        assertEquals("webkit", System.getProperty("browser"));
    }

    @Test
    void browserShouldDefaultToChromiumWhenNoBrowserIsSpecified() {
        assertAll(
                () -> assertNotNull(playwrightBase2.getBrowser(), "Browser should launch"),
                () -> assertEquals("chromium", playwrightBase2.getBrowser().browserType().name()));
    }

    @Test
    @BrowserProperty("invalid-browser")
    void browserShouldDefaultToChromiumWhenInvalidBrowserIsSpecified() {
        assertAll(
                () -> assertEquals("invalid-browser", System.getProperty("browser")),
                () -> assertEquals("chromium", playwrightBase2.getBrowser().browserType().name()));
    }
}
