package Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import Base.base;

public class urltest extends base {

	//Method used to chech currenturl is is broken or not
	
    @Test(priority=1,groups = {"regression"},description = "Checking url is broken or not")
   public void brokencurrenturl() throws IOException { 
        System.out.println("Title of page: " + driver.getTitle());
        System.out.println("Url of page: " + driver.getCurrentUrl());
        String currentUrl = driver.getCurrentUrl();
        urlconnect(currentUrl);
    }

}