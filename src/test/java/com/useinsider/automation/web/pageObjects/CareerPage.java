package com.useinsider.automation.web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CareerPage {
    @FindBy(xpath = "//*[contains(text(), 'Life at Insider')]")
    private WebElement lifeAtInsiderBlock;

    public WebElement getLifeAtInsiderBlock() {
        return lifeAtInsiderBlock;
    }

    @FindBy(xpath = "//*[contains(text(), 'Our Locations')]")
    private WebElement locationsBlock;

    public WebElement getLocationsBlock() {
        return locationsBlock;
    }

    @FindBy(xpath = "//*[contains(text(), 'Find your calling')]")
    private WebElement findYourCallingBlock;

    public WebElement getFindYourCallingBlock() {
        return findYourCallingBlock;
    }

    @FindBy(css = "#find-job-widget")
    private WebElement createYourLifeBlock;

    public WebElement getCreateYourLifeBlock() {
        return createYourLifeBlock;
    }

    @FindBy(xpath = "//a[contains(@href, 'open-positions/')]")
    private WebElement findJobButton;

    public WebElement getFindJobButton() {
        return findJobButton;
    }

    @FindBy(xpath = "//*[@id='find-job-widget']//a[contains(@href, 'open-positions/')]")
    private WebElement findYourDreamButton;

    public WebElement getFindYourDreamButton() {
        return findYourDreamButton;
    }

    @FindBy(xpath = "//a[contains(text(), 'See all teams')]")
    private WebElement seeAllTeamsButton;

    public WebElement getsSeeAllTeamsButton() {
        return seeAllTeamsButton;
    }

    @FindBy(xpath = "//div[@class='location-info']//p")
    private List<WebElement> locationsBlocks;

    public List<WebElement> getLocationsBlocks() {
        return locationsBlocks;
    }

    public CareerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isLifeAtInsiderBlockDisplayed() {
        return getLifeAtInsiderBlock().isDisplayed();
    }

    public boolean isLocationsBlockDisplayed() {
        return getLocationsBlock().isDisplayed();
    }

    public boolean isFindYourCallingBlockDisplayed() {
        return getFindYourCallingBlock().isDisplayed();
    }

    public boolean isCreateYourLifeBlockDisplayed() {
        return getCreateYourLifeBlock().isDisplayed();
    }

    public boolean isFindYourDreamButtonDisplayed() {
        return getFindYourDreamButton().isDisplayed();
    }

    public boolean isSeeAllTeamsButtonDisplayed() {
        return getsSeeAllTeamsButton().isDisplayed();
    }

    public List<String> getLocationCards() {
        List<WebElement> locationCards = getLocationsBlocks();
        List<String> locationTexts = new ArrayList<>();
        // Verify the location text for each card
        for (int i = 0; i < locationCards.size(); i++) {
            String actualLocationText = locationCards.get(i).getText().trim();
            locationTexts.add(actualLocationText);
        }
        return locationTexts;
    }
}