package homepage;

import base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

/**
 * Project Name    : second_appium_test
 * Developer       : youvegotnigel
 * Version         : 1.0.1
 * Date            : 09/27/2020
 * Time            : 08:55 PM
 * Description     : Add new class
 **/

public class HomePageTest extends BaseTests {

    @Test(priority=1, description="Verify the landing page after valid credentials")
    @Description("Verify the landing page after valid credentials")
    @Severity(SeverityLevel.NORMAL)
    public void verifyLandingPageName(){

    }


}
