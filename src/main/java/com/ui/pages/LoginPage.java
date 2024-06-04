package com.ui.pages;
import com.core.models.dtos.UserDTO;
import com.core.providers.PropertiesProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static com.core.providers.Config.getDriver;


public class LoginPage extends HomePage {
    WebDriver driver = getDriver();

    @FindBy(xpath = "//input[@placeholder='peter@gmail.com']")
    WebElement fieldEmail;
    @FindBy(xpath = "//input[@placeholder='******']")
    WebElement fieldPassword;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement btnSubmit;
    @FindBy(xpath = "//div[@data-test-id='header-container']/button")
    WebElement btnSingInHeader;


    String url = PropertiesProvider.getProperty("url");
    public LoginPage(){
        driver.get(url);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
    }

    public LoginPage clickBtnLoginHeader() {
        btnSingInHeader.click();
        return this;
    }
public LoginPage typeLoginForm(UserDTO user) {
        fieldEmail.sendKeys(user.getEmail());
        fieldPassword.sendKeys(user.getPassword());
        return this;
    }

    public FeedPage clickBtnSubmitPositive(){
        btnSubmit.click();
        return new FeedPage();
    }
}
