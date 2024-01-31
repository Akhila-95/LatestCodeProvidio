package pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.providio.testcases.baseClass;

import functionality.Actionsss;



public class homepage extends baseClass{
	
	WebDriver lDriver;
    //pageFactory constructor for this page
	public homepage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	Actionsss action = new Actionsss();
    
   //to get back to homepage 
	@FindBy(xpath = "//img[@class='logo']")
	WebElement for_HomePage_logo;
	public WebElement clickOnLogo() throws InterruptedException {
		return for_HomePage_logo;
	}

	//search
	//search bar
	@FindBy(xpath = "//input[@name='q']")
	WebElement searchBarElement;
	
	public WebElement getSearchElement() {
		return searchBarElement;
	}
	
	//clicked on searched product
	@FindBy(xpath = " (//span[@class='name'])[2]")
	WebElement searchProduct;
	
	public WebElement getClickOnSearchedProduct() {
		return searchProduct;
	}
	
	@FindBy(xpath= "(//h1[contains(@class,'product-name')])[2]")
	WebElement productNameInPdp;
	
	public WebElement getProductName() {
		return productNameInPdp;
	}
	
	//Giftcard link
	@FindBy(xpath = "//a[text()='Gift Registry']")
	WebElement giftCardLink;
	public WebElement getGiftCardLink() throws InterruptedException {
		return giftCardLink;
	}
	
	//My Fav link
	@FindBy(xpath = "(//i[@class='fa fa-heart fa-lg'])[1]")
	WebElement wishListLink;
	public WebElement getWishListLink() throws InterruptedException {
		return wishListLink;
	}
		
	//My Fav link
	@FindBy(xpath = "//span[contains(@class, 'minicart-quantity')]")
	WebElement miniCartLink;
	public WebElement getMiniCartLink() throws InterruptedException {
		return miniCartLink;
	}
	//signInlink
	@FindBy(xpath = "//div[@class='user mr-3 d-none d-lg-block']//span[@class='user-message']")
	WebElement signInLink;
	public WebElement getsignInLinkLink() throws InterruptedException {
		return signInLink;
	}
	
	
	
	
	//Mega menu
	
