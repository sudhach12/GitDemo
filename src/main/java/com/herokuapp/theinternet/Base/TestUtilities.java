package com.herokuapp.theinternet.Base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

public class TestUtilities  extends BaseTest{

	protected static void sleep(long m) {
		try {
			 Thread.sleep(3000);
			 
		 }
		 
		 catch(InterruptedException e){
			 
			 e.printStackTrace();
			 
		 }
	}
	@DataProvider(name="files")
protected static Object[][] files()	{
	return new Object[][] {
		{1,"Example.jpeg"},
		{2,"example2.txt"},
		{3,"example3.html"}
	};
}
	
//Take screenshot
	protected void takeScreenshot(String fileName) {
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE );
		String path = System.getProperty("user.dir")
				+File.separator+"test-output"
				+File.separator+"screenshots"
				+File.separator+getTodaysDate()
				+File.separator+testName
				+File.separator+testMethodName
				+File.separator+getSystemTime()
				+" " +fileName+".png";
		try {
			FileUtils.copyFile(srcFile,new File(path));
		}catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
	//Todays date in yyyymmdd format
	private static String getTodaysDate()
	{
		return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
	}
	public String getSystemTime() {
		return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
	}
	
	
}
