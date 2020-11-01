package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @author  : youvegotnigel
 *
 */

public class LoginPage {

    //define elements
    private WebDriver driver;
    private By pageHeaderName = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]");
    private By username = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.widget.EditText[1]");
    private By password = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.widget.EditText[2]");
    private By loginButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.widget.Button");
    private By errMessageForEmptyUN = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View[1]");
    private By errMessageForEmptyPW = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View[2]");
    private By errMessageForInvalidCredentials = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[4]");

    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //set the username
    public void setUsername(String uname){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(username).sendKeys(uname);
    }

    //set the password
    public void setPassword(String pword){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(password).sendKeys(pword);
    }

    //get the name of the page header
    public String getPageHeaderName(){
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(pageHeaderName));
        return driver.findElement(pageHeaderName).getText();
    }

    //error message for username filed empty
    public String getErrorMessageForEmptyUN(){
        return driver.findElement(errMessageForEmptyUN).getText();
    }

    //error message for password filed empty
    public String getErrorMessageForEmptyPW(){
        return driver.findElement(errMessageForEmptyPW).getText();
    }

    //error message for incorrect credentials
    public String getErrorMessageForWrongCredentials(){
        return driver.findElement(errMessageForInvalidCredentials).getText();
    }

    //click the login button
    public void clickLoginBtn(){
        driver.findElement(loginButton).click();
    }

    //pass the driver for the next page
    public HomePage goToLoginPage() {
        return new HomePage(driver);
    }
}
