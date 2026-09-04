package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExamplePageTest extends PlaywrightBase {

    @Test
    void pageTitleIsExample() {
        page.navigate("https://example.com/");
        assertEquals("Example Domain", page.title());
    }
}
