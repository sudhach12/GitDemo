package com.herokuapp.theinternet.uploadtests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.Base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploaderPage;

public class UploadTests extends TestUtilities {

	@Test(dataProvider="files")
	public void imageUploadTest(int i,String fileName) {
		log.info("strating image upload test");
		// open file Upload Page
		FileUploaderPage fileUploaderPage = new FileUploaderPage(driver,log);
		fileUploaderPage.openPage();
		//select file
		//String fileName="Example.jpeg";
		fileUploaderPage.selectFile(fileName);
		//push upload button
		fileUploaderPage.pushUploadButton();
		sleep(1000);
		//get upload files
		String fileNames=fileUploaderPage.getUploadedFilesNames();
		//verify selected file uploaded
		Assert.assertTrue(fileName.contains(fileName),"our file is not undre uploaded");
		
		
		
	}

}
