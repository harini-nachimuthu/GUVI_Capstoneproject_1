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
import Page.Signuppage;

public class Signuptest extends base {
	
	//Before execution of test this method get excel file name and sheet name from that datas will read out.(Data Driven testing)
	@BeforeTest
    public void beforetest() {
        excelsheet = "Capstone1";
        sheetname = "Signup";  
    }

    @Test(dataProvider = "Readingdatasfromexcelsheet",priority=2,groups = {"regression"},description = "Signup Test")
    public void signup(String first, String last, String email, String fpass, String rpass, String phone, String xpath, String expectedtext) throws InterruptedException {
    	handleCountrySelection(country);
    	Signuppage sign = new Signuppage(driver);
        sign.accountbtn();
        sign.createbtn();
        sign.signupdata(first, last, email, fpass, rpass, phone);
        actandexpec(xpath,expectedtext);
//        driver.get(url);
    }

    
}
