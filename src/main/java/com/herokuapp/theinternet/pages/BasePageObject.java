package com.herokuapp.theinternet.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {
	protected WebDriver driver;
	protected Logger log;
	public BasePageObject(WebDriver  driver,Logger log) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.log=log;
	}
	protected void openUrl(String url) {
		driver.get(url);                                                                                  
		}
	//find element using giving locator
	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}
	
	protected void click(By locator) {
		waitForVisibilityOf(locator,10);
		find(locator).click();
		
	}
	protected void type(String text,By locator) {
		waitForVisibilityOf(locator,5);
		find(locator).sendKeys(text);
		
	}
	
	private void waitFor(ExpectedCondition<WebElement>condition,Integer timeOutInSeconds)
	{
	//timeOutInSeconds=timeOutInSeconds!=null?timeOutInSeconds:30;
	WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(timeOutInSeconds));
	wait2.until(condition);
	}
	
	protected void waitForVisibilityOf(By locator,Integer timeOutInSeconds)
	{
	int attempts=0;
	while(attempts<2) {
		try {
waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
					(timeOutInSeconds));
			break;
		}catch(StaleElementReferenceException e) {
			attempts++;
		}}}
		
		
		/** get URL of current page from Browser */
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	//get currentPageTitle
	public String getCurrentPageTitle() {
		return driver.getTitle();
	}
	
	//get source of current page
	public String getCurrentPageSource() {
		return driver.getPageSource();
	}
	
	//find all elements using given locator
	List<WebElement> findAll(By locator){
		return driver.findElements(locator);
		
	}
	
	//wait for alert present and then swith to it
	protected Alert switchToAlert() {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert();
	}
	
	public void switchToWindowWithTitle(String expectedTitle) {
	//switch to new window
	String firstWindow=driver.getWindowHandle();
	Set<String> allWindows = driver.getWindowHandles();
	Iterator<String> windowsIterator= allWindows.iterator();
	while(windowsIterator.hasNext()) {
		String windowHandle=windowsIterator.next().toString();
		if(!windowHandle.equals(firstWindow))
		{
			driver.switchTo().window(windowHandle);
			if(getCurrentPageTitle().equals("expectedTitle"));{
				break;
			}
		}
	}
	
																																																		
	
	}
	
	
	//switch to iframe using its locator
	protected void switchToFrame(By frameLocator) {
		driver.switchTo().frame(find(frameLocator));
	}
	//press key on locator
	protected void presskey(By locator,Keys key) {
		find(locator).sendKeys(key);
	}
	
	//perform mouse hoverover  element
		protected void hoverOverElement (WebElement element) {
			Actions action=new Actions(driver);
			action.moveToElement(element).build().perform();
			
	}
		//perform scroll to buttom
	public void	scrollToButtom()
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	
	
}


