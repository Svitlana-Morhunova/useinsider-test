package com.useinsider.automation.web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompanyMenuPage {

    @FindBy(xpath = "//div[@class = 'dropdown-menu new-menu-dropdown-layout-6 show']")
    private WebElement dropdown;

    public WebElement getDropdown() {
        return dropdown;
    }

    @FindBy(xpath = "//div[@class = 'new-menu-dropdown-layout-6-mid-container']//a[contains(@href, 'careers')]")
    private WebElement careersButton;

    public WebElement getCareersButton() {
        return careersButton;
    }

    public CompanyMenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void openCareerPage() {
        getCareersButton().click();
    }
}
