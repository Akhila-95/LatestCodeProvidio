package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.providio.testcases.baseClass;

public class loginPage extends baseClass{

    WebDriver lDriver;

    // Constructor for the loginPage class
    public loginPage(WebDriver rDriver) {
        lDriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }
/*
    // Element for Sign In button
    @FindBy(xpath = "//span[contains(text(), 'Sign In')]")
    WebElement signIn;

    // Method to click on the Sign In button
    public void clickSign() {
        signIn.click();
    }

    // Element for email input field
    @FindBy(name = "loginEmail")
    WebElement email;

    // Method to set the email input field
    public void setEmail(String name) {
        email.clear();
        email.sendKeys(name);
        test.pass("Entered the mail");
    }

    // Element for password input field
    @FindBy(name = "loginPassword")
    WebElement Password;

    // Method to set the password input field
    public void setPassword(String password) {
        Password.clear();
        Password.sendKeys(password);
        test.pass("Entered the password");
    }

    // Element for Login button
    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    WebElement btnLogin;
	public WebElement getLoginBtn() throws InterruptedException {
		return btnLogin;
	}

    // Method to click the Login button with a sleep
    public void clickSubmit() throws InterruptedException {
        btnLogin.click();
        Thread.sleep(10000);
    }

    // Element for Login button (JavaScript click)
    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    WebElement btnLoginjs;

    // Method to click the Login button using JavaScript with a sleep
    public void clickSubmitjs(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnLoginjs);
        btnLogin.click();
        Thread.sleep(10000);
    }

    // Element for Home page logo
    @FindBy(xpath = "//img[@class='logo']")
    WebElement forHomePage;

    // Method to click on the Home page logo using JavaScript with a sleep
    public void clickOnLogo(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", forHomePage);
    }
    */

    @FindBy(xpath = "//h1[contains(text(),'Login')]")
    WebElement loginPage;
    public WebElement getLoginPage() {
    	return loginPage;
    }
    // Element for Sign In button
    @FindBy(xpath = "//span[contains(text(), 'Sign In')]")
    WebElement signIn;

    // Method to click on the Sign In button
    public WebElement clickSign() {
       return signIn;
    }
    
    // Element for Sign In button
    @FindBy(xpath = "//span[contains(text(), 'Sign In')]")
    List<WebElement> signInList;

    // Method to click on the Sign In button
    public List<WebElement> clickSignList() {
       return signInList;
    }
 // Element for email input field
    @FindBy(name = "loginEmail")
    private WebElement email;

    // Method to get the email input field
    public WebElement getEmail() {
        return email;
    }

    // Element for password input field
    @FindBy(name = "loginPassword")
    private WebElement password;

    // Method to get the password input field
    public WebElement getPassword() {
        return password;
    }

    // Element for Login button
    @FindBy(xpath = "//button[contains(text(), 'Login')]")
	public WebElement btnLogin;

    // Method to click on the Login button
    public WebElement clickBtnLogin() {
        return btnLogin;
    }

    // Element for Login button (JavaScript click)
    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    private WebElement btnLoginjs;

    // Method to perform JavaScript click on the Login button
    public WebElement clickBtnLoginJs() {
        return btnLoginjs;
    }

    // Element for Home page logo
    @FindBy(xpath = "//img[@class='logo']")
    private WebElement forHomePage;

    // Method to get the Home page logo
    public WebElement getForHomePage() {
        return forHomePage;
    }
	
    @FindBy(xpath = " //h1[@class ='account-page-title']")
    private WebElement loginTitle;
    
    public WebElement getLoginTitle() {
    	return loginTitle;
    }
    
    @FindBy(xpath = "(//dd)[1]")
    private WebElement userName;
    
    public WebElement getUserName() {
    	return  userName;
    }
    
    @FindBy(xpath = "(//dd)[2]")
    private WebElement userEmail ;
    
    public WebElement getUserEmail() {
    	return  userEmail;
    }
    
    @FindBy(xpath = "//div[contains(@class, 'alert') and contains(@class, 'alert-danger')]")
    private WebElement invalidLoginError;
    
    public WebElement getinvalidLoginError() {
    	return invalidLoginError;
    }
    @FindBy(xpath = "(//div[@id= 'form-email-error'])[1]")
    private WebElement mailError;
    
    public WebElement getMailError() {
    	return mailError;
    }
    
    @FindBy(xpath = "(//div[@id= 'form-password-error'])[1]")
    private WebElement passwordError;
    
    public WebElement getPasswordError() {
    	return  passwordError;
    }
    @FindBy(xpath = "(//div[@class='invalid-feedback' and @id='form-email-error'])[1]")
    WebElement invalidEmail;
    
    public WebElement getInvalidEmailFormatError() {
    	return invalidEmail;
    }
    
}
