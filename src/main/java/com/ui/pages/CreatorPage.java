package com.ui.pages;

import com.core.models.dtos.PetDTO;

import com.core.models.enums.PetSex;
import com.core.models.enums.PetType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import static com.core.providers.Config.getDriver;


public class CreatorPage extends HomePage {
    WebDriver driver = getDriver();
    public CreatorPage(){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
    }

    @FindBy(xpath = "//div[@data-test-id='info-item-0']//em")
    WebElement fieldType;
    @FindBy(xpath = "//div[@data-test-id='info-item-1']//em")
    WebElement fieldSex;
    @FindBy(xpath = "//div[@data-test-id='info-item-2']//input")
    WebElement fieldBreed;
    @FindBy(xpath = "//div[@data-test-id='info-item-3']//input")
    WebElement fieldColor;
    @FindBy(xpath = "//textarea[@placeholder='Blue collar with stars, no left ear, damaged tail.']")
    WebElement fieldDistinctiveFeatures;
    @FindBy(xpath = "//div[@data-test-id='info-item-description']//input")
    WebElement fieldDescription;
    @FindBy(xpath = "//button[text()='Add']")
    WebElement btnAddDescription;
    @FindBy(xpath = "//input[@placeholder='Enter address']")
    WebElement fieldLocation;
    @FindBy(xpath = "//input[@name='Phone']")
    WebElement fieldPhone;
    @FindBy(xpath = "//button[text()='Publish']")
    WebElement btnPublish;

    @FindBy(xpath = "//textarea")
    WebElement fieldText;
    @FindBy(xpath = "//input[@data-test-id='input-file']")
    WebElement fieldPhoto;
    @FindBy(xpath = "//div[@data-test-id='file-container-0']")
    WebElement fileContainer;

    public CreatorPage fillLostFoundForm(PetDTO pet){
        fillFieldType(pet.getType());
        fillFieldSex(pet.getSex());

        fieldBreed.sendKeys(pet.getBreed());
        fieldColor.sendKeys(pet.getColor());

        fieldDistinctiveFeatures.sendKeys(pet.getDistinctive_features());

        for(String tag : pet.getDescription()){
            fieldDescription.sendKeys(tag);
            btnAddDescription.click();
        }

        File file = new File("src/main/java/com/core/utils/stubData/Cat.png");
        fieldPhoto.sendKeys(file.getAbsolutePath());
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> fileContainer.isDisplayed());

        fieldLocation.sendKeys(pet.getLocation());
        fieldLocation.sendKeys(Keys.ENTER);

        fieldPhone.click();
        fieldPhone.sendKeys(pet.getContacts());

        return this;
    }
    public PreviewPage clickBtnPublishPositive(){
        btnPublish.click();
        return new PreviewPage();
    }

    private void fillFieldType(PetType type) {
        fieldType.click();
        WebElement elementLi = driver.findElement(
                By.xpath("//li[text()='"+type.getText()+"']"));
        elementLi.click();
    }
    private void fillFieldSex(PetSex sex) {
        fieldSex.click();
        WebElement elementLi = driver.findElement(
                By.xpath("//li[text()='"+sex.getText()+"']"));
        elementLi.click();
    }
}
