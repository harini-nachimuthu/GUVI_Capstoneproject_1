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

public class Signuppage extends base {
	
  @FindBy(xpath="//span[.='Account']")
  WebElement accounthome;
  
  //Signuppage constructor
  public Signuppage(WebDriver driver) {
	this.driver=driver;
	this.js = (JavascriptExecutor) driver; 
	PageFactory.initElements(driver, this);
}

  //click button to click account
public Signuppage accountbtn() {
	  clickbtn(accounthome);
	  return this;
  }
  
  @FindBy(xpath="//a[.='Create Account']")
  WebElement accountcreate;
  
  //click button to click create
  public Signuppage createbtn() {
	  clickbtn(accountcreate);
	  return this;
  }
  
  @FindBy(id="firstName")
  WebElement firstname;
  
  @FindBy(id="lastName")
  WebElement lastName;
  
  @FindBy(id="email")
  WebElement email;
  
  @FindBy(id="fld-p1")
  WebElement fldp1;
  
  @FindBy(id="reenterPassword")
  WebElement reenterPassword;
  
  @FindBy(id="phone")
  WebElement phone;
  
  @FindBy(id="is-recovery-phone")
  WebElement isrecoveryphone;
  
  //Method to fill required details for signup
  public Signuppage signupdata(String first,String last,String email,String fpass,String rpass,String phone) throws InterruptedException {
	  webwait("firstName",first);
	  webwait("lastName",last);
	  webwait("email",email);
	  webwait("fld-p1",fpass);
	  webwait("reenterPassword",rpass);
	  webwait("phone",phone);
	  clickbtn(isrecoveryphone);
	  clickbtn(Submit);
	  Thread.sleep(1000);
	  
	  return this;
  }
  
  @FindBy(xpath="//button[@type='submit']")
  WebElement Submit;
  
  @FindBy(id="//*[text()='Sign Up with Google']")
  WebElement googleSignUp;
  
}
