package org.example;

// Generated by Selenium IDE

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

public class AppTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "c:/opt/chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void hurriyetLandingPageUITest() throws InterruptedException {
        // Test name: landing-page-ui-test
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("https://www.hurriyet.com.tr/");
        // 2 | setWindowSize | 1920x1040 |
        driver.manage().window().setSize(new Dimension(1920, 1040));

    }
}

