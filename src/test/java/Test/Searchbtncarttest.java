package Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.base;
import Page.Searchbtnandcartpage;

public class Searchbtncarttest extends base {

    @Test(priority=6,groups = {"regression"},description = "Searching items are added to cart")
    public void addtocart() throws InterruptedException {
    	handleCountrySelection(country); 
        Searchbtnandcartpage search = new Searchbtnandcartpage(driver);
        search.lenevolaptop();  
//        search.TV();
    }
}