	public void selectRandomMegaMenu(WebDriver driver) throws InterruptedException {
		
        List<WebElement> elements = driver.findElements(By.xpath("//ul[contains(@class, 'nav navbar-nav')]//li[contains(@class, 'nav-item') and @role='presentation']"));
        int count = elements.size();
        //int randomNumbermenu = random.nextInt(count) + 1;
        int randomNumbermenu = 3;
        if(randomNumbermenu==count) {
        	 WebElement Topsellers = driver.findElement(By.xpath("(//ul[contains(@class, 'nav navbar-nav')]//li[contains(@class, 'nav-item') and @role='presentation'])[" + randomNumbermenu + "]"));
        	 Topsellers.click();
        }else {
        List<WebElement> elementsofdrop = driver.findElements(By.xpath("(//li[@class='nav-item dropdown'])[" + randomNumbermenu + "]//a[@class='dropdown-link']"));
        int countdropdown = elementsofdrop.size();
        //int randomNumberitem = random.nextInt(countdropdown) + 1;
        int randomNumberitem = 3;
        WebElement NavigationRandomMenu = driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + randomNumbermenu + "]"));
       // Thread.sleep(5000L);
        Actions action = new Actions(driver);
        action.moveToElement(NavigationRandomMenu).perform();
       // Thread.sleep(5000L);
        WebElement NavigationMenuitem = driver.findElement(By.xpath("((//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + randomNumbermenu + "]/following::a[@role='menuitem'])[" + randomNumberitem + "]"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", new Object[]{NavigationMenuitem});
        //Thread.sleep(10000L);
        
        List<WebElement> newArrivalplp = driver.findElements(By.xpath("(//a[contains(text(), 'New Arrivals')])[2]"));
        List<WebElement> womensplp = driver.findElements(By.xpath("//li[@class='breadcrumb-item']/a[contains(text(), 'Women')]"));
        List<WebElement> menplp = driver.findElements(By.xpath("//li[@class='breadcrumb-item']/a[contains(text(), 'Men')]"));
        if(newArrivalplp.size()>0) {
        	String[] newArrivalsCategory= {"WOMENS", "MENS", "ELECTRONICS"};
        	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
        	String pageTitleText = pageTitle.getText();
        	test.info("verify that NewArrivals of  " + pageTitleText + " ");
        	if (pageTitleText.equals(newArrivalsCategory[randomNumberitem-1])) {
        		test.pass("Successfully clicked on the NewArrivals of  " + pageTitleText + " ");
                logger.info("click Success NewArrivals of  " + pageTitleText + "");
            }
        }else if(womensplp.size()>0) {        	
        	String[] womensCategory= {"OUTFITS", "TOPS", "DRESSES","BOTTOMS","JACKETS & COATS","FEELING RED","EARRINGS","BRACELETS","NECKLACES","SCARVES","SHOES"};
        	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
        	String pageTitleText = pageTitle.getText();
        	test.info("verify that Womens of  " + pageTitleText + " ");
        	if (pageTitleText.equals(womensCategory[randomNumberitem-1])) {
        		test.pass("Successfully clicked on the Womens of  " + pageTitleText + " ");
                logger.info("click Success Womens of  " + pageTitleText + "");
            }
        }else if(menplp.size()>0) {
        	String[] mensCategory= {"SUITS","JACKETS & COATS","DRESS SHIRTS","SHORTS","PANTS","TIES","GLOVES","LUGGAGE"};
        	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
        	String pageTitleText = pageTitle.getText();
        	test.info("verify that Mens of  " + pageTitleText + " ");
        	if (pageTitleText.equals(mensCategory[randomNumberitem-1])) {
        		test.pass("Successfully clicked on the Mens of  " + pageTitleText + " ");
                logger.info("click Success Mens of  " + pageTitleText + "");
        	}
        }else {
        	String[] electronicsCategory= {"TELEVISIONS","DIGITAL CAMERAS","IPOD & MP3 PLAYERS","GPS NAVIGATION","GAMING"};
        	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
        	String pageTitleText = pageTitle.getText();
        	test.info("verify that Electronics of  " + pageTitleText + " ");
        	if (pageTitleText.equals(electronicsCategory[randomNumberitem-1])) {
        		test.pass("Successfully clicked on the Electronics of  " + pageTitleText + " ");
                logger.info("click Success Electronics of  " + pageTitleText + "");
        	}
        }
      }
    }


	public void selectGpsNavigation() throws InterruptedException {

        int randomNumbermenu = 4;
        if(randomNumbermenu==4) {
   
        int randomNumberitem = 4;
        WebElement navigatingElectronics = driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + randomNumbermenu + "]"));
       // Thread.sleep(5000L);
        Actions action = new Actions(driver);
        action.moveToElement(navigatingElectronics).perform();
      //  Thread.sleep(5000L);
        WebElement navigatingToGPS = driver.findElement(By.xpath("((//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + randomNumbermenu + "]/following::a[@role='menuitem'])[" + randomNumberitem + "]"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", new Object[]{ navigatingToGPS});
       // Thread.sleep(10000L);
        
        List<WebElement> newArrivalplp = driver.findElements(By.xpath("(//a[contains(text(), 'New Arrivals')])[2]"));
       
        if(newArrivalplp.size()>0) {
        	String[] newArrivalsCategory= {"WOMENS", "MENS", "ELECTRONICS"};
        	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
        	String pageTitleText = pageTitle.getText();
        	test.info("verify that NewArrivals of  " + pageTitleText + " ");
        	if(pageTitleText.equals(newArrivalsCategory[randomNumberitem-1])) {
        		test.pass("Successfully clicked on the NewArrivals of  " + pageTitleText + " ");
                logger.info("click Success NewArrivals of  " + pageTitleText + "");
             }
        	}else {
        	String[] electronicsCategory= {"TELEVISIONS","DIGITAL CAMERAS","IPOD & MP3 PLAYERS","GPS NAVIGATION","GAMING"};
        	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
        	String pageTitleText = pageTitle.getText();
        	test.info("verify that Electronics of  " + pageTitleText + " ");
        	if (pageTitleText.equals(electronicsCategory[randomNumberitem-1])) {
        		test.pass("Successfully clicked on the Electronics of  " + pageTitleText + " ");
                logger.info("click Success Electronics of  " + pageTitleText + "");
        	}
        }
      }
    }



	
}
