package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author  : youvegotnigel
 *
 */

public class HomePage {

    //define elements
    private WebDriver driver;
    WebDriverWait wait;

    //Top part elements
    private By sideMenu = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.Button");
    private By pageHeaderName = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View");
    private By date = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]");
    private By runningPOs = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View[2]");
    private By workForce = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[3]/android.view.View[2]");

    //Date pop-up section
    private By popUpDate = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[1]");
    private By yearDropDown = By.xpath("");
    private By monthDropDown = By.xpath("");
    private By leftArrow = By.xpath("");
    private By rightArrow = By.xpath("");
    private By saveBtn = By.xpath("");
    private By todayBtn = By.xpath("");


    //What is happening section
    private By factoryBtn =  By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[5]/android.widget.Button");
    private By deliveryBtn = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[6]/android.widget.Button");
    private By qualityBtn =  By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[7]/android.widget.Button");
    private By insightBtn =  By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[8]/android.widget.Button");

    //Departments section
    private By sewingDepBtn =    By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[9]/android.view.View/android.view.View[1]");
    private By finishingDepBtn = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[9]/android.view.View/android.view.View[2]");


    //constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //get the name of the page header
    public String getPageHeaderName(){

        wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(pageHeaderName));
        return driver.findElement(pageHeaderName).getText();
    }

    public String getPageDate(){

        wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(date));
        return driver.findElement(date).getText();
    }

    public String getRunningPO(){

        wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(runningPOs));
        return driver.findElement(runningPOs).getText();
    }

    public String getWorkForce(){

        wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(workForce));
        return driver.findElement(workForce).getText();
    }

    public String getFactoryButtonText(){

        wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(factoryBtn));
        return driver.findElement(factoryBtn).getText();
    }

    public String getDeliveryButtonText(){

        wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(deliveryBtn));
        return driver.findElement(deliveryBtn).getText();
    }

    public String getQualityButtonText(){

        wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(qualityBtn));
        return driver.findElement(qualityBtn).getText();
    }

    public String getInsightButtonText(){

        wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(insightBtn));
        return driver.findElement(insightBtn).getText();
    }

    public String getSewingDepartmentButtonText(){

        wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(sewingDepBtn));
        return driver.findElement(sewingDepBtn).getText();
    }

    public String getFinishingDepartmentButtonText(){

        wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(finishingDepBtn));
        return driver.findElement(finishingDepBtn).getText();
    }
}
