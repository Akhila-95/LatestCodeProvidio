package pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.providio.testcases.baseClass;


public class ProductListingPage extends baseClass{
	
	WebDriver lDriver;
    //pageFactory constructor for this page
	public ProductListingPage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//WishList
	public void selecttheWishlist() throws InterruptedException{
		List<WebElement> wishListBtns = driver.findElements(By.xpath("//i[contains(@class, 'fa-heart-o')]"));
		// Get the total number of options
		int numberOfOptions = wishListBtns.size();
		if(numberOfOptions>0) {
			// Generate a random index within the range of available options
			int randomIndex = random.nextInt(numberOfOptions)+1;
			WebElement wishlistPlp = driver.findElement(By.xpath("(//i[contains(@class, 'fa-heart-o')])["+randomIndex+"]"));
			Thread.sleep(4000);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", wishlistPlp);
			executor.executeScript("arguments[0].click();", wishlistPlp);
		}
	}
	
	//add to button in quick shop
	@FindBy(xpath ="//button[contains(@class, 'add-to-cart')]")
	WebElement addToCartBtn; 
	public WebElement getSelectaddToCartBtn(){
		return addToCartBtn;
	}
	
		
	//FilterResetButton
	@FindBy(xpath ="//button[@class = 'reset btn p-0']")
	WebElement ResetButton; 
	public WebElement getSelecttheResetButton(){
		return ResetButton;
	}
	

	//FilterResetButton
	@FindBy(xpath ="//button[@class = 'reset btn p-0']")
	WebElement resetButton;
	public void selecttheResetButton() throws InterruptedException{
		resetButton.click();
    	Thread.sleep(3000);
	}
	//filters
	@FindBy(xpath ="//select[@name = 'sort-order']")
	WebElement SortBy;
	public void selecttheSortBy() throws InterruptedException{	
		test.info("Verify that sort by is select");
		// Get all the available options within the dropdown
		List<WebElement> optionsofSortBy = SortBy.findElements(By.tagName("option"));
		// Generate a random index within the range of available options
		int randomIndex = random.nextInt(optionsofSortBy.size());
		// Select the random option by its index
		optionsofSortBy.get(randomIndex).click();
		//Filters.click();
    	Thread.sleep(3000);
		test.pass("Successfully selected the SortBy");
	}
	
