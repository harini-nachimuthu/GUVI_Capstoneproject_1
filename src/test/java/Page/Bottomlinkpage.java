package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.base;

public class Bottomlinkpage extends base{
  @FindBy(xpath="//a[normalize-space()='Accessibility']")
  WebElement accessibility;
  
  @FindBy(xpath="//a[normalize-space()='Terms & Conditions']")
  WebElement termsandcondition;
  
  @FindBy(xpath="//a[normalize-space()='Privacy']")
  WebElement privacy;
  
  @FindBy(xpath="//a[normalize-space()='Interest-Based Ads']")
  WebElement interest;
  
  @FindBy(xpath="//a[normalize-space()='State Privacy Rights']")
  WebElement stateprivacy;
  
  @FindBy(xpath="//a[normalize-space()='Health Data Privacy']")
  WebElement healthdata;
  
  @FindBy(xpath="//a[normalize-space()='Do Not Sell/Share My Personal Information']")
  WebElement sellshare;
  
  @FindBy(xpath="//a[normalize-space()='Limit Use of My Sensitive Personal Information']")
  WebElement personal;
  
  @FindBy(xpath="//a[normalize-space()='Targeted Advertising Opt Out']")
  WebElement target;
  
  @FindBy(xpath="//a[normalize-space()='CA Supply Chain Transparency Act']")		
  WebElement casupply;
  
  //Bottomlinkpage constructor
  public Bottomlinkpage(WebDriver driver) {
	this.driver=driver;
	this.js = (JavascriptExecutor) driver; 
	PageFactory.initElements(driver, this);
  }

  //Checking bottom menubutton available or not and clicking them to check title matches the expected title

  public Bottomlinkpage bottomlinks(String xpath,String expected) {
		webwaitxpath(xpath);
		String actual=driver.getTitle();
		if(actual.equals(expected)) {
            System.out.println("Actual heading is matching Expected heading and the heading is : " + actual);
        } else {
            System.out.println("Actual heading is not matching Expected heading. Actual: " + actual + ", Expected: " + expected);
        }
		Assert.assertEquals(actual, expected);
		return this;
  }
}
