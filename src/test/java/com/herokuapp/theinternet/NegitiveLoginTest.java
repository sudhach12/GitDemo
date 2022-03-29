package com.herokuapp.theinternet;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.Base.TestUtilities;
import com.herokuapp.theinternet.pages.CsvDataProviders;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelComePageObject;

public class NegitiveLoginTest extends TestUtilities {

	@Test(priority=1,dataProvider="csvReader",dataProviderClass=CsvDataProviders.class)
	public void negitiveLoginTests(Map<String,String> testData) {
	String	 no =testData.get("no");
	String username=testData.get("username");
	String password=testData.get("password");
	String expectedMessage=testData.get("expectedMessage");
	String description=testData.get("description");
		log.info("starting lointest");

		//open main page
		WelComePageObject welcomepage =new WelComePageObject(driver,log);
		
		welcomepage.openPage();
		LoginPage loginpage=welcomepage.clickFormAuthenticationLink();
		//execute negative login
		loginpage.negativeLogin(username,password);
		//woit for error message
		loginpage.waitForErrorMessage();
		String message = loginpage.getErrorMessageText();
		Assert.assertTrue(message.contains(expectedMessage),"message doest not match");
	

	}
}
