package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class WelComePageObject extends BasePageObject {
public WelComePageObject(WebDriver  driver,Logger log) {
		super(driver,log);
		}
    private String pageUrl="http://the-internet.herokuapp.com/";
	private By formAuthenticationLinkLocator=By.linkText("Form Authentication");
	private By CheckboxesLinkLocator=By.linkText("Checkboxes");
	private By dropdownLinkLocator=By.linkText("Dropdown");
	private By jsAlertLocator=By.linkText("JavaScript Alerts");
	private By MultipleWindowsLocator=By.linkText("Multiple Windows");
	private By WysEditorLocator=By.linkText("WYSIWYG Editor");
	
/** open welcomepage with its url */
public void openPage() {
	log.info("opening page "+pageUrl);
	openUrl(pageUrl);
	
	log.info("Page opened");
}

public LoginPage clickFormAuthenticationLink() {
	log.info("clicking form authenticationlink");
	click(formAuthenticationLinkLocator);
	return new LoginPage(driver,log);
}
//open checkboxpage by clicking on checkboxeslink
public CheckboxesPage  clickCheckboxesLink() {
	log.info("clicking checkboxeslink");
	click(CheckboxesLinkLocator);
	return new CheckboxesPage(driver,log);
}
//dropdown 
public DropdownPage  clickDropdownLink() {
	log.info("clicking checkboxeslink");
	click(dropdownLinkLocator);
	return new DropdownPage(driver,log);
}
//workinking with alertboxes
public JavaScriptAlertsPage   clickJavaScriptAlertsLink() {
	log.info("clicking javaScriptlink");
	click(jsAlertLocator);
	return new JavaScriptAlertsPage(driver,log);
	
}
public WindowPage   clickMultipleWindowsLink() {
	log.info("clicking MultipleWindowsLink");
	click(MultipleWindowsLocator);
	return new WindowPage(driver,log);
	
}


public WysEditorPage   clicWysEditorLink() {
	log.info("clicking WyseditorLink");
	click(WysEditorLocator);
	return new WysEditorPage(driver,log);
	
}


}


