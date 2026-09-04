package com.example;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class PlaywrightTest extends PlaywrightBase {

    @Test
    public void pageTitleIsExample() {
        page.navigate("https://example.com/");
        assertEquals("Example Domain", page.title());
        page.waitForTimeout(5000);
    }
}