package com.core.providers;

import com.core.exceptions.WrongScreenSizeException;
import com.core.models.enums.ScreenSize;
import io.github.bonigarcia.wdm.WebDriverManager;
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

public class DriverProvider {
    String browser = System.getProperty("browser", String.valueOf(Browser.CHROME));

    public WebDriver createDriver(){
        if (browser.equals(Browser.EDGE.browserName())) {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        } else if (browser.equals(Browser.FIREFOX.browserName())) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (browser.equals(Browser.SAFARI.browserName())) {
            WebDriverManager.safaridriver().setup();
            return new SafariDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    }
}
