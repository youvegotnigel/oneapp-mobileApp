package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Project Name    : second_appium_test
 * Developer       : youvegotnigel
 * Version         : 1.0.1
 * Date            : 09/26/2020
 * Time            : 12:55 PM
 * Description     : Add new class
 **/

public class TokenPage {

    //define elements
    private WebDriver driver;
    private By tokenTextBox = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.view.View/android.widget.EditText");
    private By continueButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.Button");
    private By errorMessage = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[5]");

    //constructor
    public TokenPage(WebDriver driver) {
        this.driver = driver;
    }

    //input token for installation
    public void setToken(String token) throws InterruptedException {
        Thread.sleep(15000);
        driver.findElement(tokenTextBox).sendKeys(token);
    }

    //click on the continue button
    public void clickContinue(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(continueButton).click();
    }

    //explicit wait
    public void explicitWaitForErrorMessage(){

        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(errorMessage));
    }

    //error message for invalid token entry
    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }

    //pass the driver for the next page
    public LoginPage goToLoginPage() {
        return new LoginPage(driver);
    }

}
