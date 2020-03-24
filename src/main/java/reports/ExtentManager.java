package reports;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.
public class ExtentManager {

	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extent;
	private static ExtentTest extendLogger;
	
	private static Map<Long, ExtentTest> reportLogger = new ConcurrentHashMap<Long, ExtentTest>();
	

	public synchronized static void startReport() {
		if (extent == null) {
			//Set HTML reporting file location
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Report_"+ new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date()) +".html");
			// Create an object of Extent Reports
			extent = new ExtentReports();  
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Host Name", "TLC");
			extent.setSystemInfo("Environment", "Production");
			extent.setSystemInfo("User Name", "Automation Tester");
			htmlReporter.config().setDocumentTitle("TLC Test Automation Report"); 
			// Name of the report
			htmlReporter.config().setReportName("TLC Test Automation Report"); 
			// Dark Theme
			htmlReporter.config().setTheme(Theme.STANDARD);   
		}
	}

	public  static void createNode(String nodeName) {
		Long threadId = Thread.currentThread().getId();
		extendLogger = extent.createTest(nodeName);  
		reportLogger.put(threadId, extendLogger);
	}

	public synchronized static ExtentTest getLogger() {
		Long threadId = Thread.currentThread().getId();
		return  reportLogger.get(threadId);
	}

	public synchronized static void endReport() {
		extent.flush();
	}
}