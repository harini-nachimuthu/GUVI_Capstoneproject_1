package Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.base;
import Page.Searchbtnandcartpage;
import Page.Selectbybrandpage;
import Page.Selectbydepartmentpage;

public class Selectbybrandtest extends base{
	
	
	  @Test(priority=8,groups = {"regression"},description = "Searching product by brand and adding them to cart")
	  public void brandproduvtselect() throws InterruptedException {
		  handleCountrySelection(country);  
		  Selectbydepartmentpage dep=new Selectbydepartmentpage(driver);
		  dep.selectmenubtn();
		  Selectbybrandpage brand=new Selectbybrandpage(driver);
		  brand.menubybrand();
		  Searchbtnandcartpage cart=new Searchbtnandcartpage(driver);
		  cart.TV();
	  }
}
