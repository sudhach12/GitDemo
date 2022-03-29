package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage extends BasePageObject{
	
	private By clickForJSAlertButtonLocator=By.xpath("//button[text()='Click for JS Alert']");
	private By clickForJSConfirmButtonLocator=By.xpath("//button[text()='Click for JS Confirm']");	
	private By clickForJSPromptButtonLocator=By.xpath("//button[text()='Click for JS Prompt']");
	private By resultTextLocator=By.id("result");

	
	public JavaScriptAlertsPage(WebDriver  driver,Logger log) {
		
		super(driver,log);

		// TODO Auto-generated constructor stub
	}
	
	//clicking on click for js Alert  button to open alert
	public void openJSAlert() {
		log.info("clicking on click for js confirm button to open alert");
		click(clickForJSAlertButtonLocator);
		}
	//clicking on click for js confirm  button to open alert
		public void openJSConfirm() {
			log.info("clicking on click for js confirm button to open alert");
			click(clickForJSConfirmButtonLocator);
			}
//clicking on click for js prompt button to open alert
		public void openJSPrompt()
		{
			log.info("clicking on click for js prompt button to open alert");
			click(clickForJSPromptButtonLocator);
			
		}
//switch to slert and get its message
		
public String getAlertText() {
	
	Alert alert=switchToAlert();
	String alertText=alert.getText();
	log.info("Alert says "+alertText);
	return alertText;
	
}
//switch to alert and press ok

public void acceptAlert() {

	log.info("switching to alert and press ok");
	Alert alert=switchToAlert();
	alert.accept();
}
//switch to alert and cancel
public void dismissAlert() {

	log.info("switching to alert and press dismiss");
	Alert alert=switchToAlert();
	alert.dismiss();
}
//type text into alert and press ok
public void typeTextintoAlert(String text)
{
log.info("type Text into alert and pressing ok");
Alert alert=switchToAlert();

alert.sendKeys(text);
alert.accept();
}
//get result text
public String getResultText() {
	String result =find(resultTextLocator).getText();
	log.info("result text "+result);
	return result;
}
}