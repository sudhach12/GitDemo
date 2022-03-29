package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class CheckboxesPage extends BasePageObject
{

	private By checkbox=By.xpath("//input[@type='checkbox']");
	public CheckboxesPage(WebDriver  driver,Logger log) {
		super(driver,log);
		}
	//get list of all checkboxes and check if unchecked
	public void selectAllCheckboxes() {
		log.info("checking all unchecked checkboxes");
		List<WebElement> checkboxes=findAll(checkbox);
		for(WebElement checkbox:checkboxes) {
			if(!checkbox.isSelected()) {
				checkbox.click();
				}}
	}
	
//verify all available checkboxes are checked.if at least one unchecked return false
	public boolean areAllCheckboxesChecked() {
		log.info("verifying that all check boxes are checked");
		List<WebElement> checkboxes=findAll(checkbox);
		for(WebElement checkbox:checkboxes) {
			if(!checkbox.isSelected()) {
				return false;
				
			}
		}
		return true;
	}
	
	}

