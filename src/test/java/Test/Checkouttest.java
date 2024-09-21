package Test;

import org.testng.annotations.Test;

import Base.base;
import Page.Checkoutpage;
import Page.Searchbtnandcartpage;
import Page.Selectbydepartmentpage;

public class Checkouttest extends base{
	
  @Test(priority=8,groups = {"regression"},description = "Searching product through department and adding them to cart")
  public void checkout() throws InterruptedException {
	  handleCountrySelection(country);  
	  Selectbydepartmentpage dep=new Selectbydepartmentpage(driver);
	  dep.selectmenubtn();
	  Checkoutpage checkout=new Checkoutpage(driver);
	  checkout.lgbrandclick();
	  Searchbtnandcartpage search = new Searchbtnandcartpage(driver);
      search.lgearpods();
      checkout.checkoutproduct();
      
  }
}
