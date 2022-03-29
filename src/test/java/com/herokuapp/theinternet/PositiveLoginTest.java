package com.herokuapp.theinternet;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelComePageObject;


import com.herokuapp.theinternet.Base.TestUtilities;

public class PositiveLoginTest extends TestUtilities {
	@Test
	public void loginTest() {
	log.info("starting lointest");

	//open main page
	WelComePageObject welcomepage =new WelComePageObject(driver,log);
	takeScreenshot("welcomePage opened");
	welcomepage.openPage();
	LoginPage loginpage=welcomepage.clickFormAuthenticationLink();
	takeScreenshot("LoginPage opened");
    SecureAreaPage secureareapage =	loginpage.logIn("tomsmith","SuperSecretPassword!");
     takeScreenshot("SecureAreaPage opened");
     //verification 
    //new page url is expected
    Assert.assertEquals(secureareapage.getCurrentUrl(),secureareapage.getPageUrl());
   //logout button vissible
   Assert.assertTrue(secureareapage.islogOutButtonVissible(), "logoutbutton is not vissible");
	//successfull login message
String expectedMessage ="You logged into a secure area";
String actualMessage=secureareapage.getSuccessMessageText();
Assert.assertTrue(actualMessage.contains(expectedMessage),"actual message does not contain expected");

	
	
}
}
