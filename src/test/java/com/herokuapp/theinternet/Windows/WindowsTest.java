package com.herokuapp.theinternet.Windows;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.Base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.NewWindowPage;
import com.herokuapp.theinternet.pages.WelComePageObject;
import com.herokuapp.theinternet.pages.WindowPage;

public class WindowsTest extends TestUtilities {
	
	@Test
    public void newWindowTest()
	{
		log.info("Starting newWindowTest");
		//open main page
		WelComePageObject welcomepage= new WelComePageObject(driver,log);
		welcomepage.openPage();
    
		 /** click multiplewindows link */
		WindowPage windowPage=welcomepage.clickMultipleWindowsLink();
		//click here to open new window
		windowPage.openNewWindow();
		sleep(1000);
		//find and switch to new window page
		NewWindowPage  newWindowPage   =   windowPage.switchToNewWindowPage();
		String pageSource=newWindowPage.getCurrentPageSource();
	//new page contains expected text in source
		Assert.assertTrue(pageSource.contains("New Window"), "NewPageSourse does not contains New Window");
}
}