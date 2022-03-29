package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePageObject {

	private By dropdown=By.id("dropdown");
	public DropdownPage(WebDriver  driver,Logger log) {
		super(driver,log);
		// TODO Auto-generated constructor stub
	}
//This method selects given option from dropdown
	public void selectoption(int i){
		log.info("Selecting option "+i+"from dropdown");
		WebElement dropdownElement=find(dropdown);
		Select dropdown=new Select(dropdownElement);
		//There are three ways to use select class
		//#1
		//dropdown.selectByIndex(i);
		//#2
	       dropdown.selectByValue(""+i);
		//#3
		//dropdown.selectByVisibleText("option "+i);
		//this method return selected option in dropdown as string
		
		}
	
	//this method return selected option in dropdown as string
	public String getSelectedOption() {
		WebElement dropdownElement =find(dropdown);
		Select dropdown=new Select(dropdownElement);
		String selectedOption = dropdown.getFirstSelectedOption().getText();
		log.info(selectedOption+"is selected in dropdown");
		return selectedOption;
	}
	
}
