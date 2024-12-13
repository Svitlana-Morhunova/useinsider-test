package com.useinsider.automation.web.seleniumTest;

import com.useinsider.automation.web.pageObjects.LeverApplicationFormPage;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class LeverApplicationFormAssertions {

    private final WebDriver driver;

    public LeverApplicationFormAssertions(WebDriver driver) {
        this.driver = driver;
    }

    public void assertLeverApplicationFormDisplayed(LeverApplicationFormPage leverApplicationFormPage) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(leverApplicationFormPage.getApplyForThisJobButton().isDisplayed(),
                "Apply For This Job button is displayed.");
        softAssert.assertTrue(leverApplicationFormPage.getPositionName().isDisplayed(),
                "Position name is not displayed.");
        softAssert.assertAll();
    }
}
