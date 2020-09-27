package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Project Name    : second_appium_test
 * Developer       : youvegotnigel
 * Version         : 1.0.1
 * Date            : 09/26/2020
 * Time            : 12:55 PM
 * Description     : Add new class
 **/

public class HomePage {

    //define elements
    private WebDriver driver;
    private By pageHeaderName = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View");

    //constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //get the name of the page header
    public String getPageHeaderName(){
        return driver.findElement(pageHeaderName).getText();
    }
}
