package Test;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.base;
import Page.Loginpage;
import Page.Signuppage;

public class LoginTest extends base{
	
	//Before execution of test this method get excel file name and sheet name from that datas will read out.(Data Driven testing)
	@BeforeTest
    public void beforetest() {
        excelsheet = "Capstone1";
        sheetname = "Login";
    }
	
  @Test(dataProvider = "Readingdatasfromexcelsheet",priority=3,groups = {"regression"},description = "Login test")
  public void logintest(String email1,String password1,String xpath1,String expectedtext1) {
	  handleCountrySelection(country);
	  Signuppage sign1=new Signuppage(driver);
	  Loginpage login1=new Loginpage(driver);
	  sign1.accountbtn();
	  login1.siginbtn()
	  		.logindetails(email1, password1);
	  actandexpec(xpath1,expectedtext1);
	  driver.get(url); 
	  
  }
  
  
}
