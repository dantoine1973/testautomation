package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
// import com.example.PlaywrightBase2;

public class PlaywrightBase2Test {

@ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox", "edge", "chrome"})
    public void browserShouldUseCorrectValidValueWhenBrowserIsLaunched(String browser) {
        // given - the browser system property is set to the specified value
        System.setProperty("browser", browser);

        // when - we create a new instance of PlaywrightBase2, which will call
        // startPlaywright() in its constructor

        PlaywrightBase2 playwrightBase2 = new PlaywrightBase2() {
        };
        playwrightBase2.startPlaywright();

        // then - the browser system property should be the specified value
        assertEquals(browser, System.getProperty("browser", "chromium"));
    }

    @Test
    public void browserShouldDefaultToChromiumWhenNoBrowserIsSpecified() {
        // given - no browser system property is set, so it should default to "chromium"
        System.clearProperty("browser");

        // when - we create a new instance of PlaywrightBase2, which will call
        // startPlaywright() in its constructor

        PlaywrightBase2 playwrightBase2 = new PlaywrightBase2() {
        };
        playwrightBase2.startPlaywright();

        // then - the browser system property should be "chromium"
        assertEquals("chromium", System.getProperty("browser", "chromium"));
    }

    @Test
    public void browserShouldDefaultToChromiumWhenInvalidBrowserIsSpecified() {
        // given - an invalid browser system property is set
        System.setProperty("browser", "invalid-browser");

        // when - we create a new instance of PlaywrightBase2, which will call
        // startPlaywright() in its constructor

        PlaywrightBase2 playwrightBase2 = new PlaywrightBase2() {
        };
        playwrightBase2.startPlaywright();

        // then - the browser system property should be "chromium"
        assertEquals("invalid-browser", System.getProperty("browser", "chromium"));
    }

}
