package base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import reports.ExtentManager; 

public class BaseClass {
	public static HashMap<Integer, WebDriver> driverMap = new HashMap<Integer, WebDriver>();
	public WebDriver getDriver(){
		 System.setProperty("webdriver.chrome.driver", "/Users/yammy/Downloads/chromedriver");
         WebDriver driver = new ChromeDriver();
         return driver;
	}

	@BeforeSuite
	public void startReport() throws IOException {
		ExtentManager.startReport();
	}

	@BeforeMethod
	public void testSetUp(Method method) {
		String testName = method.getName();
		ExtentManager.createNode(testName);
	}

	@AfterMethod
	public void testTearDown(ITestResult result) throws Exception{
		if(result.getStatus() == ITestResult.FAILURE){
			//MarkupHelper is used to display the output in different colors
			ExtentManager.getLogger().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			ExtentManager.getLogger().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			
			//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
			//ExtentManager.getLogger().fail("Test Case Failed Snapshot is below " + ExtentManager.getLogger().addScreenCaptureFromPath(screenShotsArrayList.get(count)));
			
			//To add it in the extent report 
			ExtentManager.getLogger().fail("Test Case Failed Snapshot is below " );
		}
		else if(result.getStatus() == ITestResult.SKIP){
			ExtentManager.getLogger().log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
		} 
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			ExtentManager.getLogger().log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
		}
	}

	@AfterSuite
	public void frameworkTerminate() {
		ExtentManager.endReport();
	}
}