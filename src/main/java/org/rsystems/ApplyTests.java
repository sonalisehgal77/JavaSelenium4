package org.rsystems;

import org.junit.jupiter.api.Test;

public class ApplyTests extends TestBase {
    @Test
    public void getHomePageTest(){
        HomePage home = new HomePage(driver);
        home.clickOnGearItem();
    }
}