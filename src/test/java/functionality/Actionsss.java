package functionality;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.providio.testcases.baseClass;

import pageObjects.ProductListingPage;



public class Actionsss extends baseClass{
	
	 private static ProductListingPage PLP = new ProductListingPage(driver);

	static int addtoBagRandomIndex = 0;
		 //to hower the action
		 public static void hover(WebElement element) {
		        Actions actions = new Actions(driver);
		        actions.moveToElement(element).perform();
		 }

		 // To click any button 
		 public static void waitAndClick(WebElement element){		   
			 Waits.WaitForClickableElement(element);
			 element.click();  
			    	   
		   }
		 // To select value from select drop down
		 public static void selectValue(WebElement element, String value){
			 Select select = new Select(element);
			 select.selectByValue(value);
		 }
		 

		 // To select value from select drop down
			 public static void selectValue(WebElement element){	
			        // Creating a Select object
			        Select dropdown = new Select(element);
	 
			        // Get the list of options
			        int numberOfOptions = dropdown.getOptions().size();
	 
			        // Generate a random index within the range of available options
			        int randomIndex = new Random().nextInt(numberOfOptions);
	 
			        // Select the option at the random index
			        dropdown.selectByIndex(randomIndex);
	 
			        // Get the value of the randomly selected option
			        String selectedOptionValue = dropdown.getFirstSelectedOption().getAttribute("value");
			        logger.info("Value of the randomly selected option: " + selectedOptionValue);
			       test.pass(" The randomly selected option: " + selectedOptionValue);
	 
			 }
		 // for force click 
		 public static void javascriptClick(WebElement element) throws Exception{
				
			 Thread.sleep(1000);
			 JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].click();",element);
			
		}
		 
		// Clear text from an input field
		    public static void clearText(WebElement element) throws Exception {
		        element.clear();
		    }

		    // Scroll to the bottom of the page
		    public static void scrollBottom() {
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		    }

		    // Scroll an element into view with its center aligned
		    public static void scrollIntoViewCenter(WebElement ele) {
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ele);
		    }

		    // Scroll the window by a specified pixel value
		    public static void scrollWindowsByPixel(int value) {
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("window.scrollBy(0, arguments[0])", value);
		    }

		    protected static String locatorNameText = "";

		    // Scroll an element into view
		    public static void scrollByVisibillity(WebDriver driver, WebElement ele) {
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("arguments[0].scrollIntoView();", ele);
		    }

		 // Click on an element and log the result
		    public static void CombinedClick(WebElement locatorName) throws InterruptedException {
		        try {
		            locatorName.click();
		            Thread.sleep(1000);
//		            test.pass("Successfully clicked on " + locatorName.getText());
		            Thread.sleep(4000);
		        } catch (Exception e) {
		        	JavascriptExecutor executor = (JavascriptExecutor) driver;
		            executor.executeScript("arguments[0].click();", locatorName);
		            System.err.println("Exception while clicking the element: " + e.getMessage());
		        }
		    }
		    // Click on an element and log the result
		    public static void click(WebElement locatorName) throws InterruptedException {
		        try {
		            locatorName.click();
		            Thread.sleep(1000);
//		            test.pass("Successfully clicked on " + locatorName.getText());
		            Thread.sleep(4000);
		        } catch (Exception e) {
		            System.err.println("Exception while clicking the element: " + e.getMessage());
		        }
		    }

		    // Check if a list of elements has a size greater than 0
		    public static boolean elementSize(List<WebElement> locatorName) throws InterruptedException {
		        boolean flag = false;
		        int size = 0;
		        try {
		            size = locatorName.size();
		            logger.info("The count of the element is " + locatorName.size());
		            flag = true;
		        } catch (Exception e) {
		            flag = false;
		        }
		        return size > 0;
		    }

		    // Scroll into view and click an element using JavaScriptExecutor
		    public static void scrollIntoCenterView(WebElement element) {
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

		    }

		    // Check if an element is displayed
		    public static boolean displayElement(WebElement ele) {
		        try {
		            return ele.isDisplayed();
		        } catch (NoSuchElementException e) {
		            return false;
		        }
		    }

		    // Check if an element is enabled
		    public static boolean enabledElement(WebElement ele) {
		        try {
		            return ele.isEnabled();
		        } catch (NoSuchElementException e) {
		            return false;
		        }
		    }

		    // Get the size of a list of elements
		    public static int getSizeOfList(List<WebElement> ele) {
		        int size = 0;
		        try {
		            size = ele.size();
		        } catch (Exception e) {

		        }
		        return size;
		    }

		    // Get the text of an element
		    public static String getTextOfElement(WebElement locatorName) {
		        String locatorNameText = "";
		        try {
		            locatorNameText = locatorName.getText();
		            logger.info(locatorNameText);
		            //Thread.sleep(1000);
		        } catch (Exception e) {
		            //e.printStackTrace();
		        }
		        return locatorNameText;
		    }

		    // Perform a mouse hover action on an element
		    public static void mouseOverElement(WebElement element) {
		        try {
		            new Actions(driver).moveToElement(element).build().perform();
		            Thread.sleep(1000);
		            logger.info("Hovered on element ");

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }

		    // Send keys to an element after clearing its existing content
		    public static boolean sendKeys(WebElement ele, String value, String elementName) throws InterruptedException {
		        Thread.sleep(2000);
		        boolean flag = false;
		        try {
		        	test.info("Verify " + elementName +" of sendKeys");
		            ele.clear();
		            ele.sendKeys(value);
		            logger.info("Successfully send keys of "+elementName);
		            test.pass("Successfully send keys of "+elementName);
		            flag = true;
		            return true;
		        } catch (Exception e) {
		            logger.info(" keys not send to ");
		            return false;
		        }
		    }
		    
		 // Send keys to an element after clearing its existing content
		    public static boolean SendKeys(WebElement ele, int input, String elementName) throws InterruptedException {
		        Thread.sleep(2000);
		        boolean flag = false;
		        try {
		        	test.info("Verify " + elementName +" of sendKeys");
		            ele.clear();
		            ele.sendKeys(Integer.toString(input));
		            ele.sendKeys(Keys.ENTER);
		            logger.info("Successfully send keys of " + elementName);
		            test.pass("Successfully send keys of " + elementName);
		            flag = true;
		            return true;
		        } catch (Exception e) {
		            logger.info("Keys not sent to " + elementName);
		            return false;
		        }
		    }
		    // Switch to a frame by its ID
		    public static boolean switchToFrameById(WebElement ele) {
		        boolean flag = false;
		        try {
		            driver.switchTo().frame(ele);
		            logger.info("frame with id ");
		            flag = true;
		            return true;
		        } catch (Exception e) {
		            return false;
		        }
		    }

		    // Switch back to the default content
		    public static boolean switchToDefault() {
		        boolean flag = false;
		        try {
		            driver.switchTo().defaultContent();
		            logger.info("switched to default ");
		            flag = true;
		            return true;
		        } catch (Exception e) {
		            return false;
		        }
		    }

		    // Enter a random address from a dropdown
		    public static void addressFromDropDown(WebElement locatorName) throws InterruptedException {
		        Random random = new Random();
		        int randomNumber = 123; // Generates a random number between 100 and 999
		    //    random.nextInt(900) + 100;
		        addresses = String.valueOf(randomNumber);
		        Thread.sleep(1000);
		        locatorName.sendKeys(addresses);

		        // to perform the keyboard activities
		        WebElement shipping = driver.switchTo().activeElement();

		        Thread.sleep(1000);
		        shipping.sendKeys(Keys.ARROW_DOWN);

		        shipping.sendKeys(Keys.ENTER);

		        String shippingaddress = locatorName.getAttribute("value");
		        System.out.println("The address entered is " + shippingaddress);
		        logger.info("The address entered is " + shippingaddress);
		        test.info("The address entered is " + shippingaddress);
		    }
		    
		    public static void scrollUp() {
		        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		        // Scroll up by a certain number of pixels or to the top of the page
		        jsExecutor.executeScript("window.scrollTo(0, 0);");
		    }
		    
		    public static void scrollDown() {
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        // Scroll up by a certain number of pixels or to the top of the page
		        js.executeScript("window.scrollBy(0,500)");
		    }
		    
		    public static void scrollMedium() {
		        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		        // Scroll up by a certain number of pixels or to the top of the page
		        jsExecutor.executeScript("window.scrollTo(0, 0);");
		    }
		    
		 // Check if an element is displayed
		    public static boolean countofElements(List<WebElement> ele) {
				return ele.size()>0;
		    }
		    
		    public static boolean DisplyedandClick(List<WebElement> ele) {
				return ele.size()>0;
		    }
		    
		    public  static void randomElementFromListScrollIntoView(List<WebElement> e) throws InterruptedException {
				// Use the Random class to generate a random index
		        Random random = new Random();
		        int randomIndex = random.nextInt(e.size());
		        WebElement randomElement= e.get(randomIndex);
		        scrollIntoCenterView(randomElement);
		        Thread.sleep(2000);
		        CombinedClick(randomElement);			
			}
		
		    
		    public  static void randomElementFromList(List<WebElement> e) throws InterruptedException {
				// Use the Random class to generate a random index
		        Random random = new Random();
		        int randomIndex = random.nextInt(e.size());
		        WebElement randomElement= e.get(randomIndex);
		        Thread.sleep(2000);
		        CombinedClick(randomElement);			
			}
		    
		    
		    public  static void randomElementFromListHover(List<WebElement> e) throws InterruptedException {
				// Use the Random class to generate a random index
		        int randomIndex = random.nextInt(e.size());
		        WebElement randomElement= e.get(randomIndex);
		        scrollIntoCenterView(randomElement);
		        Thread.sleep(2000);
		        hover(randomElement);
		        
			}
		    
		    
//		    
//		    public  static void randomElementFromListforSortBy(List<WebElement> e ) throws InterruptedException {
//				// Use the Random class to generate a random index
//		        Random random = new Random();
//		        int randomIndex = random.nextInt(e.size());
//		        WebElement randomElement= e.get(randomIndex);
//		        click(randomElement);	
//		        Thread.sleep(3000);
//		        nameofSelectedSortby = randomElement.getText();   
//			}
		    
		    public static String waitAndVisibleGetText(WebElement locatorName) {
		        Waits.waitAndVisibility(locatorName);
		        String locatorNameText = "";
		        locatorNameText = locatorName.getText();
	            return locatorNameText;
	    }
		    public static void scrollUp(WebDriver driver) {
		        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		        // Scroll up by a certain number of pixels or to the top of the page
		        jsExecutor.executeScript("window.scrollTo(0, 0);");
		    }
		   public static void selectByOptions(List<WebElement> e) throws InterruptedException {    	
			     // Generate a random index to click on a link
			        Random random = new Random();
			        int randomIndex = random.nextInt(e.size());
	 
			        // Get the text of the randomly selected link
			         selectedLinkText = e.get(randomIndex).getText();
	 
			         JavascriptExecutor js = (JavascriptExecutor)driver;
					 js.executeScript("arguments[0].click();",e.get(randomIndex));
			        // Click on the randomly selected link
			       // e.get(randomIndex).click();   
			        logger.info(selectedLinkText);
	 
			    }


}
