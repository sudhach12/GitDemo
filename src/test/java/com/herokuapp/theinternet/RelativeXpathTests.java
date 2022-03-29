package com.herokuapp.theinternet;

import org.openqa.selenium.WebDriver;

public class RelativeXpathTests {
	
	
	private String url = "https://practicetestautomation.com/practice-test-exceptions/";


	public void relativeXpathTest() {
		private WebDriver driver;
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		driver.get(url);

		// Find and click 'Add' button to add second row
		WebElement addButton = driver.findElement(By.id("add_btn"));
		addButton.click();

		// Use Explicit wait to wait for the second row to be visible
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']")));

		// Get list of all rows
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='row2']/*[@id='save_btn']"));

		String actualText = null;

		// Iterate over each row in the list
		for (WebElement row : rows) {
			// Get text from label element for each row
			String label = row.findElement(By.xpath(".//label")).getText();
			System.out.println("Label text is: " + label);

			if (label.equals("Row 2")) {
				// If label equals Row 2, type Sushi into input field
				System.out.println("Typing 'sushi' into input field");
				row.findElement(By.xpath(".//input")).sendKeys("Sushi");

				// Save new value by pushing Save button
				driver.findElement(By.xpath("//div[@id='row2']/*[@id='save_btn']")).click();

				// Get new value to use in the assertion
				actualText = row.findElement(By.xpath(".//input")).getAttribute("value");
				break;
			}
		}
		Assert.assertEquals(actualText, "Sushi");


}
