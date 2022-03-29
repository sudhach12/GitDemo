package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysEditorPage extends BasePageObject {
	private By editorLocator=By.id("tinymce");
	private By frame=By.tagName("iframe");

	public WysEditorPage(WebDriver  driver,Logger log) {
		// TODO Auto-generated constructor stub
		super(driver,log);
	}
	//get text from wys Editor
public  String	getEditorText() {
	switchToFrame(frame);
	String text=find(editorLocator).getText();
	log.info("text from wyc editor "+text);
	return text;

}
}