package com.useinsider.automation.web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NavBar {

    @FindBy(css = "#navbarNavDropdown")
    private WebElement navBar;

    public WebElement getNavBar() {
        return navBar;
    }

    @FindBy(xpath = "//*[contains(text(), 'Company')]")
    private WebElement companyMenu;

    public WebElement getCompanyMenu() {
        return companyMenu;
    }

    public NavBar(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void openCompanyMenu() {
        getCompanyMenu().click();
    }
}