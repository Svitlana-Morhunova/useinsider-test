package com.useinsider.automation.web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OpenPositionsPage {

    @FindBy(css = "#jobs-list")
    private WebElement openPositionsBlock;

    public WebElement getOpenPositionsBlock() {
        return openPositionsBlock;
    }

    @FindBy(css = "#select2-filter-by-location-container")
    private WebElement filterJobByLocation;

    public WebElement getFilterJobByLocation() {
        return filterJobByLocation;
    }

    @FindBy(css = "#select2-filter-by-department-container")
    private WebElement filterJobByDepartment;

    public WebElement getFilterJobByDepartment() {
        return filterJobByDepartment;
    }

    @FindBy(xpath = "//*[@id='jobs-list']/div[contains (@class, position-list-item)]//div[contains (@class, position-title)]//span")
    private WebElement cardPosition;

    public WebElement getCardPosition() {
        return cardPosition;
    }

    @FindBy(xpath = "//*[@id='jobs-list']/div[contains (@class, position-list-item)]//div[contains (@class, position-department)]//span")
    private WebElement cardDepartment;

    public WebElement getCardDepartment() {
        return cardDepartment;
    }

    @FindBy(xpath = "//*[@id='jobs-list']/div[contains (@class, position-list-item)]//div[contains (@class, position-location)]//span")
    private WebElement cardLocation;

    public WebElement getCardLocation() {
        return cardLocation;
    }

    @FindBy(xpath = "//*[@id='jobs-list']/div[contains (@class, position-list-item)]")
    private WebElement positionCard;

    public WebElement getPositionCard() {
        return positionCard;
    }

    @FindBy(xpath = "//a[contains(@href, 'jobs.')]")
    private WebElement viewRoleButton;

    public WebElement getViewRoleButton() {
        return viewRoleButton;
    }

    @FindBy(css = "li[role='option']")
    private List<WebElement> dropdownOptions;

    public List<WebElement> getDropdownOptions() {
        return dropdownOptions;
    }

    @FindBy(xpath = "//*[@id='jobs-list']/div[contains (@class, position-list-item)]")
    private List<WebElement> positionCards;

    public List<WebElement> getPositionCards() {
        return positionCards;
    }

    public OpenPositionsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isJobPositionDisplayed(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//*[@id='jobs-list']/div[contains (@class, position-list-item)]")); // Replace with actual locator
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        (new WebDriverWait(driver, Duration.ofSeconds(20))).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='jobs-list']/div[contains (@class, position-list-item)]")));
        return getPositionCard().isDisplayed();
    }

    public boolean isJobPositionDisplayedByLocation(String expectedLocation) {
        return getPositionCard().getCssValue("data-location").equals(expectedLocation);
    }

    public boolean isJobPositionDisplayedByDepartment(String expectedDepartment) {
        return getPositionCard().getCssValue("data-team").equals(expectedDepartment);
    }

    public void filterJobByLocation(String jobLocationText) {
        getFilterJobByLocation().click();
        List<WebElement> options = getDropdownOptions();
        boolean optionFound = false;
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(jobLocationText)) {
                option.click();
                optionFound = true;
                break;
            }
        }

        if (!optionFound) {
            System.out.println("Option '" + jobLocationText + "' not found in the dropdown.");
        }
    }

    public void filterJobByDepartment(String jobDepartmentText) {
        getFilterJobByDepartment().click();
        List<WebElement> options = getDropdownOptions();
        boolean optionFound = false;
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(jobDepartmentText)) {
                option.click();
                optionFound = true;
                break;
            }
        }

        if (!optionFound) {
            System.out.println("Option '" + jobDepartmentText + "' not found in the dropdown.");
        }
    }

    public boolean isPositionCardsFilteredByLocation(String expectedLocation) {
        List<WebElement> positionCards1 = getPositionCards();
        boolean isJobFiltered = false;
        for (WebElement position : positionCards1) {
            String positionCardText = position.getText();
            isJobFiltered = positionCardText.contains(expectedLocation);
        }
        return isJobFiltered;
    }

    public boolean isPositionCardsFilteredByDepartment(String expectedDepartment) {
        List<WebElement> positionCards1 = getPositionCards();
        boolean isJobFiltered = false;
        for (WebElement position : positionCards1) {
            String positionCardText = position.getText();
            isJobFiltered = positionCardText.contains(expectedDepartment);
        }
        return isJobFiltered;
    }

    public boolean isPositionCardsFilteredByPosition(String expectedPosition) {
        List<WebElement> positionCards1 = getPositionCards();
        boolean isJobFiltered = false;
        for (WebElement position : positionCards1) {
            String positionCardText = position.getText();
            isJobFiltered = positionCardText.contains(expectedPosition);
        }
        return isJobFiltered;
    }

    public void viewRole(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//*[@id='jobs-list']/div[contains (@class, position-list-item)]")); // Replace with actual locator
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Actions actions = new Actions(driver);

        actions.moveToElement(getPositionCard()).perform();
        getViewRoleButton().click();
        List tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(String.valueOf(tabs.get(1)));
    }

}
