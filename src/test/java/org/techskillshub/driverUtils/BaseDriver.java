package org.techskillshub.driverUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.techskillshub.utils.ConfigReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseDriver {
    private static WebDriver driver;
    private static String url;

    @BeforeClass
    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    @AfterClass
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private static void initializeDriver() {
        if (driver == null) {
            // Read the browser type from config.properties
            ConfigReader configReader = new ConfigReader();
            String browserType = configReader.getProperty("browser.type");
            url = configReader.getProperty("appUrl");

            if ("chrome".equalsIgnoreCase(browserType)) {
                initializeChromeDriver();
            } else if ("firefox".equalsIgnoreCase(browserType)) {
                initializeFirefoxDriver();
            }

            driver.get(url);
        }
    }

    private static void initializeChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-info-bars");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    private static void initializeFirefoxDriver() {
        // Set up Firefox WebDriver (you can add support for other browsers here)
        driver = new FirefoxDriver();
    }
}
