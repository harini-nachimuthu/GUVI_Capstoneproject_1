package Test;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.base;
import Page.Loginpage;
import Page.Signuppage;
import Page.Topmenupage;

public class Topmenutest extends base{
	
	//Before execution of test this method get excel file name and sheet name from that datas will read out.(Data Driven testing)
	@BeforeTest   
	public void beforetest() {
        excelsheet = "Capstone1";
        sheetname = "Topmenu";
     }
	
	@Test(dataProvider = "Readingdatasfromexcelsheet",priority=4,groups = {"regression"},description = "Top buttons in url check")
	  public void tomenu(String xpath,String expected) throws InterruptedException {
		handleCountrySelection(country);
		Topmenupage top=new Topmenupage(driver);
//		top.morebtncheck(xpath,expected);
		 top.elementselect(xpath,expected); 
//		 driver.get(url);
	  }
	  
	  
}
