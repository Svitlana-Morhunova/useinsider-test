package com.useinsider.automation.web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "img[alt='insider_logo']")
    private WebElement logo;

    public WebElement getLogo() {
        return logo;
    }

    @FindBy(xpath = "//a[contains(@href, 'request-a-demo')]")
    private WebElement demoButton;

    public WebElement getDemoButton() {
        return demoButton;
    }
}