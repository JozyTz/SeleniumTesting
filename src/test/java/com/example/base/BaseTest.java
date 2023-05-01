package com.example.base;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseTest
{
    private static EdgeDriver driver;

    @BeforeAll
    public static void setupTest() {
        System.setProperty("webdriver.chrome.driver", "/edgedriver_win32/msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @BeforeEach
    public void setupBrowser() {
        driver.get("localhost:3000");
    }

    @AfterEach
    public void closeTest() {
        driver.manage().deleteAllCookies();
    }

    @AfterAll
    public static void closeDriver() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
