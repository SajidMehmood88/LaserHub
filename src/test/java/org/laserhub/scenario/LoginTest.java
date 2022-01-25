package org.laserhub.scenario;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.laserhub.pageobject.ChooseAccountPage;
import org.laserhub.pageobject.LoginPage;
import org.laserhub.resources.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends BaseTest {

    public static Logger log = LogManager.getLogger(BaseTest.class.getName());

    private LoginPage loginPage;
    private ChooseAccountPage chooseAccountPage;
    public WebDriver driver;


    @BeforeClass
    public void initialize() {
        driver = getDriver();
        loginPage = new LoginPage(driver);
        chooseAccountPage = new ChooseAccountPage(driver);
        driver.get("https://app.laserhub.com/login");
    }

    @Test(dataProvider = "validCredentials")
    public void validLogin(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickOnSubmitButton();
        chooseAccountPage.isCompanyChoosePageDisplayed();
        String expectedUrl = "https://app.laserhub.com/register/company-choosee";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        log.info("Successfully logs in");
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }

    @DataProvider
    public Object[][] validCredentials() {
        Object[][] account = new Object[1][2];
        account[0][0] = "e.ioannidis+testing_worktask@laserhub.com";
        account[0][1] = "l0vet3sting@";
        return account;
    }


}
