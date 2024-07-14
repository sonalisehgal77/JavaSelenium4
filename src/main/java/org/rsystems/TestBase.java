package org.rsystems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;

    @BeforeSuite
    public void initializeWebDriver() {
        WebDriverManager.chromedriver().setup();
//        WebDriver driver = null;
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void quitDriver() {
        driver.quit();
    }
}
