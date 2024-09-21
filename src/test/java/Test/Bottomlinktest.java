package Test;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.base;
import Page.Bottomlinkpage;
import Page.Topmenupage;

public class Bottomlinktest extends base {
	
	//Before execution of test this method get excel file name and sheet name from that datas will read out.(Data Driven testing)
	@BeforeTest
    public void beforetest() {
        excelsheet = "Capstone1";
        sheetname = "Bottomlinks";
     }
	
	@Test(dataProvider = "Readingdatasfromexcelsheet",priority=5,groups = {"regression"},description = "Bottom buttons in url test")
	  public void bottommenu(String xpath,String expected) throws InterruptedException {
		handleCountrySelection(country);
		Bottomlinkpage bottom=new Bottomlinkpage(driver);
		bottom.bottomlinks(xpath, expected);
	  }
}
