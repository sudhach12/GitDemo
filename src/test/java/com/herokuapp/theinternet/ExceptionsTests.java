package com.herokuapp.theinternet;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.openqa.selenium.*;

public class ExceptionsTests{
	private WebDriver driver;
	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun=true)
	private void starting(@Optional("chrome") String browser)
	{
		switch(browser) {
		case "chrome": System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		 driver= new ChromeDriver();
		 break;
		case "fireFox": System.setProperty("webdriver.chrome.driver","src/main/resources/geckodriver.exe");
		 driver= new FirefoxDriver();
		 break;
		 default:
			 System.out.println("do not how to start"+browser+",Starting chrome instead");
	     System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		 driver= new ChromeDriver();
		 break;
		}
//sleep for three seco
	sleep(3000);
	// maximize window
	driver.manage().window().maximize();
	}

    @Test(priority=2)
	public void timeOutException() 
    {
	System.out.println("starting login test");

	//sleep for three seco
   // sleep(3000);
    // maximize window
	//driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	String url="https://the-internet.herokuapp.com/dynamic_loading/1";
	driver.get(url);
	System.out.println("page is opened");
	 //sleep for three seconds
	sleep(3000);
	 //find locator startbuton and click on it
	WebElement startButton=driver.findElement(By.xpath("//div[@id='start']/button"));
	startButton.click();
	sleep(2000);
	 //then get finish element text
	WebElement finishElement=driver.findElement(By.xpath("//div[@id='finish']"));
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2));
	try {
		wait.until(ExpectedConditions.visibilityOf(finishElement));
	}
	catch(TimeoutException e) {
	
	System.out.println("exception catched  " +e.getMessage())	;
	}
	
	String finishText=finishElement.getText();
	
	//compare actual message with expected message as Hello world
	Assert.assertTrue(finishText.contains("Hello World!"),"finish Text"+finishText);
	
	
	// startButton.click();
	
	
 }

    @Test(priority=2)
   	public void notvisibleTests() {
   	System.out.println("starting login test");

   	//sleep for three seco
      // sleep(3000);
       // maximize window
   	//driver.manage().window().maximize();
   	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

   	String url="https://the-internet.herokuapp.com/dynamic_loading/1";
   	driver.get(url);
   	System.out.println("page is opened");
   	 //sleep for three seconds
   	sleep(3000);
   	 //find locator startbuton and click on it
   	WebElement startButton=driver.findElement(By.xpath("//div[@id='start']/button"));
   	startButton.click();
   	sleep(2000);
   	 //then get finish element text
   	WebElement finishElement=driver.findElement(By.xpath("//div[@id='finish']"));
   	
   	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
   	wait.until(ExpectedConditions.visibilityOf(finishElement));
   	
   	String finishText=finishElement.getText();
   	
   	//compare actual message with expected message as Hello world
   	Assert.assertTrue(finishText.contains("Hello World!"),"finish Text"+finishText);
   	
   	
   	// startButton.click();
   	
  }
    
    
    @Test(priority=3)
   	public void noSuchElementTests() {
   	System.out.println("starting login test");

   	//sleep for three seco
      // sleep(3000);
       // maximize window
   	//driver.manage().window().maximize();
   	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

   	String url="https://the-internet.herokuapp.com/dynamic_loading/2";
   	driver.get(url);
   	System.out.println("page is opened");
   	 //sleep for three seconds
   	sleep(3000);
   	 //find locator startbuton and click on it
   	WebElement startButton=driver.findElement(By.xpath("//div[@id='start']/button"));
   	startButton.click();
   	sleep(2000);
   	 //then get finish element text
   	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	WebElement finishElement =  	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
   
   //	WebElement finishElement=driver.findElement(By.xpath("//div[@id='finish']"));
   	
  // 	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
  // 	wait.until(ExpectedConditions.visibilityOf(finishElement));
   	
   	String finishText=finishElement.getText();
   	
   	//compare actual message with expected message as Hello world
   	Assert.assertTrue(finishText.contains("Hello World!"),"finish Text"+finishText);
   	
   	
   	// startButton.click();
   	
   	
   	
   	
   	
   	  }





	
	
	private static void sleep(long m) {
	try {
		 Thread.sleep(3000);
		 
	 }
	 
	 catch(InterruptedException e){
		 
		 e.printStackTrace();
		 
	 }
}
@AfterMethod(alwaysRun=true)
private void teardown() {
	// close browser
	 driver.quit();
}


}
