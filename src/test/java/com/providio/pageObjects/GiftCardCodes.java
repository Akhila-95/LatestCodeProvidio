package com.providio.pageObjects;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;

import com.providio.testcases.baseClass;

public class GiftCardCodes extends baseClass{

	public List<String> readDataFromExcel(String filePath, String sheetName) throws IOException {

		List<String> data = new ArrayList<String>();
		FileInputStream file = new FileInputStream(new File(filePath));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		boolean isFirstRow = true; // Flag to skip the first row

	    for (Row row : sheet) {
	        // Skip the first row
	        if (isFirstRow) {
	            isFirstRow = false;
	            continue;
	        }

	        for (Cell cell : row) {
	            String stringValue = cell.toString();
	            data.add(stringValue);
	        }
	    }

		workbook.close();
		return data;
	}
// to pick the GC code randomly
	public void performRandomOperations(WebDriver driver) throws InterruptedException {
		//driver.get(baseURL);
		//logger.info("enterd into url");
		String filePath = "C:\\Users\\user\\eclipse-workspace\\July7TH\\proVidioETG\\testData\\GiftCertificateCodes.xlsx";
		String sheetName = "GC_Codes";

		try {
				List<String> dataList = readDataFromExcel(filePath, sheetName);
				int totalProducts = dataList.size();
			
			    // Remove spaces from each element in the dataList
			    for (int i = 0; i < dataList.size(); i++) {
			        String element = dataList.get(i);
			        element = element.replace(" ", "");
			        dataList.set(i, element);
			    }
	
			    // Remove the empty strings from the list
		        dataList.removeIf(String::isEmpty);
	
		        // Concatenate the elements of the list without the comma
		        String joinedData = String.join(", ", dataList);
				System.out.println(dataList);
				
				int operations = 0;
				   Set<String> pickedValues = new HashSet<>();

				while (true) {
					 String randomValue = pickRandomValueWithoutDuplicate(dataList, pickedValues);
		                System.out.println(randomValue);
					if (randomValue == null) {
						System.out.println("No data found");
						break; // No more values to pick
					}
					if (randomValue != null) {
						
					JavascriptExecutor js = (JavascriptExecutor) driver;				
					WebElement giftcertificate = driver.findElement(By.xpath("//input[@id='giftCert']"));
					js.executeScript("arguments[0].click();", giftcertificate);	
					giftcertificate.sendKeys(randomValue);
					Thread.sleep(2000);
						
						  
	            //check balance validation and checking the bal of GC
	             WebElement checkBalButton= driver.findElement(By.xpath("//button[@class='btn btn-primary check-balance']"));
	             test.info("Verifying check balance button");
	             Actions actions = new Actions(driver);
	                // Scroll down by 500 pixels
	                actions.scrollByAmount(0, 500).perform();	                
	                js.executeScript("arguments[0].click();",checkBalButton);
	                //checkBalButton.click();
	                Thread.sleep(2000);
	                WebElement checkBal= driver.findElement(By.xpath("//div[@class='balance success']"));
	                logger.info(checkBal.getText()); 
		                if(checkBalButton.isDisplayed()) {
		                	
	                	test.pass("Check button is enabled and selected");
		                	logger.info("Check button is enabled and selected");
		                }else {
		                	test.fail("Check button is not enabled and not selected");
		                	logger.info("Check button is  not enabled and selected");
		                }
	                
	            // Click the apply button by passing GC
	            try {
	            	Thread.sleep(2000);
	            	js.executeScript("arguments[0].click();", giftcertificate);	
					giftcertificate.sendKeys(randomValue);
		            Thread.sleep(2000);
		            
	                WebElement applyGiftCard = driver.findElement(By.xpath("//button[@value='submit-gifrcert']"));
	                Thread.sleep(3000);	              
	                // Scroll down by 500 pixels
	                actions.scrollByAmount(0, 500).perform();
	             
	                // apply button validation
	                test.info("Verifying apply button is selected");
	                if(applyGiftCard.isDisplayed()) {
	                	    js.executeScript("arguments[0].click();", applyGiftCard);
	                	    test.pass("Apply button is selected");
	                	    logger.info("Apply button is selected");
	              
			                Thread.sleep(2000);
								if(driver.findElements(By.xpath("//div[contains(text(),'Insufficient Gift Certificate balance')]")).size()!=0) {
									System.out.println("Insufficent funds in this " +randomValue + " gift card" );
									giftcertificate.clear();
								}else if(driver.findElements(By.xpath("//div[contains(text(),'Gift card belongs to a different customer')]")).size()!=0){
									System.out.println("This " + randomValue + "Gift Card belongs to different customer ");
									giftcertificate.clear();
								}
								
						        if (driver.findElements(By.xpath("//div[contains(text(),'Your order has no balance, so no payment method is necessary to complete this order')]")).size()!=0) {
							    	 System.out.println("Your order has no balance,so no payment method is necessary");
							    	 giftcertificate.clear();
							    	 break;
						        } else {
							        	
						        	dataList.remove(randomValue);
									System.out.println(" After applying GC we have this in datalist"+ dataList);
							    	    Thread.sleep(5000);
										operations++;	
								     }
							 
						
							}
	                 } catch (NoSuchElementException e) {
				  				System.out.println("Element not found: " + e.getMessage());
							}  
					}				
			  }
					System.out.println("Total data: " + totalProducts);
					System.out.println("Total operations performed: " + operations);
		  }catch (IOException e) {
		
				e.printStackTrace();
	   }			
	}
	
