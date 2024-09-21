package Base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import Utility.utils;

public class base extends utils {

    public String url = "https://www.bestbuy.com/";
    public String country = "United States";

    //Method used to execute this before every tests
    @BeforeMethod
    @Parameters("browser")
    public void before(String browser) {
        launchbrowserandurl(browser, url);
        System.out.println("Driver initialized: " + (driver != null));
    }

  //Method used to execute this after every tests
    @AfterMethod
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }

    //method used to retrieve data from excel sheet
    @DataProvider(name = "Readingdatasfromexcelsheet")
    public String[][] startreadingexcel() throws IOException {
        
        return exceldatafindings(excelsheet, sheetname);
    }
}
