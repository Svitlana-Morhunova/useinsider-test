package com.useinsider.automation.web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeverApplicationFormPage {

    @FindBy(xpath = "//a[contains(@href, 'jobs.')]")
    private WebElement applyForThisJobButton;

    public WebElement getApplyForThisJobButton() {
        return applyForThisJobButton;
    }

    @FindBy(xpath = "//div[@class='posting-headline']//h2")
    private WebElement positionName;

    public WebElement getPositionName() {
        return positionName;
    }

    public LeverApplicationFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}