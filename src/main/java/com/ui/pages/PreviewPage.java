package com.ui.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import static com.core.providers.Config.getDriver;


public class PreviewPage extends HomePage {
    WebDriver driver = getDriver();
    public PreviewPage(){

        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
    }
    @FindBy(xpath = "//button[text()='Edit']")
    WebElement btnEdit;
    @FindBy(xpath = "//button[text()='Publish']")
    WebElement btnPublish;


    public PreviewPage assertThatBtnEditDisplayed(){
        Assert.assertTrue(isElementDisplayed(btnEdit));
        return this;
    }

    public LostPage clickBtnPublishPositive(){
        btnPublish.click();
        return new LostPage();
    }
}
