package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Base.base;

public class Loginpage extends base{
  
	//Loginpage constructor
	public Loginpage(WebDriver driver) {
		this.driver=driver;
		this.js = (JavascriptExecutor) driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[normalize-space()='Sign In']")
	WebElement signinbtn;
	
	//Click button for login
	public Loginpage siginbtn() {
		clickbtn(signinbtn);
		return this;
	}
	
	@FindBy(id="fld-e")
	WebElement emailid;
	
	@FindBy(id="fld-p1")
	WebElement password;
	
	@FindBy(xpath="//button[.='Sign In']")
	WebElement submit;
	
	//Method to fill login details
	public Loginpage logindetails(String email,String password) {
		webwait("fld-e",email);
		webwait("fld-p1",password);
		clickbtn(submit);
		return this;
	}
			
}
