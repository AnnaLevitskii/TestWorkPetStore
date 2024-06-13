package com.core.providers;

import com.core.exceptions.WrongScreenSizeException;
import com.core.models.enums.ScreenSize;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.DesiredCapabilities.*;

public class DriverProvider {
    //String browser = System.getProperty("browser", String.valueOf(Browser.CHROME));
    String grid = System.getProperty("grid", null);
    @Parameters("browser")
    public WebDriver createDriver(String browser){
        if (grid != null){
            URL hubUrl = null;
            try {
                hubUrl = new URL("http://localhost:4444");
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            DesiredCapabilities capabilities = new DesiredCapabilities();
            if (browser.equals(Browser.EDGE.browserName())) {
                EdgeOptions options = new EdgeOptions();
                return new RemoteWebDriver(hubUrl, options);
            } else if (browser.equals(Browser.FIREFOX.browserName())) {
                FirefoxOptions options = new FirefoxOptions();
                return new RemoteWebDriver(hubUrl, options);
//                capabilities.setBrowserName(Browser.FIREFOX.browserName());
//                return new RemoteWebDriver(hubUrl, capabilities);
            } else if (browser.equals(Browser.SAFARI.browserName())) {
                SafariOptions options = new SafariOptions();
                return new RemoteWebDriver(hubUrl, options);
            } else {
                capabilities.setBrowserName(Browser.CHROME.browserName());
//                ChromeOptions options = new ChromeOptions();
//                return new RemoteWebDriver(hubUrl, options);
                return new RemoteWebDriver(hubUrl, capabilities);
            }
        }else {
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
}
