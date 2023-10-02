package org.techskillshub.driverUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.techskillshub.utils.ConfigReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseDriver {

    private static WebDriver driver;

    @BeforeClass
    public static WebDriver getDriver() {

        if (driver == null) {
            // Read the browser type from config.properties
            ConfigReader configReader = new ConfigReader();
            String browserType = configReader.getProperty("app.url");
            String url = configReader.getProperty("app.url");

            // instatiate the webDriver Manager

             WebDriverManager.chromedriver().setup();

            // Set up the WebDriver instance based on the browser type
            if ("chrome".equalsIgnoreCase(browserType)) {
                // Set the path to the ChromeDriver executable
                System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

                // Configure Chrome options
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-info-bars");
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-extensions");

                // Create a new ChromeDriver instance
                // set the Webdriver manager here
                driver = new ChromeDriver(options);


            } else if ("firefox".equalsIgnoreCase(browserType)) {
                // Set up Firefox WebDriver (you can add support for other browsers here)
                FirefoxDriver fireOptions = new FirefoxDriver();
            }

            // Handle other browser types as needed
            driver.get(url);
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

}
