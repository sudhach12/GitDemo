package com.herokuapp.theinternet.KeyPress;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.Base.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPressPage;

public class KeyPressTest extends TestUtilities {
	
@Test
public void pressKeyTest() {
	log.info("starting presskey test");
	//open keypress page
	KeyPressPage keypressPage=new KeyPressPage(driver,log);
	keypressPage.openPage();
	//push keybord key
	keypressPage.presskey(Keys.ENTER);
	//getbresult text
	String result=keypressPage.getResultText();
	//verify result text is expected
	Assert.assertTrue(result.equals("You entered: ENTER"),"result is not expected you typed  "+result);
	
	
}

}


