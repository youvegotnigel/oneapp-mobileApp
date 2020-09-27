package base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.TokenPage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Project Name    : second_appium_test
 * Developer       : youvegotnigel
 * Version         : 1.0.0
 * Date            : 09/08/2020
 * Time            : 10:55 AM
 * Description     :
 **/


public class BaseTests {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    public TokenPage tokenPage;

    @BeforeClass
    public void setup() throws MalformedURLException {
        String PROJECT_ROOT = System.getProperty("user.dir");
        String ANDROID_APK_PATH = "/src/test/resources/app-debug-qa.apk";

        DesiredCapabilities caps = new DesiredCapabilities();
        //Virtual Device
        caps.setCapability("deviceName", "Pixel 2");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11");

        //Real Device
//        caps.setCapability("deviceName", "Samsung");
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("platformVersion", "10.0.0");

        caps.setCapability("app", new File(PROJECT_ROOT + ANDROID_APK_PATH).getAbsolutePath());
        caps.setCapability("appPackage", "com.ncinga.nfactory.on.the.go.mobile");
        caps.setCapability("appActivity", "com.ncinga.nfactory.on.the.go.mobile.MainActivity");
        caps.setCapability("noReset", false);
        caps.setCapability("fullReset", false);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver<MobileElement>(url, caps);
        wait = new WebDriverWait(driver, 10);

        goHome();
    }

    @BeforeMethod
    public void goHome(){
        tokenPage = new TokenPage(driver);
    }


    @AfterClass
    public void teardown() {
        driver.quit();
    }

}
