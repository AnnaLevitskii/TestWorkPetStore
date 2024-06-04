package com.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static com.core.providers.Config.getDriver;


public class FoundPage extends HomePage {
    WebDriver driver = getDriver();
    public FoundPage() {

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
}
