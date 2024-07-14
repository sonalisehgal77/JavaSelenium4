package org.rsystems;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;
        try {
            Path currentRelativePath = Paths.get("mod_header/modheader.xpi");
            ChromeOptions options = new ChromeOptions();
            options.addExtensions(new File(currentRelativePath.toAbsolutePath().toString()));
            driver = new ChromeDriver(options);
//            driver.get("https://webdriver.modheader.com/add?test=ModHeader%20Test");
            driver.get("http://www.google.com");
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.titleIs("Google"));

            driver.get("https://www.google.com/images");
            System.out.println(driver.getTitle());
            new WebDriverWait(driver, Duration.ofSeconds(1))
                    .until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "Images"));
            System.out.println("Success");
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

}