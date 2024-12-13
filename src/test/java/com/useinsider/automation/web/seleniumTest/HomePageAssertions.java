package com.useinsider.automation.web.seleniumTest;

import com.useinsider.automation.web.pageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class HomePageAssertions {

    private final WebDriver driver;

    public HomePageAssertions(WebDriver driver) {
        this.driver = driver;
    }

    public void assertHomePageDisplayed(HomePage homePage) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.getDemoButton().isDisplayed(),
                "Demo button must be displayed");
        softAssert.assertTrue(homePage.getLogo().isDisplayed(),
                "Logo must be displayed");
        softAssert.assertAll();
    }
}
