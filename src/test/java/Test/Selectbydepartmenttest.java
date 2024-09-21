package Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.base;
import Page.Searchbtnandcartpage;
import Page.Selectbydepartmentpage;

public class Selectbydepartmenttest extends base {
	

    @Test(priority=7,groups = {"regression"},description = "Searching product through department and adding them to cart")
    public void addtocart() throws InterruptedException {
    	handleCountrySelection(country);
    	Selectbydepartmentpage searchdepart = new Selectbydepartmentpage(driver);
        searchdepart.selectbydepartment();
        Searchbtnandcartpage search = new Searchbtnandcartpage(driver);
        search.homehealth(); 
    }
}
