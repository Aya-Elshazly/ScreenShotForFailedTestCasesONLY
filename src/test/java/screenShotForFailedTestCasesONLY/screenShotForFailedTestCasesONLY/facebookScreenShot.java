package screenShotForFailedTestCasesONLY.screenShotForFailedTestCasesONLY;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class facebookScreenShot {
	public static WebDriver driver;
	@BeforeTest
	public void setUP(){
		System.setProperty("webdriver.chrome.driver", "E:\\Automation sources\\chromedriver.exe");	
		driver = new ChromeDriver(); 
		driver.get("https://www.facebook.com/");
	}
	@Test
	public void test1(){
		driver.findElement(By.id("email")).sendKeys("Learn Automation");
	}
	@Test
	public void test2(){
		
		driver.findElement(By.id("pas")).sendKeys("123");

	}
	@AfterMethod
	public void tearDown(ITestResult result){
		if(ITestResult.FAILURE==result.getStatus()){
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(src, new File("./Screenshots/"+result.getName()+".png"));
			} catch (IOException e) {
				System.out.println("Exception while taking screenshot "+e.getMessage());
				e.printStackTrace();
			}
			System.out.println("Screenshot taken");
			driver.quit();
		}
	}

}