	////select a random product with breadcramps	
	public void selectRandomProduct() throws InterruptedException {

        // Find all the product elements on the current page (after navigating)
        List<WebElement> products = driver.findElements(By.xpath("//a[@class ='tile-img-contain']"));
        
        // Get the total count of products found on the page
        int totalProductcount = products.size();
        logger.info(totalProductcount);
        // Check if there are any products found on the page
        if (totalProductcount > 0) {
            // Generate a random number within the range of the total product count
            int randomSelectProduct = random.nextInt(totalProductcount) + 1;
            logger.info(randomSelectProduct);
            // Find the randomly selected product element based on the generated random number
            WebElement randomSelectProductFromPLP = driver.findElement(By.xpath("(//a[@class ='tile-img-contain'])[" + randomSelectProduct + "]"));
            
            // Use JavaScript Executor to click on the randomly selected product element
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", randomSelectProductFromPLP);
            Thread.sleep(3000);
        }
        
	}
	
	
	
//filtersForm plp
	public void selectaFilterFormPLP() throws InterruptedException {
		test.info("Verify that filters in the PLP");
		// Find the element using the dynamic XPath with a wildcard
        List<WebElement> TotalNumberofFilters =  driver.findElements(By.xpath("//div[contains(@class, 'refinement refinement-')]"));
        // Get the total count of top-level menu elements.
        int Filterscount = TotalNumberofFilters.size();
        logger.info("Total filters count is " + Filterscount);
        // Generate a random index to select a top-level menu item.
        int randomNumberFilter = random.nextInt(Filterscount) + 1;
        logger.info("Randomly selected filters number " + randomNumberFilter);
        
        if(randomNumberFilter==1) {
        	randomNumberFilter = randomNumberFilter+1;
        }
        
        // get the name of the Main filter 
        WebElement mainFilterName = driver.findElement(By.xpath("(//div[contains(@class, 'refinement refinement-')]//h6)["+randomNumberFilter+"]"));
        // Get and print the text of the found element
        String NameofFilterText = mainFilterName.getText();
        logger.info(NameofFilterText);
        String expectedResultcolor = "Color";
        String expectedResultsize = "Size";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(5000);
        if(NameofFilterText.equals(expectedResultcolor)) {
        	
        	 //number of sub filtes associate with the main filter
            List<WebElement> numberofFiltersinInColor =  driver.findElements(By.xpath("//li[@class='color-attribute ']"));
            // Get the total count of top-level menu elements.
            int countofeachFilterbtns = numberofFiltersinInColor.size();
            logger.info("Total filters countofeachFilterbtns is " + countofeachFilterbtns);
         // Generate a random index to select a top-level menu item.
            int randomNumbercountofColorFilterbtns = random.nextInt(countofeachFilterbtns) + 1;
            logger.info("Randomly selected subfilter number " + randomNumbercountofColorFilterbtns);
            
            WebElement colorBtn = driver.findElement(By.xpath("(//li[@class='color-attribute '])["+randomNumbercountofColorFilterbtns+"]"));
            //colorBtn.click();
            js.executeScript("arguments[0].click();", colorBtn);
            test.pass("Successfully clicked the" +NameofFilterText+ "filter");
        	
        }else if(NameofFilterText.equals(expectedResultsize)) {
       	 //number of sub filtes associate with the main filter
            List<WebElement> numberofFiltersinInSize =  driver.findElements(By.xpath("//span[@class='size-btn']"));
            // Get the total count of top-level menu elements.
            int countofeachFilterbtns = numberofFiltersinInSize.size();
            logger.info("Total filters countofeachFilterbtns is " + countofeachFilterbtns);
         // Generate a random index to select a top-level menu item.
            int randomNumbercountofSizeFilterbtns = random.nextInt(countofeachFilterbtns) + 1;
            logger.info("Randomly selected subfilter number " + randomNumbercountofSizeFilterbtns);
            WebElement SizeBtn = driver.findElement(By.xpath("(//span[@class='size-btn'])["+randomNumbercountofSizeFilterbtns+"]"));
            //SizeBtn.click();
            js.executeScript("arguments[0].click();", SizeBtn);
            test.pass("Successfully clicked the" +NameofFilterText+ "filter");
        }else {
        	logger.info("not color and size");
        	//Radio icon of the filter
            WebElement selectRadioIcon = driver.findElement(By.xpath("(//div[contains(@class, 'refinement refinement-')]//div[contains(@id, 'refinement-')])["+randomNumberFilter+"]//button"));
            //selectRadioIcon.click();
           
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectRadioIcon);
            js.executeScript("arguments[0].click();", selectRadioIcon);
            Thread.sleep(4000);
            test.pass("Successfully clicked the" +NameofFilterText+ "filter");
        }
                
	}
        //quick shop
		public void selectthequickshope() throws InterruptedException{
			 // Find all the product elements on the current page (after navigating)
	        List<WebElement> qucikShopBtns = driver.findElements(By.xpath("//a[contains(text(), 'Quick Shop')]"));
	        
	        // Get the total count of products found on the page
	        int totalQuickShopBtns = qucikShopBtns.size();
	        logger.info(totalQuickShopBtns);
	        // Check if there are any products found on the page
	        if (totalQuickShopBtns > 0) {
	            // Generate a random number within the range of the total product count
	            int randomQuickShopBtn = random.nextInt(totalQuickShopBtns) + 1;
	            logger.info(randomQuickShopBtn);
	            // Find the randomly selected product element based on the generated random number
	            WebElement randomQuickShopBtnPLP = driver.findElement(By.xpath("(//a[contains(text(), 'Quick Shop')])[" + randomQuickShopBtn + "]"));
	            // Use JavaScript Executor to click on the randomly selected product element
	            JavascriptExecutor js = (JavascriptExecutor)driver;
	            js.executeScript("arguments[0].click();", randomQuickShopBtnPLP);
	            Thread.sleep(3000);
		     }
	
		}
	
}
