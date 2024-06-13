package com.ui.pages;

import com.core.models.dtos.PetDTO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import static com.core.providers.Config.getDriver;


public class LostPage extends HomePage {
    WebDriver driver = getDriver();
    public LostPage(){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
    }

    @FindBy(xpath = "//div[@data-test-id='lost-found-post-container']")
    WebElement postCard;


    public LostPage assertThatPostDisplayed(PetDTO pet){
        String post = postCard.getText();
        String color = post.split("Color:")[1].split("Sex:")[0].toString().trim();
        String breed = post.split(", ")[1].split("Color:")[0].toString().trim();
        Assert.assertTrue(color.equals(pet.getColor()));
        Assert.assertTrue(breed.equals(pet.getBreed()));
        return this;
    }
}
