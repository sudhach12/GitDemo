package com.herokuapp.theinternet.checkboxespagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.Base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.WelComePageObject;

public class CheckboxesTests extends TestUtilities{
@Test
public void selectingTwoCheckboxesTest()
{
	log.info("Starting selecting two checkboxes");
	//open main page
	WelComePageObject welcomepage= new WelComePageObject(driver,log);
	welcomepage.openPage();
	//click on checkboxes link
	CheckboxesPage checkboxesPage=welcomepage.clickCheckboxesLink();
	//select All checkboxes
	checkboxesPage.selectAllCheckboxes();
	//verify all checkboxes are checked
	Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(),"not all check boxes checked" );
	
	
	
	
}
}
