package org.rsystems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage {
//    WebDriverManager
    private WebDriver driver = null;

    private static String PAGE_URL="https://magento.softwaretestingboard.com/";

    @FindBy(how = How.ID, using="ui-id-6")
    private WebElement gearItem;

    public HomePage(WebDriver driver){
        this.driver=driver;
        this.driver.get(PAGE_URL);

        PageFactory.initElements(this.driver, this);
    }

    public void clickOnGearItem(){
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.elementToBeClickable(gearItem)).click();
    }
}

