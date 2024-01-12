package functionality;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.providio.Validations.validationpopupMessages;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.productListingPage;
import com.providio.testcases.baseClass;

import pageObjects.ProductListingPage;
import pageObjects.homepage;
import validations.ProductListingPageValidations;

public class allAttributesSelection extends baseClass{
	
	
	private static homepage homePage = new homepage(driver);
	private static ProductListingPage PLP = new ProductListingPage(driver);
	
	
	public static void selectTheAttributesInPdp(WebDriver driver) throws InterruptedException {

		//selecting attributes
		allAttributes();
	    Thread.sleep(2000);
	     productDescriptionPage pdp = new productDescriptionPage(driver);
	     WebElement cartEnabled =driver.findElement(By.xpath("//button[contains(@class,'add-to-cart')]"));
	     List<WebElement> inStock =driver.findElements(By.xpath("//div[contains(text(), 'In Stock')]"));
	     if(cartEnabled.isEnabled()&& inStock.size()>0) {
		     pdp.clickcartbutton(driver);    
	     }else {
	    	 System.out.println("Product is out of stock so searching for new product");
            //selecting a random menu
	    	 navigationPage navPage =new navigationPage(driver);
	    	 navPage.selectRandomMenu(driver);

	    	//selecting a random product in the plp page
	    	 productListingPage plp = new productListingPage(driver);
	    	 plp.selectProductRandom(driver);
	
	    	 //Reselecting the all attributes
	    	 selectTheAttributesInPdp(driver);
	    	 
	    	//validating the product is add to the cart
	  	    validationpopupMessages.validatingProductisAddtoCart(driver);  
	     }	     
	}

	public static void allAttributes() throws InterruptedException {
		
		List <WebElement> mainDiv= driver.findElements(By.xpath("//div[@class='attributes px-0']"));
		logger.info("The total number of size division are " +mainDiv.size());
		List<WebElement> colorElement = driver.findElements(By.xpath("//select[contains(@class,'select-color-swatch')]"));
		logger.info("The colordrop down count is " + colorElement.size());
		List<WebElement> sizeElement = driver.findElements(By.xpath("//select[contains(@class,'select-size')]"));
		logger.info("The size drop down count  is " +  sizeElement.size());
		List<WebElement> memoryElement = driver.findElements(By.id("memorySize-null"));
		List<WebElement> widthElements = driver.findElements(By.xpath("//select[contains(@class,'select-width')]"));
		logger.info(widthElements.size());
	    List<WebElement> showName = driver.findElements(By.xpath("//select[contains(@class,'select-showName')]"));
	    logger.info(showName.size());
	    //another way of attributes 
	     List<WebElement> sizeBox= driver.findElements(By.xpath("//div[contains(@class, 'select-size')]"));
	     List<WebElement> colorBox= driver.findElements(By.xpath("//button[contains(@class,'color-attribute')]"));
	     List<WebElement> memoryBox = driver.findElements(By.xpath("//div[contains(@class, 'select-memorySize')]"));
		 List<WebElement> widthBox = driver.findElements(By.xpath("//div[contains(@class, 'select-width')]"));
		 List<WebElement> showNameBox= driver.findElements(By.cssSelector(".showName"));
		 List<WebElement> extendedWarranty = driver.findElements(By.className("options-select"));
	     
	     for(int i=1; i<=mainDiv.size();i++) {
	    	    test.info("Verified that Attributes are Selected");
				if(colorElement.size()>0|| colorBox.size()>0) {
					attributesSelection.colorSelection();
					logger.info("selected color");
					test.pass("Successfully selected the Color attribute");
					Thread.sleep(1000);
				}if(sizeElement.size()>0|| sizeBox.size()>0 ) {
					attributesSelection.sizeSelction();
					logger.info("selected size");
					test.pass("Successfully selected the Size attribute");
					Thread.sleep(1000);					
				} if(memoryElement.size()>0||  memoryBox.size()>0) {
					attributesSelection.memorySelection();
					logger.info("selected memory size");
					test.pass("Successfully selected the Memory Size attribute");
					Thread.sleep(1000);
				} if(widthElements.size()>0 || widthBox.size()>0) {	
					attributesSelection.widthSelection();
					logger.info("selected width");
					test.pass("Successfully selected the Width attribute");
					Thread.sleep(1000);
				}if(showName.size()>0 || showNameBox.size()>0) {
					Thread.sleep(1000);
					attributesSelection.selectShowName();
					logger.info("Selected show name ");
				}if(extendedWarranty.size()>0) {
					attributesSelection.selectExtendedWarranty();
					test.pass("Successfully selected the extended warranty attribute");
					logger.info("Selected extended warranty ");
				}
	     }
	     
	}
	
