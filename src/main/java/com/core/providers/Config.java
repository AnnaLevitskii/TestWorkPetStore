package com.core.providers;

import com.core.models.enums.ScreenSize;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Config {
    private static WebDriver driver;

    private static final String SCREEN = System.getProperty("screen", "DESKTOP_S");

    static public WebDriver getDriver(){
        return driver;
    }
    static public String getScreen(){
        return SCREEN;
    }

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void init(String browser) {

        String url = PropertiesProvider.getProperty("url");
        driver = new DriverProvider().createDriver(browser);

        try {
            ScreenSize screenSize = ScreenProvider.getScreenSize(SCREEN);
            driver.manage().window().setSize(new Dimension(screenSize.getWidth(), screenSize.getHeight()));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.navigate().to(url);
    }
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
