package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage extends BasePageObject {
	private String pageUrl="http://the-internet.herokuapp.com/upload";
	
	private By chooseFileFieldLocator=By.id("file-upload");
	private By upLoadButtonLocator=By.id("file-submit" );
	private By upLoadedFilesLocator=By.id("uploaded-files");
	public FileUploaderPage(WebDriver  driver,Logger log) {
		super(driver,log);
		}

	//open fileUploaded page with url
	public void openPage() {
		openUrl(pageUrl);
	}
	
	//push upload button
	public void pushUploadButton() {
		click(upLoadButtonLocator);
		
	}
	public void selectFile(String filename)
	{
		//string filepath ="c:\\users\\dmitry\\download\\some.
		String filePath= System.getProperty("user.dir")+"/src/main/resources/files/"+filename;
				//"selenium-for-beginners/src/main/resources/files/Example.jpeg";
				//System.getProperty("user.dir")+"//src//main//resources//files"+filename;
		type(filePath,chooseFileFieldLocator);
	}
	
	//get names of Uploaded files
	public String getUploadedFilesNames() {
		String names=find(upLoadedFilesLocator).getText();
		
		log.info("Uploaded files"+names);
		return names;
		
		
		}
}
