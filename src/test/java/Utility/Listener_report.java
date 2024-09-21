package Utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.base;


public class Listener_report extends base implements ITestListener{
	ExtentReports extent=Extentreport.getreport();
	ExtentTest test;
	String browsername=null;
	
	@Override
    public void onTestStart(ITestResult result) {
        
        Test testAnnotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class);
        ITestContext context=result.getTestContext();
        browsername=context.getCurrentXmlTest().getParameter("browser");
        if (testAnnotation != null) {
            String testName = result.getMethod().getMethodName();
            String testDescription = testAnnotation.description();
            
            
            test = extent.createTest(testName)
                .assignAuthor("Harini")
                .assignDevice(browsername);

            test.log(Status.INFO, "Description: " + testDescription);
        } else {
           
            test = extent.createTest(result.getMethod().getMethodName())
                .assignAuthor("Unknown")
                .assignCategory("General")
                .assignDevice("chrome");
        }
        test.log(Status.PASS, "Test Started: " + result.getMethod().getMethodName());
    }
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed: "+result.getMethod().getMethodName());
	}
	
		
	@Override
	public void onTestFailure(ITestResult result) {
	    
	    test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
	    
	    String filepath = null;
	    try {
	        filepath = takeScreenshot(result.getMethod().getMethodName(),browsername);
	        System.out.println(filepath);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test Skipped"+result.getMethod().getMethodName());
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		test.log(Status.FAIL,"on Test Failed But Within Success Percentage :"+result.getMethod().getMethodName());
	}
	
//	@Override
//	public void onStart(ITestContext context) {
//		test.log(Status.INFO, "test Started : "+context.getName());
//	}
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
