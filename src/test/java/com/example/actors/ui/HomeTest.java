package com.example.actors.ui;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class HomeTest {
    private WebDriver webDriver;

    @BeforeAll
    public static void setUpWebDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }
}
