package com.redbus;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		
		locationsSelection(driver, wait, "Hyderabad");
		locationsSelection(driver, wait, "Vijayawada");
		
		By searchButtonLocator = By.xpath("//button[contains(@class,'searchButtonWrapper')]");
		WebElement searchButton =  wait.until(ExpectedConditions.elementToBeClickable(searchButtonLocator));
		searchButton.click();
		
		
		
		By primoButtonLocator = By.xpath("//div[contains(text(),'Primo Bus')]");
		WebElement primoButton =  wait.until(ExpectedConditions.elementToBeClickable(primoButtonLocator));
		primoButton.click();
		
		By eveningButtonLocator = By.xpath("//div[contains(text(),'18:00-24:00 ')]");
		WebElement eveningButton =  wait.until(ExpectedConditions.elementToBeClickable(eveningButtonLocator));
		eveningButton.click();
		
		Thread.sleep(2500);
		
		By subTitleLocator = By.xpath("//span[contains(@class,'subtitle')]");
		WebElement subTitle =  null;
		subTitle =  wait.until(ExpectedConditions.visibilityOfElementLocated(subTitleLocator));

		System.out.println(subTitle.getText());
		
		By busTuppleWrapLocator = By.xpath("//li[contains(@class,'tupleWrapper')] ");
		By busesNameLocator = By.xpath(".//div[contains(@class,'travelsName')] ");
		List<WebElement> rowList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(busTuppleWrapLocator));
		System.out.println("Total Buses are - " + rowList.size());
		
		for(WebElement row: rowList)
		{
			System.out.println(row.findElement(busesNameLocator).getText());
		}
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView({behaviour:'smooth'})", rowList.get(rowList.size() - 2));
		
		List<WebElement> newRowList = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(busTuppleWrapLocator, rowList.size()));
		System.out.println("Total Buses are - " + newRowList.size());
		
	}

	private static void locationsSelection(WebDriver driver, WebDriverWait wait, String cityLocationName) {
		WebElement searchTextBoxElement = driver.switchTo().activeElement();
		searchTextBoxElement.sendKeys(cityLocationName);
		
		By searchCategoryLocator = By.xpath("//div[contains(@class,'searchCategory')]");
		List<WebElement> searchCategoryList = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(searchCategoryLocator,2));
		
		WebElement locationSearchResult = searchCategoryList.get(0);
		By locationNameLocator = By.xpath(".//div[contains(@class,'listHeader')]");
		List<WebElement> locationList = locationSearchResult.findElements(locationNameLocator);
		
		for(WebElement location : locationList)
		{
			String locationName = location.getText();
			
			if(locationName.equalsIgnoreCase(cityLocationName))
			{
				location.click();
				break;
			}
		}
	}
}
