package base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
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
 * @author  : youvegotnigel
 *
 */

public class BaseTests {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    //create a thread driver
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

    public TokenPage tokenPage;

    @BeforeClass
    public WebDriver setup() throws MalformedURLException {
        String PROJECT_ROOT = System.getProperty("user.dir");
        String ANDROID_APK_PATH = "/src/test/resources/app-debug-qa.apk";

        DesiredCapabilities caps = new DesiredCapabilities();
        //Virtual Device
//        caps.setCapability("deviceName", "Pixel 2");
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("platformVersion", "11");

        //Real Device
        caps.setCapability("deviceName", "Samsung");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10.0.0");

        caps.setCapability("app", new File(PROJECT_ROOT + ANDROID_APK_PATH).getAbsolutePath());
        caps.setCapability("appPackage", "com.ncinga.nfactory.on.the.go.mobile");
        caps.setCapability("appActivity", "com.ncinga.nfactory.on.the.go.mobile.MainActivity");
        caps.setCapability("noReset", false);
        caps.setCapability("fullReset", false);

        caps.setCapability("isHeadless", true);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver<MobileElement>(url, caps);
        wait = new WebDriverWait(driver, 10);

        tokenPage = new TokenPage(driver);

        //initialize the driver to create a tread
        tdriver.set(driver);
        return getDriver();
    }

//    @BeforeMethod
//    public void goHome(){
//        tokenPage = new TokenPage(driver);
//    }


    @AfterClass
    public void teardown() {
        driver.quit();
    }


    //pass the driver in thread
    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }

}
