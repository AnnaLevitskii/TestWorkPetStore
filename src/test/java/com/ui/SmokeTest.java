package com.ui;

import com.core.models.dtos.PetDTO;
import com.core.models.dtos.UserDTO;
import com.core.models.enums.PetSex;
import com.core.models.enums.PetType;
import com.core.providers.Config;
import com.core.providers.PropertiesProvider;
import com.ui.pages.FeedPage;
import com.ui.pages.LoginPage;
import org.testng.annotations.Test;

import static com.core.providers.TestDataGenerator.*;

public class SmokeTest extends Config {

    @Test(priority = 1)
    public void login_positiveTest() {
        UserDTO user = UserDTO.builder()
                .email(PropertiesProvider.getProperty("email"))
                .password(PropertiesProvider.getProperty("password"))
                .build();
         new LoginPage().clickBtnLoginHeader()
                .typeLoginForm(user)
                .clickBtnSubmitPositive()
                 .assertFeedPage();
    }
    @Test(priority = 2)
    public void createLostPost_positiveTest() {
        PetDTO animal = PetDTO.builder()
                .type(PetType.CAT)
                .sex(PetSex.OTHER)
                .breed(randomBreedOfCat())
                .color(randomColor())
                .distinctive_features(randomText())
                .description(randomTags())
                .location(randomLocation())
                .contacts(randomPhone())
                .build();
        new FeedPage().clickBtnAddNewHeader()
                .clickBtnILostMyPet()
                .fillLostFoundForm(animal)
                .clickBtnPublishPositive()
                .assertThatBtnEditDisplayed()
                .clickBtnPublishPositive()
                .assertThatPostDisplayed(animal);
    }
}
