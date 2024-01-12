package com.providio.testcases;


import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice2 {

	public static WebDriver driver;
	@Test
	 private void initializeDriver() throws InterruptedException {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://zzqi-002.dx.commercecloud.salesforce.com/s/RefArch/mens/clothing/jackets%20%26%20coats/?lang=en_US");
	        
	       
            
	        List<WebElement> allProduct =driver.findElements(By.xpath("//img[@class='tile-image']"));
	        int countOfProducts= allProduct.size();
	        try {
	        for(int i=1; i<=1;i++) {
	        	 Thread.sleep(3000);
	        	 WebElement product =driver.findElement(By.xpath("(//img[@class='tile-image'])["+i+"]"));	        	
	        	 Actions action = new Actions(driver);
				 action.moveToElement(product).perform();
				 Thread.sleep(2000);				 
				 WebElement  addToBagbutton =driver.findElement(By.xpath("(//a[@data-addtocart='Add to Bag'])["+i+"]"));
				 
				 if(addToBagbutton.isDisplayed()) {					 
					 addToBagbutton.click();
					 
				 //Find the div containing the list using XPath.
			        WebElement divElement = driver.findElement(By.xpath("//div[@class='plp-size-list js-plp-size-list']"));
			        if(divElement.isDisplayed()) {
			        	
				        // Find all the list items (li tags) within the div using XPath.
				        List<WebElement> listItems = divElement.findElements(By.xpath(".//li"));
		
				        // Get the total number of list items.
				        int totalItems = listItems.size();
				        
				        // Generate a random number between 0 and the total number of list items.
				        Random random = new Random();
				        int randomIndex = random.nextInt(totalItems);
		
				        // Get the link (a tag) corresponding to the randomly selected index.
				        WebElement randomLink = listItems.get(randomIndex).findElement(By.tagName("a"));
		
				        // Click on the randomly selected link.
				        Thread.sleep(2000);
				        
				        randomLink.click();
			        }
				        Thread.sleep(1000);
				        WebElement addToBagAfterSizeSelected1 = driver.findElement(By.xpath("//a[@class='btn btn-outline-primary add-to-cart js-pt-add-to-cart hidden-md-down w-50 success-color']"));
				        WebElement addToBag1 = addToBagAfterSizeSelected1.findElement(By.xpath("(//span[contains(text(),'Add to Bag')])["+i+"]"));
				        if(addToBag1.isDisplayed()) {
				        	Thread.sleep(1000);
					        WebElement addToBagAfterSizeSelected = driver.findElement(By.xpath("//a[@class='btn btn-outline-primary add-to-cart js-pt-add-to-cart hidden-md-down w-50 success-color']"));
					        WebElement addToBag2 = addToBagAfterSizeSelected.findElement(By.xpath("(//span[contains(text(),'Add to Bag')])["+i+"]"));
					        Thread.sleep(1000);
				       
					        System.out.println("Product add to cart");
					        JavascriptExecutor js = (JavascriptExecutor)driver;
							//js.executeScript("arguments[0].click();", addToBag1);
					        addToBag1.click();
					        Thread.sleep(6000);
				        }else {
				        	System.out.println("Product is out of stock");
				        }
				   //   
				        
				 }else if(driver.findElements(By.xpath("(//span[contains(text(),'Add to Bag')])["+i+"]")).size()!=0) {
					 
					   Thread.sleep(3000);
					   // Find the parent div element containing the anchor tag with the specified class using XPath.
				        WebElement parentDiv = driver.findElement(By.xpath("//div[@class='d-flex flex-row']//a[2]"));

				        // Find the child div element within the parent div using XPath.
				        WebElement childDiv = parentDiv.findElement(By.xpath(".//span[@class='button-content']"));
				        JavascriptExecutor js = (JavascriptExecutor)driver;
						js.executeScript("arguments[0].click();", childDiv);
				       // childDiv .click();
//					   WebElement addToBagAfterSizeSelected = driver.findElement(By.xpath("//a[@class='btn btn-outline-primary add-to-cart js-pt-add-to-cart hidden-md-down w-50 success-color']"));
//					   WebElement directAddToBagButton=addToBagAfterSizeSelected.findElement(By.xpath("(//span[contains(text(),'Add to Bag')])["+i+"]")) ; 
//					   directAddToBagButton.click();
					   System.out.println("Directly added to cart from plp");
					   Thread.sleep(5000);
					   
				 }         
	      }
	      
		}catch(MoveTargetOutOfBoundsException e){
			System.out.println(e);
		}
		
	}	
	
}
