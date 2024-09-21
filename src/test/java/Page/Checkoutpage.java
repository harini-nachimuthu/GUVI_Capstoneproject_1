package Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.base;

public class Checkoutpage extends base{
  
	@FindBy(xpath="//button[.='Brands']")
	WebElement brandinmenu;
	
	@FindBy(xpath="//a[.='LG']")
	WebElement lginbrand;
	
	@FindBy(xpath="//a[.='Headphones']")
	WebElement lginheadphones;
	
	@FindBy(xpath="//a[.='All LG Headphones']")
	WebElement alllgheadphone;
	
	//Checkoutpage constructor
	public Checkoutpage(WebDriver driver) {
		this.driver=driver;
		this.js = (JavascriptExecutor) driver; 
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	//method to click lg brand what product reuired
	public Checkoutpage lgbrandclick() {
		clickbtn(brandinmenu);
		clickbtn(lginbrand);
		clickbtn(lginheadphones);
		clickbtn(alllgheadphone);
		return this;
	}
	
	@FindBy(xpath="//a[.='Go to Cart']")
	WebElement gotocart;
	
	@FindBy(xpath="//button[.='Checkout']")
	WebElement checkout;
	
	@FindBy(xpath="//span//strong[.='This item is no longer available for shipping.']")
	WebElement nolonger;
	
	@FindBy(xpath="//button[.='Remove']")
	WebElement remove;
	
	@FindBy(xpath="//button[.='Continue as Guest']")
	WebElement guest;
	
	@FindBy(id="user.emailAddress")
	WebElement emailid;
	
	@FindBy(id="user.phone")
	WebElement phonenumber;
	
	@FindBy(xpath="//input[@id=\"text-updates\"]")
	WebElement myordercheckbox;
	
	@FindBy(xpath="//span[.='Continue to Payment Information']")
	WebElement continuetopay;
	
	@FindBy(id="number")
	WebElement cardnumber;
	
	@FindBy(id="expirationDate")
	WebElement expirydate;
	
	@FindBy(id="cvv")
	WebElement cvvsecuritycode;
	
	@FindBy(id="first-name")
	WebElement firstname;
	
	@FindBy(id="last-name")
	WebElement lastname;
	
	@FindBy(id="address-input")
	WebElement address;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(xpath="//select[@id='state']")
	WebElement selectcountry;
	
	@FindBy(id="postalCode")
	WebElement zipcode;
	
	@FindBy(xpath="//span[.='Place Your Order']")
	WebElement placeurorder;
	
	@FindBy(xpath="//button[.='Keep Address as Entered']")
	WebElement keepdata;
	
	@FindBy(xpath="//div[@class=\"c-alert-content rounded-r-100 flex-fill v-bg-pure-white p-200 pl-none\"]")
	WebElement finaal;
	
	//After adding products to cart method to do final checkout(payment)section
	public Checkoutpage checkoutproduct() throws InterruptedException {
		xpathvisibleclick(gotocart);
		Thread.sleep(2000);
		xpathvisibleclick(checkout);
		if(wait.until(ExpectedConditions.visibilityOf(nolonger)) != null) {
			System.out.println(nolonger.getText());
			clickbtn(remove);
			driver.quit();
		}else {
			xpathvisibleclick(guest);
			
			idsendkeys(emailid,"arun@gmail.com");
			idsendkeys(phonenumber,"6789012353");
			
			xpathvisibleclick(myordercheckbox);
			xpathvisibleclick(continuetopay);
			
			idsendkeys(cardnumber,"4311 7800 0024 1417");
			idsendkeys(expirydate,"05/27");
			idsendkeys(cvvsecuritycode,"417");
			idsendkeys(firstname,"Arun8");
			idsendkeys(lastname,"K");
			idsendkeys(address,"No:1 Main city");
			idsendkeys(city,"Mumbai");
			
			Select select=new Select(selectcountry);
			select.selectByVisibleText("IN");
			
			idsendkeys(zipcode,"400001");
			clickbtn(placeurorder);
			if(wait.until(ExpectedConditions.visibilityOf(keepdata)) != null) {
				clickbtn(keepdata);
			}else {
				clickbtn(placeurorder);
			}
			
			if(wait.until(ExpectedConditions.visibilityOf(finaal)) != null) {
				System.out.println("There is issue in webpage");
				driver.quit();
			}
		}
		return this;
	}
	
	
	
}

//4311 7800 0024 1417   05/27   417
