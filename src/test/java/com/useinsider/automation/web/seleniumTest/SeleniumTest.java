package com.useinsider.automation.web.seleniumTest;

import com.useinsider.automation.web.pageObjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class SeleniumTest {

    private static WebDriver driver;

    @BeforeTest
    public static void setUp() {
        driver = WebDriverFactory.getDriver();
    }

    @Test(priority = 1)
    public void verifyHomePageTest() {
        driver.get("https://useinsider.com/");
        driver.manage().window().maximize();
        (new WebDriverWait(driver, Duration.ofSeconds(20))).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        HomePage homePage = new HomePage(driver);
        new HomePageAssertions(driver).assertHomePageDisplayed(homePage);
    }

    @Test(dependsOnMethods = {"verifyHomePageTest"}, priority = 2)
    public void verifyCareersPageTest() {
        NavBar navBar = new NavBar(driver);
        navBar.openCompanyMenu();
        CompanyMenuPage companyMenuPage = new CompanyMenuPage(driver);
        companyMenuPage.openCareerPage();
        CareerPage careerPage = new CareerPage(driver);
        (new WebDriverWait(driver, Duration.ofSeconds(20))).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        new CareerPageAssertions(driver).assertCareerPageDisplayed(careerPage);
    }

    @Test(priority = 3)
    public void checkPresenceOfJobListTest() throws InterruptedException {
        driver.get("https://useinsider.com/careers/quality-assurance/");
        driver.findElement(By.xpath("//a[contains(@href, 'open-positions/')]")).click();
        (new WebDriverWait(driver, Duration.ofSeconds(20))).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3")));
        CookiesPopup cookiesPopup = new CookiesPopup(driver);
        cookiesPopup.clickAccept();
        OpenPositionsPage openPositionsPage = new OpenPositionsPage(driver);
        driver.manage().deleteAllCookies();
        openPositionsPage.filterJobByLocation("Istanbul, Turkey");
        openPositionsPage.filterJobByDepartment("Quality Assurance");
        new OpenPositionsPageAssertions(driver).assertOpenPositionsPageDisplayed(openPositionsPage);
    }

    @Test(dependsOnMethods = {"checkPresenceOfJobListTest"})
    public void checkRedirectToLeverAppFormTest() {
        OpenPositionsPage openPositionsPage = new OpenPositionsPage(driver);
        openPositionsPage.viewRole(driver);
        LeverApplicationFormPage leverApplicationFormPage = new LeverApplicationFormPage(driver);
        new LeverApplicationFormAssertions(driver).assertLeverApplicationFormDisplayed(leverApplicationFormPage);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                com.useinsider.automation.web.pageObjects.Utility.captureScreenshot(driver);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @AfterTest
    public void endSession() {
        WebDriverFactory.quitDriver();
    }
}
