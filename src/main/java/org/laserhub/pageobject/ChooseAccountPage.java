package org.laserhub.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChooseAccountPage {

    public WebDriver driver;

    By registerPage = By.cssSelector("[class='registration-page__wrap']");

    public ChooseAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean isCompanyChoosePageDisplayed(){
        return driver.findElement(registerPage).isDisplayed();
    }
}
