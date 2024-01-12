package com.providio.testcases;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Validations.validationpopupMessages;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.productListingPage;
import com.providio.paymentProccess.CreditCardPaymentProcess;
import com.providio.paymentProccess.MinicartViewCartProcess;

import functionality.allAttributesinOneFile;


public class tc__NavigationEachMenuOneItem extends baseClass{
	
	SoftAssert softAssert = new SoftAssert();

	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
    public void Navigation() throws InterruptedException {
        test.info("Test case for the Login Page");
        
        if (isLoggedIn) {
            test.info("Test case for the Navigationmenu of Newarrival Page");
         // Find all the top-level menu items.
            List<WebElement> countofMenus = driver.findElements(By.xpath("//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1']"));

            // Loop through each top-level menu item.
            for (int i = 1; i <= countofMenus.size(); ++i) {
                
                // Find all the submenu items for the current top-level menu item.
                List<WebElement> noelementsofdrop = driver.findElements(By.xpath("(//li[@class='nav-item dropdown'])[" + i + "]//a[@class='dropdown-link']"));
                
             // Create a random number generator.
                Random random = new Random();
                
                // Generate a random index to select a top-level menu item.
                int randomNumbermenu = random.nextInt(noelementsofdrop.size()) + 1;
                

                    Thread.sleep(5000);

                    // Locate and hover over the current top-level menu item.
                    WebElement NavigationMenu = driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]"));
                    Thread.sleep(5000);
                    Actions action = new Actions(driver);
                    action.moveToElement(NavigationMenu).perform();
                    Thread.sleep(5000L);

                    // Locate and click on the current submenu item using JavaScriptExecutor.
                    WebElement NavigationMenuitem = driver.findElement(By.xpath("((//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]/following::a[@role='menuitem'])[" + randomNumbermenu + "]"));
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].click();", new Object[] { NavigationMenuitem });
                    Thread.sleep(5000L);

                 // Check the page title to determine which category was clicked.
                    List<WebElement> newArrivalplp = driver.findElements(By.xpath("(//a[contains(text(), 'New Arrivals')])[2]"));
                    List<WebElement> womensplp = driver.findElements(By.xpath("//li[@class='breadcrumb-item']/a[contains(text(), 'Women')]"));
                    List<WebElement> menplp = driver.findElements(By.xpath("//li[@class='breadcrumb-item']/a[contains(text(), 'Men')]"));
                    //List<WebElement> electronicsplp = driver.findElements(By.xpath("(//a[contains(text(), 'Electronics')])[3]"));

                    // Check which category is displayed based on the page title and random submenu item.
                    if (newArrivalplp.size() > 0) {
                        // Handle the case when "New Arrivals" category is clicked.
                        String[] newArrivalsCategory = {"WOMENS", "MENS", "ELECTRONICS"};
                        WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
                        String pageTitleText = pageTitle.getText();
                        test.info("Verify that New Arrivals of  " + pageTitleText + " ");
                        if (pageTitleText.equals(newArrivalsCategory[randomNumbermenu - 1])) {
                            test.pass("Successfully clicked on the New Arrivals of  " + pageTitleText + " ");
                            logger.info("Click Success New Arrivals of  " + pageTitleText + "");
                        }
                        
                    } else if (womensplp.size() > 0) {
                        // Handle the case when "Womens" category is clicked.
                        String[] womensCategory = {"OUTFITS", "TOPS", "DRESSES", "BOTTOMS", "JACKETS & COATS", "FEELING RED", "EARRINGS", "BRACELETS", "NECKLACES", "SCARVES", "SHOES"};
                        WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
                        String pageTitleText = pageTitle.getText();
                        test.info("Verify that Womens of  " + pageTitleText + " ");
                        if (pageTitleText.equals(womensCategory[randomNumbermenu - 1])) {
                            test.pass("Successfully clicked on the Womens of  " + pageTitleText + " ");
                            logger.info("Click Success Womens of  " + pageTitleText + "");
                        }
                    } else if (menplp.size() > 0) {
                        // Handle the case when "Mens" category is clicked.
                        String[] mensCategory = {"SUITS", "JACKETS & COATS", "DRESS SHIRTS", "SHORTS", "PANTS", "TIES", "GLOVES", "LUGGAGE"};
                        WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
                        String pageTitleText = pageTitle.getText();
                        test.info("Verify that Mens of  " + pageTitleText + " ");
                        if (pageTitleText.equals(mensCategory[randomNumbermenu - 1])) {
                            test.pass("Successfully clicked on the Mens of  " + pageTitleText + " ");
                            logger.info("Click Success Mens of  " + pageTitleText + "");
                        }
                    } else {
                        // Handle the case when "Electronics" category is clicked.
                        String[] electronicsCategory = {"TELEVISIONS", "DIGITAL CAMERAS", "IPOD & MP3 PLAYERS", "GPS NAVIGATION", "GAMING"};
                        WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
                    	String pageTitleText = pageTitle.getText();
                    	test.info("verify that Electronics of  " + pageTitleText + " ");
                    	if (pageTitleText.equals(electronicsCategory[randomNumbermenu-1])) {
                    		test.pass("Successfully clicked on the Electronics of  " + pageTitleText + " ");
                            logger.info("click Success Electronics of  " + pageTitleText + "");
                    	}
                    }
                    
                    //select a product form the products loaded on the product listing page
            		productListingPage plp = new productListingPage(driver);
            		plp.selectProductRandom(driver);

                    //Selecting the attributes
					allAttributesinOneFile.allAttributes();
                    
					Thread.sleep(3000);
                  //validate the product is instock or not
                	validatingInstock.inStockValidation();
                	
                	//validating the product is add to the cart
                	validationpopupMessages.validatingProductisAddtoCart(driver);
            	
                    
                }
            
	        
	        //checkoutProcess
	        
            MinicartViewCartProcess cp = new MinicartViewCartProcess();
            
            cp.checkoutprocess();
            
           //payment process
            
            CreditCardPaymentProcess cc = new CreditCardPaymentProcess();
            
            cc.paymentByCreditCard(); 
            

            
        } else {
            Assert.fail("User not logged in");
        }
        
        // Assert all the soft assertions
        softAssert.assertAll();

    }

}