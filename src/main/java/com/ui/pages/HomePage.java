package com.ui.pages;

import com.core.models.enums.LeftMenuItems;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    protected static WebDriver driver;

    @FindBy(xpath = "//div[@data-test-id='account-header-lost-found']/button[2]")
    WebElement btnIFoundPetOnHeader;
    @FindBy(xpath = "//div[@data-test-id='account-header-lost-found']/button[1]")
    WebElement btnILostMyPetOnHeader;



    public CreatorPage clickBtnIFoundPet() {
        btnIFoundPetOnHeader.click();
        return new CreatorPage();
    }
    public CreatorPage clickBtnILostMyPet() {
        btnILostMyPetOnHeader.click();
        return new CreatorPage();
    }

    public static boolean isElementDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static <T extends HomePage> T openLeftMenuItem(LeftMenuItems leftMenuItems) {
        try {
            WebElement elementMenuItem = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(leftMenuItems.getLocator())));
            elementMenuItem.click();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        switch (leftMenuItems) {
            case HOME:
                return (T) new FeedPage();
            case LOST:
                return (T) new LostPage();
            case FOUND:
                return (T) new FoundPage();
            case LOGOUT:
                return (T) new LoginPage();
            default:
                throw new IllegalArgumentException("invalid parametr leftMenuItem");
        }
    }
}
