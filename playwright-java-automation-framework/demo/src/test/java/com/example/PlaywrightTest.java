package com.example;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class PlaywrightTest extends PlaywrightBase2 {

    @BeforeMethod
    public void setUp() {
        startPlaywright();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        stopPlaywright();
    }

/*     @Test
    public void pageTitleIsExample() {
        this.getPage().navigate("https://example.com/");
        assertEquals("Example Domain", this.getPage().title());
        this.getPage().waitForTimeout(5000);
    } */
}
