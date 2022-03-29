package com.herokuapp.theinternet.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.logging.log4j.Logger;

public class BrowserDriverFactory {
	private ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	private String browser;
	private Logger log;
	public BrowserDriverFactory( String browser,Logger log)
	{
	this.browser=browser.toLowerCase();
	this.log=log;
}
	public WebDriver createDriver() {
		log.info("create driver "+browser);
		switch(browser) {
		case "chrome": System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		 driver.set(new ChromeDriver());
		 break;
		case "fireFox": System.setProperty("webdriver.chrome.driver","src/main/resources/geckodriver.exe");
		 driver.set(new FirefoxDriver());
		 break;
		 default:
			 System.out.println("do not how to start"+browser+",Starting chrome instead");
	     System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
	     driver.set(new ChromeDriver());
		 break;
		}	
		return driver.get();
	}
	
	
}