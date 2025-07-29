package com.redbus;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedBusAutomationProject {

	public static void main(String[] args) throws InterruptedException 
	{
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25L));
		
		driver.get("https://www.redbus.in/"); // Launching Redbus Web Site
	//	driver.manage().window().maximize();
		
		By sourceSearchButtonLocator = By.xpath("//div[contains(@class,'inputAndSwapWrapper')]/div[@role=\"button\"]");
	//	WebElement sourceSearchButtonElement = driver.findElement(sourceSearchButtonLocator);
		WebElement sourceSearchButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceSearchButtonLocator));
		sourceSearchButtonElement.click();

		By searchSugeestionSectionLocator = By.xpath("//div[contains(@class,'searchSuggestionWrapper')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchSugeestionSectionLocator));
		WebElement searchTextBoxElement = driver.switchTo().activeElement();
		searchTextBoxElement.sendKeys("Hyderabad");
		
		
		
		
	}
}
