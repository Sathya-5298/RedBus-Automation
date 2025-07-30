package com.redbus;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedBusAutomationProject2 {

	public static void main(String[] args) throws InterruptedException 
	{
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25L));
		
		driver.get("https://www.redbus.in/"); // Launching Redbus Web Site
	//	driver.manage().window().maximize();
		
		//Focus on From details
		
		By sourceSearchButtonLocator = By.xpath("//div[contains(@class,'inputAndSwapWrapper')]/div[@role=\"button\"]");
	//	WebElement sourceSearchButtonElement = driver.findElement(sourceSearchButtonLocator);
		WebElement sourceSearchButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceSearchButtonLocator));
		sourceSearchButtonElement.click();

		By searchSugeestionSectionLocator = By.xpath("//div[contains(@class,'searchSuggestionWrapper')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchSugeestionSectionLocator));
		
		WebElement searchTextBoxElement = driver.switchTo().activeElement();
		searchTextBoxElement.sendKeys("Hyderabad");
		
		By searchCategoryLocator = By.xpath("//div[contains(@class,'searchCategory')]");
		List<WebElement> searchCategoryList = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(searchCategoryLocator,2));
		System.out.println(searchCategoryList.size());
		
		WebElement locationSearchResult = searchCategoryList.get(0);
		By locationNameLocator = By.xpath(".//div[contains(@class,'listHeader')]");
		List<WebElement> locationList = locationSearchResult.findElements(locationNameLocator);
		System.out.println(locationList.size());
		
		for(WebElement location : locationList)
		{
			String locationName = location.getText();
			
			if(locationName.equalsIgnoreCase("Hyderabad"))
			{
				location.click();
				break;
			}
		}
		
		//Focus on To details
		
		WebElement toTextBoxElement = driver.switchTo().activeElement();
		toTextBoxElement.sendKeys("Vijayawada");
		
		By toSearchCategoryLocator = By.xpath("//div[contains(@class,'searchCategory')]");
		List<WebElement> toSearchCategoryList = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(toSearchCategoryLocator, 2));
		System.out.println(toSearchCategoryList.size());
		
		WebElement toLocationSearchResult = toSearchCategoryList.get(0);
		By toLocationNameLocator = By.xpath(".//div[contains(@class,'listHeader')]");
		List<WebElement> toLocationList = toLocationSearchResult.findElements(toLocationNameLocator);
		System.out.println(toLocationList.size());
		
		for(WebElement toLocation : toLocationList)
		{
			String toLocationText = toLocation.getText();
			
			if(toLocationText.equalsIgnoreCase("Vijayawada"));
			{
				toLocation.click();
				break;
			}
		}
		
		
		
		
	}
}
