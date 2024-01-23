package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindAStorePage {

	WebDriver lDriver;
	//pageFactory constructor for this page
	public FindAStorePage(WebDriver rDriver ){
			lDriver=rDriver;
			PageFactory.initElements(rDriver, this);
	}

	//to find the store icon
	@FindBy(xpath = "//span[@class='header-store-name']")
	List<WebElement> findAStoreLabelList;
	public List<WebElement> getLabelForFindAStoreList()  {			
		return findAStoreLabelList;
	}
	
	//to find the store icon
	@FindBy(xpath = "//span[@class='header-store-name']")
	WebElement findAStoreLabel;
	public WebElement getLabelForFindAStore()  {			
		return findAStoreLabel;
	}
	
	//to find the store button
	@FindBy(xpath="//button[contains(@class,' storelocator-search')]")
	WebElement findStores;
	public WebElement getFindStoreButton() {
		return findStores;
	}
	
	//selected commerce cloud store
	@FindBy(xpath="//button[contains(@class,' select-store')]")
	List <WebElement> selectStore;

	public List<WebElement> getAnyRandomStore(){
		return selectStore;
	}
}
