import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class testngBase {
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("@BeforeClass");
		System.out.println("****************");
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("@AfterClass");
	}
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("@BeforeTest");
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("@AfterTest");
	}

}
