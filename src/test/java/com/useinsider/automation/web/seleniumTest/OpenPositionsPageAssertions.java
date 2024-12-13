package com.useinsider.automation.web.seleniumTest;

import com.useinsider.automation.web.pageObjects.OpenPositionsPage;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class OpenPositionsPageAssertions {

    private final WebDriver driver;

    public OpenPositionsPageAssertions(WebDriver driver) {
        this.driver = driver;
    }

    public void assertOpenPositionsPageDisplayed(OpenPositionsPage openPositionsPage) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(openPositionsPage.isJobPositionDisplayed(driver),
                "Job position must be displayed");
        softAssert.assertTrue(openPositionsPage.isPositionCardsFilteredByLocation("Istanbul, Turkey"),
                "Position must be displayed by location");
        softAssert.assertTrue(openPositionsPage.isPositionCardsFilteredByPosition("Quality Assurance"),
                "Position must be displayed by position");
        softAssert.assertTrue(openPositionsPage.isPositionCardsFilteredByDepartment("Software"),
                "Position must be displayed by department");
        softAssert.assertAll();
    }

}
