package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseClass;

public class testcases extends BaseClass{

	@Test
	public void test1(){
		WebDriver driver = getDriver();
		driver.get("https://www.softwaretestingmaterial.com/software-testing-interview-questions-free-ebook/");
		System.out.println("Selenium Webdriver Script in Chrome browser | Software Testing Material");
		driver.close();
	}

	@Test
	public void test3(){
		WebDriver driver = getDriver();
		driver.get("https://www.softwaretestingmaterial.com/software-testing-interview-questions-free-ebook/");
		System.out.println("Selenium Webdriver Script in Chrome browser | Software Testing Material");
		driver.close();
	}
	
	@Test
	public void test2(){
		WebDriver driver = getDriver();
		driver.get("https://www.softwaretestingmaterial.com/software-testing-interview-questions-free-ebook/");
		System.out.println("Selenium Webdriver Script in Chrome browser | Software Testing Material");
		driver.close();
	}

	@Test
	public void test4(){
		WebDriver driver = getDriver();
		driver.get("https://www.softwaretestingmaterial.com/software-testing-interview-questions-free-ebook/");
		System.out.println("Selenium Webdriver Script in Chrome browser | Software Testing Material");
		driver.close();
	}
}
