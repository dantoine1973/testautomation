package com.example;

import java.awt.*;
import java.util.Arrays;
import com.microsoft.playwright.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class PlaywrightBase2 {
    // A ThreadLocal is like a personal storage locker for each thread. Each thread
    // has its own copy of the variable.
    // This is useful in multi-threaded environments like Cucumber parallel
    // execution, where each thread needs its own instance of Playwright, Browser,
    // Context, and Page.

    private static final ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private static final ThreadLocal<Browser> browser = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> context = new ThreadLocal<>();
    private static final ThreadLocal<Page> page = new ThreadLocal<>();

    private static final Logger logger = Logger.getLogger(PlaywrightBase2.class.getName());

    public Page getPage() {
        return page.get();
    }

    public void setPage(Page newPage) {
        page.set(newPage);
    }

    public Browser getBrowser() {
        return browser.get();
    }

    public void setBrowser(Browser newBrowser) {
        browser.set(newBrowser);
    }

    public BrowserContext getContext() {
        return context.get();
    }

    public void setContext(BrowserContext newContext) {
        context.set(newContext);
    }

    public byte[] takeScreenShot() {
        return (page.get() != null) ? page.get().screenshot() : new byte[0];
    }

    // CUCUMBER will call this from @Before
    protected void startPlaywright() {
        String browserName = System.getProperty("browser", "chromium");
        startPlaywright(browserName);
    }

    protected void startPlaywright(String browserName) {
        try {
            if (browserName == null || browserName.isBlank()) {
                browserName = "chromium";
            }

            playwright.set(Playwright.create());

            browserName = browserName.toLowerCase();
            String channel = null;

            BrowserType browserType = switch (browserName) {
                case "chromium" -> playwright.get().chromium();
                case "chrome", "google-chrome" -> {
                    channel = "chrome";
                    yield playwright.get().chromium();
                }
                case "msedge", "edge" -> {
                    channel = "msedge";
                    yield playwright.get().chromium();
                }
                case "firefox" -> playwright.get().firefox();
                case "webkit" -> playwright.get().webkit();
                default -> {
                    logger.warning("Unknown browser '" + browserName + "', using chromium.");
                    yield playwright.get().chromium();
                }
            };

            boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));

            BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                    .setHeadless(headless)
                    .setArgs(Arrays.asList("--start-maximized"));

            if (channel != null) {
                launchOptions.setChannel(channel);
            }

            browser.set(browserType.launch(launchOptions));

            // ⭐ IMPORTANT: remove viewport so maximize works
            context.set(browser.get().newContext(new Browser.NewContextOptions().setViewportSize(null)));

            page.set(context.get().newPage());

            // ⭐ Cross-browser maximize (works in Firefox)
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            page.get().setViewportSize(screenSize.width, screenSize.height);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error during Playwright setup: " + e.getMessage(), e);
        } finally {
            logger.info("Playwright setup complete");
        }
    }

    // CUCUMBER will call this from @After
    protected void stopPlaywright() {
        try {
            closePage();
        } finally {
            try {
                closeContext();
            } finally {
                try {
                    closeBrowser();
                } finally {
                    try {
                        closePlaywright();
                    } finally {
                        page.remove();
                        context.remove();
                        browser.remove();
                        playwright.remove();
                    }
                }
            }
        }
    }

    private void closePage() {
        try {
            if (page.get() != null) {
                page.get().close();
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, "Error closing Playwright page: " + e.getMessage(), e);
        }
    }

    private void closeContext() {
        try {
            if (context.get() != null) {
                context.get().close();
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, "Error closing Playwright context: " + e.getMessage(), e);
        }
    }

    private void closeBrowser() {
        try {
            if (browser.get() != null) {
                browser.get().close();
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, "Error closing Playwright browser: " + e.getMessage(), e);
        }
    }

    private void closePlaywright() {
        try {
            if (playwright.get() != null) {
                playwright.get().close();
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, "Error closing Playwright: " + e.getMessage(), e);
        } finally {
            logger.info("Playwright torn down");
        }
    }
}