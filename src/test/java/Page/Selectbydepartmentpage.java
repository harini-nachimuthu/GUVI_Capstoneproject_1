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

public class Selectbydepartmentpage extends base{
	
  @FindBy(xpath="//button[.='Menu']")
  WebElement menubtn;
  
  @FindBy(xpath="//button[.='Health, Wellness & Fitness']")
  WebElement healthinmenu;
  
  @FindBy(xpath="//button[.='Home Health Care']")
  WebElement homehealthinhealth;
  
  @FindBy(xpath="//a[.='Blood Pressure Monitors']")
  WebElement bpinhome;
  
  //Selectbydepartmentpage constructor
  public Selectbydepartmentpage(WebDriver driver) {
	this.driver=driver;
	this.js = (JavascriptExecutor) driver; 
	PageFactory.initElements(driver, this);
	wait = new WebDriverWait(driver, Duration.ofSeconds(60));
}

  //method to select product by department
  public  Selectbydepartmentpage selectbydepartment() throws InterruptedException {
	  clickbtn(menubtn);
	  clickbtn(healthinmenu);
	  clickbtn(homehealthinhealth);
	  clickbtn(bpinhome);
	  Thread.sleep(2000);
	  return this;
  }

  public Selectbydepartmentpage selectmenubtn() {
	  clickbtn(menubtn);
	  return this;
  }
}
