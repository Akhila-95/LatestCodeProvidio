package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.ShippingAddressPageTasks;

public class ShippingAddressPageTests extends baseClass{
	
	@Test(groups = {"smoke", "regression"})
    public void VerifedThatEnteredtheShippingAddressInShippingPage() throws Exception {
		ShippingAddressPageTasks.EnteringShippingDetails();
    }
    
    @Test(groups = {"smoke", "regression"})
    public void VerifedThatEnteredtheshippingDetailsInShippingPage() throws Exception {
		ShippingAddressPageTasks.shippingDetails();
    }
    
	@Test(groups = {"smoke", "regression"})
    public void VerifedAllErrorsInShippingForm() throws Exception {
		ShippingAddressPageTasks.allErrorsInShippingForm();
    }	

	@Test(groups = {"smoke", "regression"})
    public void VerifedTheErrorsInFirstName() throws Exception {
		ShippingAddressPageTasks.firstNameError();
    }
	
	@Test(groups = {"smoke", "regression"})
    public void VerifedTheErrorsInLastName() throws Exception {
		ShippingAddressPageTasks.lastNameError();
    }
	@Test(groups = {"smoke", "regression"})
    public void VerifedTheErrorsAddress() throws Exception {
		ShippingAddressPageTasks.addressError();
    }
	
	@Test(groups = {"smoke", "regression"})
    public void VerifedphoneNumberError() throws Exception {
		ShippingAddressPageTasks.phoneNumberError();
    }
	@Test(groups = {"smoke", "regression"})
    public void VerifedWithValidAddress() throws Exception {
		ShippingAddressPageTasks.enterValidAddress();
    }
}