	private String pickRandomValueWithoutDuplicate(List<String> dataList, Set<String> pickedValues) {
        Random random = new Random();
        int index = random.nextInt(dataList.size());

        String randomValue = dataList.get(index);
        if (pickedValues.contains(randomValue)) {
            // All values have been picked, return null
            if (pickedValues.size() == dataList.size()) {
                return null;
            }
            // Recursively pick another value
            return pickRandomValueWithoutDuplicate(dataList, pickedValues);
        } else {
            // Add the picked value to the set
            pickedValues.add(randomValue);
            return randomValue;
        }
    }

	
	// to pick the GC code sequentially
	
	public void performSequentialOperations(WebDriver driver) throws InterruptedException {
	    String filePath = "C:\\Users\\user\\eclipse-workspace\\July7TH\\proVidioETG\\testData\\GiftCertificateCodes.xlsx";
	    String sheetName = "GC_Codes";

	    try {
	        List<String> dataList = readDataFromExcel(filePath, sheetName);
	        int totalProducts = dataList.size();
	        
	     // Remove spaces from each element in the dataList
		    for (int i = 0; i < dataList.size(); i++) {
		        String element = dataList.get(i);
		        element = element.replace(" ", "");
		        dataList.set(i, element);
		    }

		    // Remove the empty strings from the list
	        dataList.removeIf(String::isEmpty);

	        // Concatenate the elements of the list without the comma
	        String joinedData = String.join(", ", dataList);
			System.out.println(dataList);
	        int operations = 0;
	      	 Iterator<String> iterator = dataList.iterator();
	      	 
	        while (iterator.hasNext()) {
	            String value = iterator.next();
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            WebElement giftCertificate = driver.findElement(By.xpath("//input[@id='giftCert']"));
	            js.executeScript("arguments[0].click();", giftCertificate);
	            giftCertificate.sendKeys(value);
	            Thread.sleep(2000);

	            
	            //check balance validation and checking the bal of GC
	             WebElement checkBalButton= driver.findElement(By.xpath("//button[@class='btn btn-primary check-balance']"));
	             test.info("Verifying check balance button");
	             Actions actions = new Actions(driver);
	                // Scroll down by 500 pixels
	                actions.scrollByAmount(0, 500).perform();	                
	                js.executeScript("arguments[0].click();",checkBalButton);
	                //checkBalButton.click();
	                Thread.sleep(2000);
	                WebElement checkBal= driver.findElement(By.xpath("//div[@class='balance success']"));
	                logger.info(checkBal.getText()); 
	                if(checkBalButton.isDisplayed()) {
	                	
                	test.pass("Check button is enabled and selected");
	                	logger.info("Check button is enabled and selected");
	                }else {
	                	test.fail("Check button is not enabled and not selected");
	                	logger.info("Check button is  not enabled and selected");
	                }
	                
	            // Click the apply button by passing GC
	            try {
	            	Thread.sleep(2000);
	            	js.executeScript("arguments[0].click();", giftCertificate);
		            giftCertificate.sendKeys(value);
		            Thread.sleep(2000);
		            
	                WebElement applyGiftCard = driver.findElement(By.xpath("//button[@value='submit-gifrcert']"));
	                Thread.sleep(3000);	              
	                // Scroll down by 500 pixels
	                actions.scrollByAmount(0, 500).perform();
	             
	                // apply button validation
	                test.info("Verifying apply button is selected");
	                if(applyGiftCard.isDisplayed()) {
	                	    js.executeScript("arguments[0].click();", applyGiftCard);
	                	    test.pass("Apply button is selected");
	                	    logger.info("Apply button is selected");
	              
			                Thread.sleep(2000);
			                if (driver.findElements(By.xpath("//div[contains(text(),'Insufficient Gift Certificate balance')]")).size() != 0) {
			                    System.out.println("Insufficient funds in this " + value + " gift card");
			                    giftCertificate.clear();
			                } else if (driver.findElements(By.xpath("//div[contains(text(),'Gift card belongs to a different customer')]")).size() != 0) {
			                    System.out.println("This " + value + " Gift Card belongs to a different customer");
			                    giftCertificate.clear();
			                }
		
			                if (driver.findElements(By.xpath("//div[contains(text(),'Your order has no balance, so no payment method is necessary to complete this order')]")).size() != 0) {
			                    System.out.println("Your order has no balance, so no payment method is necessary");
			                    giftCertificate.clear();
			                    break;
			                } else {
			                    iterator.remove(); // Safely remove the element from the list
			                    System.out.println("After applying GC we have this in datalist: " + dataList);
			                    Thread.sleep(5000);
			                    operations++;
			                }
           
	                }else {
	                	test.fail("Apply button is not  selected");
	                	logger.info("Apply button is not selected");
	                }
	             
	                
	            } catch (NoSuchElementException e) {
	                System.out.println("Element not found: " + e.getMessage());
	            }
	        }

	        System.out.println("Total data: " + totalProducts);
	        System.out.println("Total operations performed: " + operations);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	//TO PLACE THE ORDER BY GC AND CC
	public void paymentBySemiGC () throws InterruptedException {
		String filePath = "C:\\Users\\user\\eclipse-workspace\\July7TH\\proVidioETG\\testData\\GiftCertificateCodes.xlsx";
	    String sheetName = "GC_Codes";

	    try {
	        List<String> dataList = readDataFromExcel(filePath, sheetName);
	        int totalProducts = dataList.size();
	        
	     // Remove spaces from each element in the dataList
		    for (int i = 0; i < dataList.size(); i++) {
		        String element = dataList.get(i);
		        element = element.replace(" ", "");
		        dataList.set(i, element);
		    }

		    // Remove the empty strings from the list
	        dataList.removeIf(String::isEmpty);

	        // Concatenate the elements of the list without the comma
	        String joinedData = String.join(", ", dataList);
			System.out.println(dataList);
	        int operations = 0;
	      	 Iterator<String> iterator = dataList.iterator();
	      	 
	        while (iterator.hasNext()) {
	            String value = iterator.next();
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            WebElement giftCertificate = driver.findElement(By.xpath("//input[@id='giftCert']"));
	            js.executeScript("arguments[0].click();", giftCertificate);
	            giftCertificate.sendKeys(value);
	            Thread.sleep(2000);

	            
	            //check balance validation and checking the bal of GC
	             WebElement checkBalButton= driver.findElement(By.xpath("//button[@class='btn btn-primary check-balance']"));
	             test.info("Verifying check balance button");
	             Actions actions = new Actions(driver);
	                // Scroll down by 500 pixels
	                actions.scrollByAmount(0, 500).perform();	                
	                js.executeScript("arguments[0].click();",checkBalButton);
	                //checkBalButton.click();
	                Thread.sleep(2000);
	                WebElement checkBal= driver.findElement(By.xpath("//div[@class='balance success']"));
	                logger.info(checkBal.getText()); 
	                if(checkBalButton.isDisplayed()) {
	                	
                	test.pass("Check button is enabled and selected");
	                	logger.info("Check button is enabled and selected");
	                }else {
	                	test.fail("Check button is not enabled and not selected");
	                	logger.info("Check button is  not enabled and selected");
	                }
	                
	            // Click the apply button by passing GC
	            try {
	            	Thread.sleep(2000);
	            	js.executeScript("arguments[0].click();", giftCertificate);
		            giftCertificate.sendKeys(value);
		            Thread.sleep(2000);
		            
	                WebElement applyGiftCard = driver.findElement(By.xpath("//button[@value='submit-gifrcert']"));
	                Thread.sleep(3000);	              
	                // Scroll down by 500 pixels
	                actions.scrollByAmount(0, 500).perform();
	             
	                // apply button validation
	                test.info("Verifying apply button is selected");
	                if(applyGiftCard.isDisplayed()) {
	                	    js.executeScript("arguments[0].click();", applyGiftCard);
	                	    test.pass("Apply button is selected");
	                	    logger.info("Apply button is selected");
	              
			                Thread.sleep(2000);
			                if (driver.findElements(By.xpath("//div[contains(text(),'Insufficient Gift Certificate balance')]")).size() != 0) {
			                    System.out.println("Insufficient funds in this " + value + " gift card");
			                    giftCertificate.clear();
			                } else if (driver.findElements(By.xpath("//div[contains(text(),'Gift card belongs to a different customer')]")).size() != 0) {
			                    System.out.println("This " + value + " Gift Card belongs to a different customer");
			                    giftCertificate.clear();
			                }
	
		                
		                List<WebElement> gcText= driver.findElements(By.xpath("//div[@class='success giftcert-pi']"));
		                int sizeOfGc = gcText.size();
		                if (sizeOfGc==1) {
		                    System.out.println("Gift certificate codes are applied");
		                   // giftCertificate.clear();
		                    break;
		                } else {
		                    iterator.remove(); // Safely remove the element from the list
		                    System.out.println("After applying GC we have this in datalist: " + dataList);
		                    Thread.sleep(5000);
		                    operations++;
		                }
           
	                }else {
	                	test.fail("Apply button is not  selected");
	                	logger.info("Apply button is not selected");
	                }
	             
	                
	            } catch (NoSuchElementException e) {
	                System.out.println("Element not found: " + e.getMessage());
	            }
	        }

	        System.out.println("Total data: " + totalProducts);
	        System.out.println("Total operations performed: " + operations);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
