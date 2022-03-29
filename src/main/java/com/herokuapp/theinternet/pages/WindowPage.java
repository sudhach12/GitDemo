package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowPage extends BasePageObject {
	
	private By clickHereLinkLocator=By.linkText("Click Here");

	public WindowPage(WebDriver  driver,Logger log) {
		super(driver,log);
		// TODO Auto-generated constructor stub
		}
// click here to open newwindow
	public void openNewWindow() {
		
		log.info("looking for new window");
		click(clickHereLinkLocator);
		
	}
//find the page with title new Window and switch to it
	public NewWindowPage switchToNewWindowPage() {
		switchToWindowWithTitle("New Window");
	return new NewWindowPage(driver,log);
}
	// get source of current page
	public String getCurrentPageSource()
	{
		return driver.getPageSource();
	}
}