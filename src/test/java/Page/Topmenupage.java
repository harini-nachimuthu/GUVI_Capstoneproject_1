package Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.base;

public class Topmenupage extends base {
    @FindBy(xpath = "//a[normalize-space()='Best Buy Outlet']")
    WebElement outlet;

    @FindBy(xpath = "//a[@class='universal-nav-link'][normalize-space()='Best Buy Business']")
    WebElement business;

    @FindBy(xpath = "//a[@class='universal-nav-link'][normalize-space()='Shop with an Expert']")
    WebElement expert;

    @FindBy(xpath = "//span[@class='cart-label']")
    WebElement cart;

    @FindBy(xpath = "//a[normalize-space()='Top Deals']")
    WebElement topdeals;

    @FindBy(xpath = "//a[normalize-space()='Deal of the Day']")
    WebElement deals;

    @FindBy(xpath = "//a[normalize-space()='Yes, Best Buy Sells That']")
    WebElement sells;

    @FindBy(xpath = "(//button[@class='c-button-unstyled plButton d-flex justify-content-center align-items-center'])[1]")
    WebElement more;

    @FindBy(xpath = "(//a[@class='bottom-left-links '][normalize-space()='My Best Buy Memberships'])[1]")
    WebElement membership;

    @FindBy(xpath = "//a[@class='utility-menu-flyout-list-item'][normalize-space()='Credit Cards']")
    WebElement creditcard;

    @FindBy(xpath = "//a[@class='utility-menu-flyout-list-item'][normalize-space()='Gift Cards']")
    WebElement giftcards;

    @FindBy(xpath = "//a[@class='utility-menu-flyout-list-item'][normalize-space()='Gift Ideas']")
    WebElement giftideas;

   //Topmenupage constructor
    public Topmenupage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver; 
        PageFactory.initElements(driver, this);
         wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
    }
   
    //Checking top menubutton available or not and clicking them to check title matches the expected title
    public Topmenupage elementselect(String xpath, String expected) throws InterruptedException {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            if (element != null) {
            	Thread.sleep(3000);
                webwaitxpath(xpath);
                String actual = driver.getTitle();
                if(actual.equals(expected)) {
                    System.out.println("Actual heading is matching Expected heading and the heading is : " + actual);
                } else {
                    System.out.println("Actual heading is not matching Expected heading. Actual: " + actual + ", Expected: " + expected);
                }
                Assert.assertEquals(actual, expected);
            }
        } catch (Exception e) {
//          System.out.println("Element not visible, performing click on 'more' button.");
//        	Thread.sleep(5000);
            clickbtn(more);
            Thread.sleep(3000);
            webwaitxpath(xpath);
            String actual = driver.getTitle();
            if(actual.equals(expected)) {
                System.out.println("Actual heading is matching Expected heading and the heading is : " + actual);
            } else {
                System.out.println("Actual heading is not matching Expected heading. Actual: " + actual + ", Expected: " + expected);
            }
            Assert.assertEquals(actual, expected);
        }
        return this;
    }

}
