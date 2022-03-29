package com.herokuapp.theinternet.Dropdown;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.Base.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPage;
import com.herokuapp.theinternet.pages.WelComePageObject;

public class DropdownTest extends TestUtilities {
@Test
public void optionTwoTest() {
	log.info("starting option two test");
	//open main page
	WelComePageObject welcomepage= new WelComePageObject(driver,log);
	welcomepage.openPage();
	//click on Dropdown link
	DropdownPage dropdownPage=welcomepage.clickDropdownLink();
	//select option2
	dropdownPage.selectoption(2);
	//verify option 2 is selected
	String selectedoption=dropdownPage.getSelectedOption();
	
	Assert.assertTrue(selectedoption.equals("Option 2"), "option 2 is not selected instead selected "+selectedoption);
	
	
}
	

}
