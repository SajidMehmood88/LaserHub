package org.laserhub.pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;

    By submitButton = By.cssSelector("[type='submit']");
    By emailField = By.cssSelector("[id='email']");
    By passwordField = By.cssSelector("[id='password']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickOnSubmitButton(){
        driver.findElement(submitButton).click();
    }

    public WebElement getEmailField(){
        return driver.findElement(emailField);
    }

}
