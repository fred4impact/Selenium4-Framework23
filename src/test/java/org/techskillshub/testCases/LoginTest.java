package org.techskillshub.testCases;

import org.openqa.selenium.WebDriver;
import org.techskillshub.driverUtils.BaseDriver;
import org.techskillshub.pageObjects.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @BeforeTest
    public void startBrowser() {
        driver = BaseDriver.getDriver();
    }

    @Test
    public void testCase1() {

        LoginPage page = new LoginPage(driver);
        page.enterUsername("standard_user");
        page.enterPassword("secret_sauce");
        page.clickLoginButton();
        System.out.println("Hey, we are live, thank you!");
    }

    @AfterTest
    public void stopBrowser() {
        BaseDriver.quitDriver();
    }
}
