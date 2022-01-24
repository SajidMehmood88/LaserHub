package org.laserhub.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePageObject {

    public WebDriver driver;

    By cookieBanner = By.cssSelector("[id='onetrust-button-group']");
    By acceptCookieBannerButton = By.cssSelector("[id='onetrust-accept-btn-handler']");


    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCookieBanner(){
        return driver.findElement(cookieBanner);
    }

    public void clickOnAcceptCookieBanner(){
        driver.findElement(acceptCookieBannerButton).click();
    }

    public boolean isCookieBannerDisplayed() {
        try {
            return driver.findElement(cookieBanner).isDisplayed();
        } catch (NoSuchElementException ignored) { }
        return false;
    }
}
