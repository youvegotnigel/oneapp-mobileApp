package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
