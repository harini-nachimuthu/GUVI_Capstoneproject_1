package Utility;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentreport  {
	 public static ExtentReports getreport() {
		 String path="C:\\Users\\harin\\eclipse-workspace\\Capstone_1\\Report_generation\\index.html";
		 ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		 //assigning reporternaem,documenttitle and theme
		 reporter.config().setReportName("E-commerce project automation");
		 reporter.config().setDocumentTitle("Shopping website");
		 reporter.config().setTheme(Theme.DARK);
		 
		 ExtentReports extent=new ExtentReports();
		 extent.attachReporter(reporter);
		 extent.setSystemInfo("Path for system info : ", path);
		 return extent;
		 
	 }
	
}
