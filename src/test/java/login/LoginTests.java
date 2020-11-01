package login;

import base.BaseTests;
import io.qameta.allure.Description;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import utills.AllureListener;

import java.util.concurrent.TimeUnit;

/**
 * @author  : youvegotnigel
 *
 */

@Listeners({AllureListener.class})
public class LoginTests extends BaseTests {


    @Test(priority=1, description="Verify invalid token entry")
    @Description("Verify invalid token entry")
    @Severity(SeverityLevel.MINOR)
    public void verifyInvalidToken() throws InterruptedException {

        tokenPage.setToken("mobile123");
        tokenPage.clickContinue();

        /**
         *  need to find a solution for the wait issues.
         *  element is found in debug mode but missed on the run.
         */
        //driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        //tokenPage.explicitWaitForErrorMessage();
        Thread.sleep(5000);

        //System.out.println("1.Error msg: " + tokenPage.getErrorMessage());
        Assert.assertEquals(tokenPage.getErrorMessage(),"Activation failed. Please check whether you have entered correct token or contact you system administrator","Invalid token entered");
    }

    @Test(priority=2, description="Verify invalid login")
    @Description("Verify invalid login")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyEmptyUsernameAndPassword() throws InterruptedException {

        tokenPage.setToken("mobile");
        tokenPage.clickContinue();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        LoginPage login = tokenPage.goToLoginPage();
        Assert.assertEquals(login.getPageHeaderName(),"Member Login","Verify landing page");

        login.setUsername("");
        login.setPassword("");
        login.clickLoginBtn();

        //System.out.println("2.Error msg: " + login.getErrorMessageForEmptyUN());
        Assert.assertEquals(login.getErrorMessageForEmptyUN(),"Username is required","Username is empty");
        Assert.assertEquals(login.getErrorMessageForEmptyPW(),"Password is required","Password is empty");
    }

    @Test(priority=3, description="Verify invalid login")
    @Description("Verify invalid login")
    @Severity(SeverityLevel.NORMAL)
    public void verifyEmptyUsername(){

        //tokenPage.setToken("mobile");
        //tokenPage.clickContinue();

        LoginPage login = tokenPage.goToLoginPage();
        Assert.assertEquals(login.getPageHeaderName(),"Member Login","Verify landing page");

        login.setUsername("");
        login.setPassword("zuno-86");
        login.clickLoginBtn();

        //System.out.println("2.Error msg: " + login.getErrorMessageForEmptyUN());
        Assert.assertEquals(login.getErrorMessageForEmptyUN(),"Username is required","Username is empty");
    }

    @Test(priority=3, description="Verify invalid login")
    @Description("Verify invalid login")
    @Severity(SeverityLevel.NORMAL)
    public void verifyEmptyPassword(){

        //tokenPage.setToken("mobile");
        //tokenPage.clickContinue();

        LoginPage login = tokenPage.goToLoginPage();
        Assert.assertEquals(login.getPageHeaderName(),"Member Login","Verify landing page");

        login.setUsername("ananta");
        login.setPassword("");
        login.clickLoginBtn();

        //System.out.println("3.Error msg: " + login.getErrorMessageForEmptyUN());
        Assert.assertEquals(login.getErrorMessageForEmptyUN(),"Password is required","Password is empty");
    }

    @Test(priority=3, description="Verify invalid login")
    @Description("Verify invalid login")
    @Severity(SeverityLevel.NORMAL)
    public void verifyInvalidCredentials(){

        //tokenPage.setToken("mobile");
        //tokenPage.clickContinue();

        LoginPage login = tokenPage.goToLoginPage();
        Assert.assertEquals(login.getPageHeaderName(),"Member Login","Verify landing page");

        login.setUsername("ananta-report");
        login.setPassword("abc-test");
        login.clickLoginBtn();

        //System.out.println("4.Error msg: " + login.getErrorMessageForWrongCredentials());
        Assert.assertEquals(login.getErrorMessageForWrongCredentials(),"Error !! Invalid username or password.","Invalid Credentials Entered");

    }

    @Test(priority=4, description="Verify valid login")
    @Description("Verify valid login")
    @Severity(SeverityLevel.BLOCKER)
    public void verifySuccessfulLogin(){

        //comment out the token entry part in the E2E test cycle
        //tokenPage.setToken("mobile");
        //tokenPage.clickContinue();

        LoginPage login = tokenPage.goToLoginPage();
        Assert.assertEquals(login.getPageHeaderName(),"Member Login","Verify landing page");

        login.setUsername("ananta-reports");
        login.setPassword("zuno86");
        login.clickLoginBtn();

        Assert.assertEquals(login.goToHomePage().getPageHeaderName(),"nFactory On the Go","Verify landing on homepage");

    }
}
