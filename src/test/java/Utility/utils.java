package Utility;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class utils {
	
	// Intialising variables
	
    public static WebDriver driver; 
    public String excelsheet;
    public String sheetname;
    public WebDriverWait wait;
    public JavascriptExecutor js; 
    public String testName;
    public String testDescription;
    public String testCategory;
    
    
    //Method to launch the browser and url
    public  void launchbrowserandurl(String browser, String url) {
        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
			options.addArguments("--incognito");
//			options.addArguments("--headless"); 
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
//            options.addArguments("--headless"); 
//            options.addArguments("--disable-notifications");
            options.addPreference("dom.webnotifications.enabled", false);
			options.addArguments("-private");
            driver = new FirefoxDriver(options);
        } else {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
			options.addArguments("--incognito");
//			options.addArguments("--headless"); 
            driver = new ChromeDriver(options);
        }

        driver.get(url);
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        js=(JavascriptExecutor) driver;
        
    }

    //Method to select the country either Unitedstates or Canada
    public void handleCountrySelection(String country) {
        if (country.equalsIgnoreCase("Canada")) {
            WebElement canadaLink = driver.findElement(By.xpath("//a[@class='canada-link']"));
            canadaLink.click();
            System.out.println("Selected Canada.");
        } else if (country.equalsIgnoreCase("United States")) {
            WebElement usLink = driver.findElement(By.xpath("//a[@class='us-link']"));
            usLink.click();
            System.out.println("Selected United States.");
        }
    }

    //Method to retrieve data from excelsheet
    public String[][] exceldatafindings(String excelsheet, String sheetname) throws IOException {
        XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\harin\\eclipse-workspace\\Capstone_1\\Excelsheet\\" + excelsheet + ".xlsx");
        XSSFSheet sheet = book.getSheet(sheetname);
        int rowcount = sheet.getLastRowNum();
        int columncount = sheet.getRow(0).getLastCellNum();
        String[][] data = new String[rowcount][columncount];

        for (int i=1;i<=rowcount;i++) {
            XSSFRow row = sheet.getRow(i);

            for (int j=0;j<columncount;j++) {
                XSSFCell cell = row.getCell(j);
                if (cell == null) {
                    data[i-1][j] = ""; 
                } else {
                    switch (cell.getCellType()) {
                        case STRING:
                            data[i-1][j] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            data[i-1][j] = String.valueOf(cell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            data[i-1][j] = String.valueOf(cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            data[i-1][j] = cell.getCellFormula();
                            break;
                        default:
                            data[i-1][j] = "";
                    }
                }
            }
        }
        book.close();
        return data;
    }

    //method to click webelement button
    public void clickbtn(WebElement ele) {
    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(55));
    	wait.until(ExpectedConditions.elementToBeClickable(ele));
    	js.executeScript("arguments[0].scrollIntoView(true);", ele);
    	js.executeScript("arguments[0].click();", ele); 
//    	ele.click();
    }

    //Method to sendkeys with id
    public void webwait(String id,String idname) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(55));
		WebElement idvalues= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		idvalues.clear();
		idvalues.sendKeys(idname);
	}
    
    //method to refreh the page
    public void resetForm() {
        driver.navigate().refresh();  
    }
    
    //method to connect to url and check the responsecode
    public void urlconnect(String urlco) throws IOException {
    	URL urllink = new URL(urlco);
        HttpURLConnection httpURLConnection = (HttpURLConnection) urllink.openConnection();
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.connect();
        if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 400) {
            System.out.println("Working URL: " + urlco + " (Response message :   " + httpURLConnection.getResponseMessage()+")");
            System.out.println("Given URL is not a broken URL.");
        } else {
            System.out.println("Broken URL: " + urlco + " (Response message :   " + httpURLConnection.getResponseMessage()+")");
            System.out.println("Given URL is a broken URL.");
        }
        httpURLConnection.disconnect();
    }
    
    //method to check actual and expected text is equal.If it failed print test failed statement
    public void actandexpec(String xpath,String expectedtext) {
    	WebElement actual=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""+xpath+"")));
    	
		String actualtext=actual.getText();
    	try {
			if (actualtext.equalsIgnoreCase(expectedtext)) {
			    System.out.println("Test Passed: Actual text: " + actualtext + " | Expected text: " + expectedtext);
			} 
		} catch (Exception e) {
			    System.out.println("Test Failed: Actual text: " + actualtext + " | Expected text: " + expectedtext);
				e.printStackTrace();
		}
    }
    
    //Method using webdriverwait and using javascriptexecutor to scroll and click button
    public void webwaitxpath(String xpath) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(55));
		WebElement xpathvalues= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
//		xpathvalues	.click();
		js.executeScript("arguments[0].scrollIntoView(true);", xpathvalues);
        js.executeScript("arguments[0].click();", xpathvalues); 
	}
    
    //Method using webdriverwait mechanism and using xpath to find element to sendkeys 
    public void xpathandsendkeys(String xpath,String keyvalue) {
    	WebElement sendkeyvalue=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    	sendkeyvalue.clear();
    	sendkeyvalue.sendKeys(keyvalue);
    	sendkeyvalue.sendKeys(Keys.ENTER);
    }
    
    //Method using webdriverwait mechanism and using Webelement.Javascriptexecutor is used to click.
    public void xpathvisibleclick(WebElement ele) {
        wait.until(ExpectedConditions.visibilityOf(ele));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
        js.executeScript("arguments[0].scrollIntoView(true);", ele);
        js.executeScript("arguments[0].click();", ele); 
    }

    //Method using boolean to get Webelement is visible or not
    public boolean xpathvisible(WebElement ele) {
    	wait.until(ExpectedConditions.visibilityOf(ele));
    	js.executeScript("arguments[0].scrollIntoView(true);", ele);
		return true;	
    }
    
    //Method using String to get WebElement text
    public String xpathvisibletext(WebElement ele) {
    	return wait.until(ExpectedConditions.visibilityOf(ele)).getText();
    }
    
    //Method using id locators and sendkeys through webelement
    public void idsendkeys(WebElement ele,String datas) {
    	js.executeScript("arguments[0].scrollIntoView(true);", ele);
    	WebElement data=wait.until(ExpectedConditions.visibilityOf(ele));
    	data.sendKeys(datas);
    }
    
    //Method used to takescreenshot
    public String takeScreenshot(String browser,String screenshotName) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String filename = browser+"_"+screenshotName + "_" + time + ".png";
        String path = "C:\\Users\\harin\\eclipse-workspace\\Capstone_1\\Screenshots\\" + filename;
        System.out.println("Screenshot" +path);
        File dest = new File(path);
        FileUtils.copyFile(src, dest);
        return path;
    }
    
    //Method using webbdriver wait mechanism to findelements is clickable and using javascriptexecuto to click
    public void actionbtnclick(WebElement ele) {
    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(55));
    	boolean check=wait.until(ExpectedConditions.elementToBeClickable(ele)) != null;
    	if(check) {
    		js.executeScript("arguments[0].scrollIntoView(true);", ele);
    		js.executeScript("arguments[0].click();", ele);
//    		ele.click();
//        	Actions act=new Actions(driver);
//        	act.click(ele).build().perform();
    	}else {
    		System.out.println("Failed clicking");
    	}
    	
    }
}

