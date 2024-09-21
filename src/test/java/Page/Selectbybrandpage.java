package Page;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.base;

public class Selectbybrandpage extends base{
  
	@FindBy(xpath="//button[.='TV & Home Theater']")
	WebElement tvhometheater;
	
	@FindBy(xpath="//button[.='TVs by Brand']")
	WebElement tvbybrand;
	
	@FindBy(xpath="//a[.='Sony TVs']")
	WebElement sonytv;
	
	//Selectbybrandpage constructor
	public Selectbybrandpage(WebDriver driver) {
		this.driver=driver;
		this.js = (JavascriptExecutor) driver; 
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	//method to select product by brand
	public Selectbybrandpage menubybrand() throws InterruptedException {
		clickbtn(tvhometheater);
		clickbtn(tvbybrand);
		clickbtn(sonytv);
		Thread.sleep(2000);
		return this;
	}
}
