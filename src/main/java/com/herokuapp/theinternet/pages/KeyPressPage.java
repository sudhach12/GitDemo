package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressPage extends BasePageObject {

	private String pageUrl="http://the-internet.herokuapp.com/key_presses";
	private By body=By.xpath("//body");
	private By resultTextLocator=By.id("result");
	public KeyPressPage(WebDriver  driver,Logger log) {
		super(driver,log);
		// TODO Auto-generated constructor stub
	}
	
	//open keypress page with is url
	public void openPage() {
	log.info("opening pagr");
	openUrl(pageUrl);
}
	//press given key while on the page
	public void presskey(Keys key) {
		presskey(body,key);
		
	}
	
	//press given key while on the page
	public String  getResultText() {
		String result=find(resultTextLocator).getText();
		return result;
		
	}
}