package com.useinsider.automation.web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CookiesPopup {

    @FindBy(xpath = "//*[contains(text(), 'Accept All')]")
    private WebElement acceptButton;

    public WebElement getAcceptButton() {
        return acceptButton;
    }

    public CookiesPopup(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickAccept() {
        getAcceptButton().click();
    }
}
