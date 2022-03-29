package com.herokuapp.theinternet.Alertboxes;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.Base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.WelComePageObject;

public class AlertsTest extends TestUtilities {
	@Test
	public void jsAlertTest()
	{
		log.info("Starting jsAlertsTest");
		//open main page
		WelComePageObject welcomepage= new WelComePageObject(driver,log);
		welcomepage.openPage();
       /** click on javascript Alert link */
		JavaScriptAlertsPage alertPage=welcomepage.clickJavaScriptAlertsLink();
	   //click Js Alert button
		alertPage.openJSAlert();
		
		//get alert text
		String alertMessage=alertPage.getAlertText();
		/** click ok button */
		alertPage.acceptAlert();
		//Get Results text
		String result=alertPage.getResultText();
		sleep(1000);
		/**   Verification */
		/*   1-Alert text is expected  */
		Assert.assertTrue(alertMessage.equals("I am a JS Alert"),"Alert message is not expected");
		//2 Result text is expected
		Assert.assertTrue(result.equals("You successfully clicked an alert"),"result is not expected.\n should be 'you successfuly clicked");
		
		
	}
	@Test
	public void jsDismissTest() {
		
	log.info("starting Dismistest");	
	
	WelComePageObject welcomepage= new WelComePageObject(driver,log);
	welcomepage.openPage();
	//click on javascript Alert link
	JavaScriptAlertsPage alertPage=welcomepage.clickJavaScriptAlertsLink();
	/* click js Confirmbutton */
	alertPage.openJSConfirm();
	sleep(1000);
	//get alert text
	String alertMessage=alertPage.getAlertText();
	//click cancel button
	alertPage.dismissAlert();
	//get Result test
	String result =alertPage.getResultText();
	sleep(1000);
	//verification
	//1. Alertn text is expected
	Assert.assertTrue(alertMessage.equals("I am a JS Confirm"),"Alert message is not expected \n should be 'I am JS Confirm");
	
	Assert.assertTrue(result.equals("You clicked: Cancel"),"result is not expected  \n should be 'You clicked: Cancel");
	
	}
	
	@Test 
	public void jsPromptTest() {
		log.info("starting Dismistest");	
		
		WelComePageObject welcomepage= new WelComePageObject(driver,log);
		welcomepage.openPage();
		/** click on javascript Alert link */
		JavaScriptAlertsPage alertPage=welcomepage.clickJavaScriptAlertsLink();
		//click js prompt button
		alertPage.openJSPrompt();
		sleep(1000);
		//get alert text
		String alertMessage=alertPage.getAlertText();
		//Type text into alert
		alertPage.typeTextintoAlert("Hello Alert,its Dmitry here");
		sleep(1000);
		//get Results text
		String result=alertPage.getResultText();
		
		sleep(1000);
		//verification
		//1.Alert text is expected
		Assert.assertTrue(alertMessage.equals("I am a JS prompt"),"Alert essage is not expected \n should be 'I am JS Prompt");
			
		// 2. Result test is expected
		Assert.assertTrue(result.equals("You entered: Hello Alert,its Dmitry here"),"result is not expected  \n should be 'You entered:Hello Alert,its Dmitry here");
		
		
		
		}

	}
