package homepage;

import base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

/**
 * @author  : youvegotnigel
 *
 */

public class HomePageTest extends BaseTests {

    @Test(priority=1, description="Verify the landing page after valid credentials")
    @Description("Verify the landing page after valid credentials")
    @Severity(SeverityLevel.NORMAL)
    public void verifyLandingPageName() throws InterruptedException {

        LoginPage homepage = tokenPage.goToLoginPage();
        Assert.assertEquals(homepage.getPageHeaderName(),"nFactory On the Go","Verify landing on homepage");
    }


}
