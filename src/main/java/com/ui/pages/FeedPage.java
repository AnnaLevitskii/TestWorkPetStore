package com.ui.pages;

import com.core.providers.Config;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import static com.core.providers.Config.getDriver;


public class FeedPage extends HomePage {
    WebDriver driver = getDriver();
    public FeedPage(){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
    }

    @FindBy(xpath = "//div[@data-test-id='modal-button-box']/button")
    WebElement btnAddNewOnHeader;
    @FindBy(xpath = "//body")
    WebElement body;


    public FeedPage assertFeedPage(){
        Assert.assertTrue(isElementDisplayed(btnAddNewOnHeader));
        Assert.assertTrue(btnAddNewOnHeader.isEnabled());
        return new FeedPage();
    }

    public CreatorPage clickBtnAddNewHeader(){
        body.sendKeys(Keys.TAB, Keys.ENTER);
        return new CreatorPage();
    }
}
