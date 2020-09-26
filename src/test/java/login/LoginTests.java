package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Project Name    : second_appium_test
 * Developer       : youvegotnigel
 * Version         : 1.0.1
 * Date            : 09/26/2020
 * Time            : 12:55 PM
 * Description     : Add new class
 **/

public class LoginTests extends BaseTests {


    @Test(priority=1)
    public void verifyInvalidToken(){
        tokenPage.setToken("mobile123");
        tokenPage.clickContinue();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        System.out.println("1.Error msg: " + tokenPage.getErrorMessage());
        Assert.assertEquals(tokenPage.getErrorMessage(),"Activation failed. Please check whether you have entered correct token or contact you system administrator","Invalid token entered");
    }

    @Test(priority=2)
    public void verifyEmptyUsernameAndPassword(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        tokenPage.setToken("mobile");
        tokenPage.clickContinue();

        LoginPage login = tokenPage.goToLoginPage();
        Assert.assertEquals(login.getPageHeaderName(),"Member Login","Verify landing page");

        login.setUsername("");
        login.setPassword("");
        login.clickLoginBtn();

        System.out.println("2.Error msg: " + login.getErrorMessageForEmptyUN());
        Assert.assertEquals(login.getErrorMessageForEmptyUN(),"Username is required","Username is empty");
        Assert.assertEquals(login.getErrorMessageForEmptyPW(),"Password is required","Password is empty");
    }

    @Test(priority=3)
    public void verifyEmptyUsername(){

        //tokenPage.setToken("mobile");
        //tokenPage.clickContinue();

        LoginPage login = tokenPage.goToLoginPage();
        Assert.assertEquals(login.getPageHeaderName(),"Member Login","Verify landing page");

        login.setUsername("");
        login.setPassword("zuno-86");
        login.clickLoginBtn();

        System.out.println("2.Error msg: " + login.getErrorMessageForEmptyUN());
        Assert.assertEquals(login.getErrorMessageForEmptyUN(),"Username is required","Username is empty");
    }

    @Test(priority=3)
    public void verifyEmptyPassword(){

        //tokenPage.setToken("mobile");
        //tokenPage.clickContinue();

        LoginPage login = tokenPage.goToLoginPage();
        Assert.assertEquals(login.getPageHeaderName(),"Member Login","Verify landing page");

        login.setUsername("ananta");
        login.setPassword("");
        login.clickLoginBtn();

        System.out.println("3.Error msg: " + login.getErrorMessageForEmptyUN());
        Assert.assertEquals(login.getErrorMessageForEmptyUN(),"Password is required","Password is empty");
    }

    @Test(priority=3)
    public void verifyInvalidCredentials(){

        //tokenPage.setToken("mobile");
        //tokenPage.clickContinue();

        LoginPage login = tokenPage.goToLoginPage();
        Assert.assertEquals(login.getPageHeaderName(),"Member Login","Verify landing page");

        login.setUsername("ananta-report");
        login.setPassword("abc-test");
        login.clickLoginBtn();

        System.out.println("4.Error msg: " + login.getErrorMessageForWrongCredentials());
        Assert.assertEquals(login.getErrorMessageForWrongCredentials(),"Error !! Invalid username or password.","Invalid Credentials Entered");

    }

    @Test(priority=4)
    public void verifySuccessfulLogin() {

        //tokenPage.setToken("mobile");
        //tokenPage.clickContinue();

        LoginPage login = tokenPage.goToLoginPage();
        Assert.assertEquals(login.getPageHeaderName(),"Member Login","Verify landing page");

        login.setUsername("ananta-reports");
        login.setPassword("zuno-86");
        login.clickLoginBtn();


    }


}
