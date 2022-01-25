package org.laserhub.resources;

import org.apache.commons.io.FileUtils;
import org.laserhub.pageobject.BasePageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public Properties prop;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    private BasePageObject basePageObject;


    public WebDriver getDriver(){
        return this.driver;
    }

    @BeforeSuite
    public void setup() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        basePageObject = new BasePageObject(driver);
        basePageObject.isCookieBannerDisplayed();
        basePageObject.clickOnAcceptCookieBanner();
    }


    public WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "//src//main//java//org//laserhub//resources//data.properties");

        prop.load(fis);
        String browserName = prop.getProperty("browser");
        System.out.println(browserName);

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//chrome//chromedriver");

            driver = new ChromeDriver();

        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equals("IE")) {
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }


    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "//reports//" + testCaseName + timestamp + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;

    }
}
