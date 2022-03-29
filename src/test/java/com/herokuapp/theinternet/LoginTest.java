package com.herokuapp.theinternet;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.time.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import com.herokuapp.theinternet.Base.TestUtilities;


public class LoginTest extends TestUtilities{
	
    @Test(priority=1,groups = { "positiveTests", "smokingTests" })
	public void PositiveLoginTest() {
    	log.info("starting login test");
	// Create driver
    //System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
	//WebDriver driver= new ChromeDriver();
	//sleep for three seco
   // sleep(3000);
    // maximize window
	//driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	//open test page
	
	//open test page
	String url="http://the-internet.herokuapp.com/login";
	driver.get(url);
	log.info("page is opened");
	 //sleep for three seconds
	sleep(3000);
	 //enter username
	WebElement username=driver.findElement(By.id("username"));
	username.sendKeys("tomsmith");
	sleep(2000);
	 //enter password
	WebElement password=driver.findElement(By.id("password"));
	password.sendKeys("SuperSecretPassword!");
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	//click loginbutton
	WebElement loginButton=driver.findElement(By.tagName("button"));
	//loginButton.isDisplayed();
	loginButton.click();
	//Assert.assertTrue(loginButton.isDisplayed(),"user name invalid");
	sleep(3000);
	 //verification
	String expectedUrl ="http://the-internet.herokuapp.com/secure";
	String actualUrl=driver.getCurrentUrl();
	//Assert.assertEquals(actualUrl, expectedUrl,"Actual page URL is not same as expected");
	//new url
 //logout button is visible
	WebElement logoutbutton=driver.findElement(By.xpath("//a[@class='button secondary radius']"));
	boolean condition;
	Assert.assertTrue(logoutbutton.isDisplayed(),"log out button is not visible");
	 //successful login message
	WebElement successmessage=driver.findElement(By.xpath("//div[@id='flash']"));
	String expectedMessage="You logged into a secure area";
	String actualMessage=successmessage.getText();
	Assert.assertTrue(actualMessage.contains(expectedMessage),"actual message does not contain expected");
	WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(10));

	  }


	
	
	@Parameters({ "username", "password","expectedMessage" })
	@Test(priority=2,groups = { "negitiveTest", "smokingTest" })
	public void NegitiveLoginTest(String username, String password,String expectedMessage) {
		log.info("Starting negitiveLoginTest with " +username+ "  and  " +password);
	//System.out.println("correctusername test");
	// Create driver
	// System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		//WebDriver driver= new ChromeDriver();
		//sleep for three seco
   // sleep(1000);
    // maximize window
	//driver.manage().window().maximize();
	//open test page
	//open test page
	String url="http://the-internet.herokuapp.com/login";
	driver.get(url);
	log.info("page is opened");
	 //sleep for three seconds
	sleep(3000);
	 //enter username
	WebElement usernameElement=driver.findElement(By.id("username"));
	usernameElement.sendKeys(username);
	sleep(2000);
	 //enter password
	//WebElement password=driver.findElement(By.id("password"));
	WebElement passwordElement=driver.findElement(By.id("password"));
	passwordElement.sendKeys(password);
	sleep(2000);
	//click loginbutton
	WebElement loginButton=driver.findElement(By.tagName("button"));
	loginButton.click();
	sleep(2000);
	WebElement errorMessage=driver.findElement(By.id("flash"));
	String actualMessage=errorMessage.getText();
	Assert.assertTrue(actualMessage.contains(expectedMessage),"actual error message does not contains expected");
	
	 }

	@Test(priority = 3)
	public void relativeXpathTest() {
		
		 String url = "https://practicetestautomation.com/practice-test-exceptions/";

		driver.get(url);

		// Find and click 'Add' button to add second row
		WebElement addButton = driver.findElement(By.id("add_btn"));
		addButton.click();

		// Use Explicit wait to wait for the second row to be visible
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']")));

		// Get list of all rows
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='row']"));

		String actualText = null;

		// Iterate over each row in the list
		for (WebElement row : rows) {
			// Get text from label element for each row
			String label = row.findElement(By.xpath(".//label")).getText();
			System.out.println("Label text is: " + label);

			if (label.equals("Row 2")) {
				// If label equals Row 2, type Sushi into input field
				System.out.println("Typing 'sushi' into input field");
				row.findElement(By.xpath(".//input")).sendKeys("Sushi");
             sleep(3000);
				// Save new value by pushing Save button
				driver.findElement(By.xpath("//div[@id='row2']/button[@id='save_btn']")).click();

				// Get new value to use in the assertion
				actualText = row.findElement(By.xpath(".//input")).getAttribute("value");
				break;
			}
		}
		Assert.assertEquals(actualText, "Sushi");
	}

	
	
	
	
	
	
	


}
