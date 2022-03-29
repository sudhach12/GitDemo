package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class SecureAreaPage extends BasePageObject{
	private String pageUrl="http://the-internet.herokuapp.com/secure";
	private By message=By.id("flash-messages");
	private By logOutButton=By.xpath("//a[@class='button secondary radius']");
	
	public SecureAreaPage(WebDriver  driver,Logger log) {
		super(driver,log);
		
		}
	
	/* get URL variabe from page object */
	public String getPageUrl()
	{
return pageUrl;

}
	/* verification if logout button is visible on page */
	public boolean islogOutButtonVissible() {
		return find(logOutButton).isDisplayed();
		}
	
	public String getSuccessMessageText() {
		
		return find(message).getText();
	}
	
	
	
}
