package com.useinsider.automation.web.seleniumTest;

import com.useinsider.automation.web.pageObjects.CareerPage;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static java.util.List.of;
import static org.testng.AssertJUnit.assertTrue;

public class CareerPageAssertions {

    List<String> expectedLocations = of("New York", "London", "Sao Paulo", "Paris", "Amsterdam");
    private final WebDriver driver;

    public CareerPageAssertions(WebDriver driver) {
        this.driver = driver;
    }

    public void assertCareerPageDisplayed(CareerPage careerPage) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(careerPage.isFindYourCallingBlockDisplayed(),
                "Find your calling block must be displayed");
        softAssert.assertTrue(careerPage.isLocationsBlockDisplayed(),
                "Locations block must be displayed");
        softAssert.assertTrue(careerPage.isLifeAtInsiderBlockDisplayed(),
                "life at Insider block must be displayed");
        softAssert.assertTrue(careerPage.isFindYourDreamButtonDisplayed(),
                "Find your dream button must be displayed");
        softAssert.assertTrue(careerPage.isSeeAllTeamsButtonDisplayed(),
                "See all teams button must be displayed");
        softAssert.assertTrue(careerPage.isCreateYourLifeBlockDisplayed(),
                "Create your life block must be displayed");
        expectedLocations.forEach(location -> assertTrue(careerPage.getLocationCards().contains(location)));
        softAssert.assertAll();
    }
}