	public static void selectTheAttributesInQuickShop() throws InterruptedException {
		//slect the filters
		quickshopallAttributes();
		Thread.sleep(3000);
		List<WebElement> InStock = driver.findElements(By.xpath("//div[text()='In Stock']"));
		if(InStock.size()>0) {
			logger.info("Product is in stock");
		}else {
			//Actionsss.click(homePage.getCookies_Yes_Btn());
			homePage.selectRandomMegaMenu(driver);
			Thread.sleep(4000);
			PLP.selectthequickshope();
			ProductListingPageValidations.verifyPLPQuickshopClick();
			selectTheAttributesInQuickShop();
		}
	}
	
	public static void quickshopallAttributes() throws InterruptedException {
		
		List<WebElement> colorElement = driver.findElements(By.xpath("//select[contains(@class,'select-color-swatch')]"));
		System.out.println("The colordrop down count is " + colorElement.size());
		
		List<WebElement> sizeElement = driver.findElements(By.xpath("//select[contains(@class,'select-size')]"));
		System.out.println("The size drop down count  is " +  sizeElement.size());
		
		List<WebElement> memoryElement = driver.findElements(By.id("memorySize-null"));
		
		 List<WebElement> widthElements = driver.findElements(By.xpath("//select[contains(@class,'select-width')]"));
	     System.out.println(widthElements.size());
	     
	     List<WebElement> showName = driver.findElements(By.xpath("//select[contains(@class,'select-showName')]"));
	     System.out.println(showName.size());
	     
	     //another way of attributes
	     
	     List<WebElement> sizeBox= driver.findElements(By.xpath("//div[contains(@class, 'select-size')]"));
	     	     	 	
	     List<WebElement> colorBox= driver.findElements(By.xpath("//button[contains(@class,'color-attribute')]"));
	     
	     List<WebElement> memoryBox = driver.findElements(By.xpath("//div[contains(@class, 'select-memorySize')]"));
	     
		 List<WebElement> widthBox = driver.findElements(By.xpath("//div[contains(@class, 'select-width')]"));
		
		 List<WebElement> showNameBox= driver.findElements(By.cssSelector(".showName"));
		 
		 List<WebElement> extendedWarranty = driver.findElements(By.className("options-select"));
		 
		
		 
	     
	     test.info("Verified that Attributes are Selected");
			if(colorElement.size()>0|| colorBox.size()>0) {
				attributesSelection.colorSelection();
				logger.info("selected color");
				test.pass("Successfully selected the Color attribute");
				Thread.sleep(1000);
			}if(sizeElement.size()>0|| sizeBox.size()>0 ) {
				attributesSelection.sizeSelction();
				logger.info("selected size");
				test.pass("Successfully selected the Size attribute");
				Thread.sleep(1000);					
			} if(memoryElement.size()>0||  memoryBox.size()>0) {
				attributesSelection.memorySelection();
				logger.info("selected memory size");
				test.pass("Successfully selected the Memory Size attribute");
				Thread.sleep(1000);
			} if(widthElements.size()>0 || widthBox.size()>0) {	
				attributesSelection.widthSelection();
				logger.info("selected width");
				test.pass("Successfully selected the Width attribute");
				Thread.sleep(1000);
			}if(showName.size()>0 || showNameBox.size()>0) {
				Thread.sleep(1000);
				attributesSelection.selectShowName();
				logger.info("Selected show name ");
			}if(extendedWarranty.size()>0) {
				attributesSelection.selectExtendedWarranty();
				test.pass("Successfully selected the extended warranty attribute");
				logger.info("Selected extended warranty ");
			}
			
			
	     }
	
	}


