package com.example;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class PlaywrightTest extends PlaywrightBase2 {

    @Test
    public void pageTitleIsExample() {
        this.getPage().navigate("https://example.com/");
        assertEquals("Example Domain", this.getPage().title());
        this.getPage().waitForTimeout(5000);
    }
}
