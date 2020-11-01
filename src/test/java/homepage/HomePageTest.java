package homepage;

import base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utills.AllureListener;

/**
 * @author  : youvegotnigel
 *
 */

@Listeners({AllureListener.class})
public class HomePageTest extends BaseTests {

    @Test(priority=1, description="Verify valid login")
    @Description("Verify valid login")
    @Severity(SeverityLevel.BLOCKER)
    public void verifySuccessfulLogin(){

        tokenPage.setToken("mobile");
        tokenPage.clickContinue();

        LoginPage login = tokenPage.goToLoginPage();
        Assert.assertEquals(login.getPageHeaderName(),"Member Login","Verify landing page");

        login.setUsername("ananta-reports");
        login.setPassword("zuno86");
        login.clickLoginBtn();

        Assert.assertEquals(login.goToHomePage().getPageHeaderName(),"nFactory On the Go","Verify landing on homepage");

    }

    @Test(priority=2, description="Verify the landing page after valid credentials")
    @Description("Verify the landing page after valid credentials")
    @Severity(SeverityLevel.NORMAL)
    public void verifyLandingPageName(){

        HomePage homepage = tokenPage.goToLoginPage().goToHomePage();
        Assert.assertEquals(homepage.getPageHeaderName(),"nFactory On the Go","Verify landing on homepage");
    }

    @Test(priority=2, description="Verify the date of the homepage")
    @Description("Verify the date of the homepage")
    @Severity(SeverityLevel.NORMAL)
    public void verifyHeaderDate(){

        HomePage homepage = tokenPage.goToLoginPage().goToHomePage();
        Assert.assertEquals(homepage.getPageDate(),"Sunday, November 1, 2020","Date is not correct");
    }

    @Test(priority=2, description="Verify the running PO's")
    @Description("Verify the running PO's")
    @Severity(SeverityLevel.NORMAL)
    public void verifyPO(){

        HomePage homepage = tokenPage.goToLoginPage().goToHomePage();
        Assert.assertEquals(homepage.getRunningPO(),"Running PO(s)","Running PO's not correct");
    }

    @Test(priority=2, description="Verify the workforce")
    @Description("Verify the Verify the workforce")
    @Severity(SeverityLevel.NORMAL)
    public void verifyWorkForce(){

        HomePage homepage = tokenPage.goToLoginPage().goToHomePage();
        Assert.assertEquals(homepage.getWorkForce(),"Work Force","WorkForce is not correct");
    }

    @Test(priority=3, description="Verify what is happening section text views")
    @Description("Verify what is happening section text views")
    @Severity(SeverityLevel.MINOR)
    public void verifyFactoryButtonText(){

        HomePage homepage = tokenPage.goToLoginPage().goToHomePage();
        Assert.assertEquals(homepage.getFactoryButtonText(),"FACTORY","Text is invalid");
    }

    @Test(priority=3, description="Verify what is happening section text views")
    @Description("Verify what is happening section text views")
    @Severity(SeverityLevel.MINOR)
    public void verifyDeliveryButtonText(){

        HomePage homepage = tokenPage.goToLoginPage().goToHomePage();
        Assert.assertEquals(homepage.getDeliveryButtonText(),"DELIVERY","Text is invalid");
    }

    @Test(priority=3, description="Verify what is happening section text views")
    @Description("Verify what is happening section text views")
    @Severity(SeverityLevel.MINOR)
    public void verifyQualityButtonText(){

        HomePage homepage = tokenPage.goToLoginPage().goToHomePage();
        Assert.assertEquals(homepage.getQualityButtonText(),"QUALITY","Text is invalid");
    }

    @Test(priority=3, description="Verify what is happening section text views")
    @Description("Verify what is happening section text views")
    @Severity(SeverityLevel.MINOR)
    public void verifyInsightButtonText(){

        HomePage homepage = tokenPage.goToLoginPage().goToHomePage();
        Assert.assertEquals(homepage.getInsightButtonText(),"INSIGHT","Text is invalid");
    }


}
