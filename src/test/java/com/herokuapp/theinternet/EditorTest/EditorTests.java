package com.herokuapp.theinternet.EditorTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.Base.TestUtilities;
import com.herokuapp.theinternet.pages.WelComePageObject;
import com.herokuapp.theinternet.pages.WindowPage;
import com.herokuapp.theinternet.pages.WysEditorPage;

public class EditorTests extends TestUtilities{
	@Test
	 public void defaulteditorvalueTest()
		{
			log.info("Starting defaulteditorvalueTestwysEditorPagee");
			//open main page
			WelComePageObject welcomepage= new WelComePageObject(driver,log);
			welcomepage.openPage();
			 /** click wysEditorPagee link */
			// scroll to the bottom
			 sleep(1000);
			 welcomepage.scrollToButtom();
			 sleep(1000);
	WysEditorPage wysEditorPagee=welcomepage.clicWysEditorLink();
		    //get default editor text
			String editorText=wysEditorPagee.getEditorText();
			//verfication that new page contains expected text in source
			Assert.assertTrue(editorText.equals("Your content goes here."),"Editor default text is not expectecd it is "+editorText);
		}
	
}
