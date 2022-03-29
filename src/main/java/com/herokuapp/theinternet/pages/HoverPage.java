package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HoverPage extends BasePageObject {
	private String pageUrl="http://the-internet.herokuapp.com/hovers";
	private By avtarLocator=By.xpath("//div[@class='figure']");
	private By viewProfileLinkLocator=By.xpath(".//a[contains(text(),'View profile')]");
	
	public HoverPage(WebDriver  driver,Logger log) {
		super(driver,log);
		}
	public void openPage() {
		openUrl(pageUrl);
	}
	public void openUserProfile(int i) {
		List<WebElement>  avatars= findAll(avtarLocator);
		WebElement specifiedUserAvtar=avatars.get(i-1);
		hoverOverElement(specifiedUserAvtar);
		specifiedUserAvtar.findElement(viewProfileLinkLocator).click();
		
		
		
	}

}
