package Page;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.base;

public class Searchbtnandcartpage extends base {
	
	  @FindBy(xpath="//input[@id='gh-search-input']")
	  WebElement searchbutton;
	  
	  @FindBy(xpath="//span[.='Added to cart']")
	  WebElement addedtocart;
	  
	  //Searchbtnandcartpage constructor
	  public Searchbtnandcartpage(WebDriver driver) {
		this.driver=driver;
		this.js = (JavascriptExecutor) driver; 
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	  }

	  @FindBy(xpath="//span[contains(text(),'Lenovo - Yoga Slim 7x - Copilot+ PC - 14.5\" 3K OLE')]")
	  WebElement lenevolaptop;
	  
	  @FindBy(xpath="//button[@class='c-button c-button-primary c-button-lg c-button-block c-button-icon c-button-icon-leading add-to-cart-button ']")
	  WebElement lenevolaptopaddtocart;
	  
	  //Method search product and select product add them to cart
	  public  Searchbtnandcartpage lenevolaptop() throws InterruptedException {
		  xpathandsendkeys("//input[@id='gh-search-input']","lenovo");
		  xpathvisibleclick(lenevolaptop);
		  Thread.sleep(500);
		  String pagetitle=driver.getTitle();
		  System.out.println("Title of the page is : "+pagetitle);
		  clickbtn(lenevolaptopaddtocart);
		  Thread.sleep(500);
		  boolean check=xpathvisible(addedtocart);
		  if(check) {
			  System.out.println("Added to cart : "+"Lenovo");
		  }else {
			  String text=xpathvisibletext(addedtocart);
			  System.out.println("Failed and Text present there is :"+text);
		  }
		  driver.get(url);
		  return this;		
	  }
	  
	  @FindBy(xpath="//a[.='Sony - 65\" Class BRAVIA XR A80L OLED 4K UHD Smart Google TV (2023)']")
	  WebElement SonyTV;
	  
	  @FindBy(xpath="(//button[@class='c-button c-button-primary c-button-lg c-button-block c-button-icon c-button-icon-leading add-to-cart-button '])[1]")
			  
//	  "//button[@class='c-button c-button-primary c-button-lg c-button-block c-button-icon c-button-icon-leading add-to-cart-button ']")
	  WebElement TVaddtocart;
	  
	  //method to select tv informed and add to cart
	  public Searchbtnandcartpage TV() throws InterruptedException {
//		  xpathandsendkeys("//input[@id='gh-search-input']","TV");
		  xpathvisibleclick(SonyTV);
		  Thread.sleep(500);
		  String pagetitle=driver.getTitle();
		  System.out.println("Title of the page is : "+pagetitle);
		  actionbtnclick(TVaddtocart);
		  Thread.sleep(500);
		  boolean check=xpathvisible(addedtocart);
		  if(check) {
			  System.out.println("Added to cart : TV");
		  }else {
			  String text=xpathvisibletext(addedtocart);
			  System.out.println("Failed and Text present there is :"+text);
		  }
//		  driver.get(url);
		  return this;
	  }
	  
	  @FindBy(xpath="//a[.='Omron - 3 Series - Automatic Upper Arm Blood Pressure Monitor - Black/White']")
	  WebElement omron;
	  
	  @FindBy(xpath="//button[@class='c-button c-button-primary c-button-lg c-button-block c-button-icon c-button-icon-leading add-to-cart-button ']")
	  WebElement omronaddtocart;
	  
	  //method to select omron informed and add to cart
	  public Searchbtnandcartpage homehealth() throws InterruptedException {
		  xpathvisibleclick(omron);
		  Thread.sleep(500);
		  String pagetitle=driver.getTitle();
		  System.out.println("Title of the page is : "+pagetitle);
		  clickbtn(omronaddtocart);
		  Thread.sleep(500);
		  boolean check=xpathvisible(addedtocart);
		  if(check) {
			  System.out.println("Added to cart : Omron BP machine");
		  }else {
			  String text=xpathvisibletext(addedtocart);
			  System.out.println("Failed and Text present there is :"+text);
		  }
		  driver.get(url);
		  return this;
	  }
	  
	  @FindBy(xpath="//a[.='LG - TONE Free Fit TF8Q True Wireless Noise Cancelling In-Ear Earbuds - Black']")
	  WebElement lgearpods;
	  
	  @FindBy(xpath="//button[@class='c-button c-button-primary c-button-lg c-button-block c-button-icon c-button-icon-leading add-to-cart-button ']")
	  WebElement lgaddtocart;
	  
	  //method to select lg earpods informed and add to cart
	  public Searchbtnandcartpage lgearpods() throws InterruptedException {
		  xpathvisibleclick(lgearpods);
		  Thread.sleep(500);
		  String pagetitle=driver.getTitle();
		  System.out.println("Title of the page is : "+pagetitle);
		  clickbtn(lgaddtocart);
		  Thread.sleep(500);
		  boolean check=xpathvisible(addedtocart);
		  if(check) {
			  System.out.println("Added to cart : LG earpods");
		  }else {
			  String text=xpathvisibletext(addedtocart);
			  System.out.println("Failed and Text present there is :"+text);
		  }
		  Thread.sleep(1000);
		  return this;
	  }
	  
	  
}
