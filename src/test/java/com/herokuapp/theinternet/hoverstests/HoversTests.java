package com.herokuapp.theinternet.hoverstests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.Base.TestUtilities;
import com.herokuapp.theinternet.pages.HoverPage;

public class HoversTests extends TestUtilities {
	
	@Test
	public void user2profileTest()
	{
	// open HoversPage(
		HoverPage hoverPage=new HoverPage(driver,log);
		hoverPage.openPage();
		//open user 2 profile
		hoverPage.openUserProfile(2);
		sleep(1000);
		//verify correct user profile opened
		Assert.assertTrue(hoverPage.getCurrentUrl().contains("/users/2"), "Url of opened page is not expected user 1 page url");
	}
		

	

}
