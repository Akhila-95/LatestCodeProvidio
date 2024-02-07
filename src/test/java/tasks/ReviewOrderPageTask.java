package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

import PaypalPayment.CheckOutPaypal;
import functionality.Actionsss;
import pageObjects.PaymentPageObjects;
import pageObjects.ReviewOrderPage;
import pageObjects.ShippingPageObject;
import pageObjects.homepage;
import validations.OrderPageValidation;
import validations.PaymentPageValidation;
import validations.ReviewOrderPageValidation ;
import validations.ShippingPageValidation;

public class ReviewOrderPageTask extends baseClass{

	private static final ReviewOrderPage reviewOrder = new ReviewOrderPage(driver);
	private static final PaymentPageObjects paymentPage = new PaymentPageObjects(driver);
	private static final ShippingPageObject shippingPage = new ShippingPageObject(driver);
	private static homepage homePage = new homepage(driver);
	
	public static void reviewOrderPage() throws Exception {
		if(Actionsss.elementSize(reviewOrder.getgsummaryOfBillingAddressList()) && Actionsss.elementSize(reviewOrder.getSelectPlaceOrderBtnList())) {
			if(Actionsss.displayElement(reviewOrder.getgsummaryOfBillingAddress()) && (Actionsss.displayElement(reviewOrder.getSelectPlaceOrderBtn()))   ) {
				logger.info("Review order page is loaded");
			//	CreditCardDetails.creditCardDetails();
			}
		}else {
			PaymentPageTasks.creditCardWithValidDetails();
			//PaymentPageTasks.gcRedemption();
		}
	}
	
	public static void getBackToCart() throws Exception {	
		 reviewOrderPage();
		 ReviewOrderPageValidation.bactToCartValidationInreviewOrderPage();
		 Actionsss.click(paymentPage.getBackToCart());				
		 CheckOutPageTasks.guestCheckout();
		 ShippingPageTasks.enterValidAddress();
		 PaymentPageTasks.creditCardWithValidDetails();
		 ReviewOrderPageValidation .bactToCartValidationInreviewOrderPage();
	
	}
	
	public static void getCutomerInfoInReviewOrderPage() throws Exception {	
		reviewOrderPage();
		ReviewOrderPageValidation.customerInfoValidationInreviewOrderPage();
	}
	
	public void  getshippingInfo() throws Exception {
		reviewOrderPage();
		ReviewOrderPageValidation.shippingDetailInfoValidationInreviewOrderPage();		
	}
	
	public static void getOrderSummary() throws Exception {
		reviewOrderPage();
		ReviewOrderPageValidation.orderSummaryValidationInreviewOrderPage();		
	}
	
	public static void getPaymentInfo() throws Exception {
		reviewOrderPage();
		ReviewOrderPageValidation.billingFormInreviewOrderPage();		
	}
	
	
	public static void paginationOfProductsInReviewOrderPage() throws InterruptedException, Exception {
		reviewOrderPage();
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			Actionsss.randomElementFromList(paymentPage.getproductsInCheckoutPage2());
			ReviewOrderPageValidation.pdpPageValidation();
			ViewCartPageTasks.viewCartpage();
			CheckOutPageTasks.GuestMailCheckOut();
			ShippingPageTasks.enterValidAddress();
			PaymentPageTasks.creditCardWithValidDetails();
		}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
	}

	public static void getEtgLogo() throws Exception {
		reviewOrderPage();
		ReviewOrderPageValidation.etgLogoValidationInreviewOrderPage();
	
	}
	public static void getPlaceOrder() throws Exception {
		reviewOrderPage();
		ReviewOrderPageValidation.placeOrderButtonInPaymentPage();	
	}
	
	public static void clickPlaceOrderButton() throws Exception {
		reviewOrderPage();			
		placeOrder();
	}
	
	
	public static void placeOrder() throws Exception {
		//reviewOrderPage();
		Actionsss.scrollWindowsByPixel(500);
		if(Actionsss.elementSize(paymentPage.getSalesforcePaypalList())) {	
			logger.info("Salesforce payment activated");	
			Thread.sleep(1000);
			Actionsss.CombinedClick(paymentPage.getSelectPlaceOrderBtn());
			Thread.sleep(8000);
			PaymentPageValidation.VerifiedThatPlaceOrderClick();
		}else {
			logger.info("Other paymnet activated");
			logger.info("Place order page is loaded");
			Thread.sleep(2000);
			Actionsss.CombinedClick(paymentPage.getSelectPlaceOrderBtn());
			Thread.sleep(5000);
			PaymentPageValidation.VerifiedThatPlaceOrderClick();
		}
	}
	
	
	public static void editShippingAddressFromReviewOrderPage() throws Exception {
		reviewOrderPage();	
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			previousShippingAddressInRop=Actionsss.getTextOfElement(reviewOrder.getShippingAddressInRop());
			Actionsss.click(reviewOrder.getEditShippingAddressInRop());
			Actionsss.editShippingAddressFromRop(shippingPage.getShippingAddress());
			Actionsss.CombinedClick(shippingPage.getNextPaymentButton());	
			Thread.sleep(1000);
			ShippingPageValidation.VerifiedThatNextpaymentBtnClick();
			PaymentPageTasks.clickReviewOrderButton();
			Thread.sleep(1000);
			editedShippingAddressInRop=Actionsss.getTextOfElement(reviewOrder.getShippingAddressInRop());
			ReviewOrderPageValidation.editShippingAddressValidation();
			placeOrder();
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();		 			
		}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
	}
	public static void editPhoneNumInShippingAddressFromReviewOrderPage() throws Exception {
		reviewOrderPage();	
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			 previousPhoneNumInShippingAddressInRop=Actionsss.getTextOfElement(reviewOrder.getPhoneNumInshippingAddressInRop());
			 Actionsss.click(reviewOrder.getEditShippingAddressInRop());
			 Actionsss.sendKeys(shippingPage.getSelectPhoneInput(), "8765987653","shipping phone number");
			 Actionsss.CombinedClick(shippingPage.getNextPaymentButton());	
			 Thread.sleep(1000);
			 ShippingPageValidation.VerifiedThatNextpaymentBtnClick();
			 PaymentPageTasks.clickReviewOrderButton();
			 Thread.sleep(1000);
			 editedPhoneNumInShippingAddressInRop=Actionsss.getTextOfElement(reviewOrder.getPhoneNumInshippingAddressInRop());
			 ReviewOrderPageValidation.editedBillingAddressValidation();
			 placeOrder();
			 OrderPageValidation.validatePlacetheOrderPage();
			 OrderPageValidation.orderNumberAndOrderDate();
			 
			
		}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
	}
	
	public static void editBillingAddressFromReviewOrderPage() throws Exception {
		reviewOrderPage();	
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			 previousBillingAddressInRop=Actionsss.getTextOfElement(reviewOrder.getBillingAddress());			 
			 Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderBtnPage());
			 Actionsss.click(paymentPage.getUpdateBillingAddress());
			 Thread.sleep(1000);
			 Actionsss.scrollWindowsByPixel(200);
			 Actionsss.editBillingAddressFromRop(paymentPage.getBillingAddress());			 
			 PaymentPageTasks.clickReviewOrderButton();
			 Thread.sleep(2000);
			 editedBillingAddressInRop=Actionsss.getTextOfElement(reviewOrder.getBillingAddress());
			 ReviewOrderPageValidation.editedBillingAddressValidation();
			 placeOrder();
			 OrderPageValidation.validatePlacetheOrderPage();
			 OrderPageValidation.orderNumberAndOrderDate();
			 
			
		}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
	}
	
	
	public static void editPhoneNumberInBillingAddress() throws Exception {
		reviewOrderPage();	
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			Thread.sleep(2000);				
			prevoiusBillingPhoneNumber =Actionsss.getTextOfElement(reviewOrder.getPhoneNumberInBillingAddress());	
			Thread.sleep(1000);
			Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderBtnPage());		
			Actionsss.sendKeys(paymentPage.getBillingPhoneNumber(), "9876543567", "edited phone number  in billing address");
			
			 if(Actionsss.elementSize(paymentPage.getBrainTree())) {
			    	PaymentPageTasks.clickReviewOrderButton();				    	
			    	Thread.sleep(15000);
		    	}
			
			editedBillingPhoneNumber=Actionsss.getTextOfElement(reviewOrder.getPhoneNumberInBillingAddress());				
			PaymentPageValidation.phoneNumberInBillingAddressValidation();	
			placeOrder();
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();
		}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
		Actionsss.click(homePage.clickOnLogo());
	}
	public static void editPaymentToCreditCard() throws Exception {
		reviewOrderPage();
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				logger.info("Brain tree activated");
				
					if(Actionsss.elementSize(reviewOrder.getCreditCardPaymentBrainTreeBeforeEditList())) {
						logger.info("credit card details entered");
						previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());						
						Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
						if(Actionsss.elementSize(paymentPage.getSalesforcePaypalList()) || Actionsss.elementSize(paymentPage.getBrainPaypalAcc()) ) {
								CheckOutPaypal.paypalFromCheckout();
						}
					}else if (Actionsss.elementSize(reviewOrder.getBrainPaypalPaymentInReviewOrderPageList())) {
						logger.info("Paypal details entered");
						previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());		
						Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
						PaymentPageTasks.creditCardWithValidDetails();
					
					}else if(Actionsss.elementSize(reviewOrder.getGcPaymentBeforeEditList())) {
						logger.info("gc entered");
						if(Actionsss.elementSize(paymentPage.getSalesforcePaypalList()) || Actionsss.elementSize(paymentPage.getBrainPaypalAcc()) ) {
							CheckOutPaypal.paypalFromCheckout();
						}else {
							PaymentPageTasks.creditCardWithValidDetails();
						}
						Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					}else if(Actionsss.elementSize(reviewOrder.getGcPaymentBeforeEditList())){
						logger.info("gc");
						previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentBeforeEdit());
						logger.info(previousPaymentInPlaceorderPage);
						Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
						PaymentPageTasks.removeAppliedGc();
						logger.info("edit credit card");
						PaymentPageTasks.creditCardWithValidDetails();
						logger.info("Entered credit card num is " +creditCardNumber);
						paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentBeforeEdit());
						logger.info(paymentafterEditInPlaceorderPage);
									
						if(Actionsss.elementSize(paymentPage.getBrainTree())) {	
							logger.info("If payment is brain tree then clicked on edit and check the edited payment");
							Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
						}else {
							placeOrder();
							ReviewOrderPageValidation.editPaymentInReviewOrderPage();
						}
					}	
			}
			
		}
	}
	
	public static void editPaymentToPaypal() throws Exception {
		reviewOrderPage();
		if(Actionsss.elementSize(reviewOrder.getStripePaymentInReviewOrderPageList())) {
			logger.info("stripe activated");
			if(Actionsss.elementSize(reviewOrder.getGcStripePaymentInReviewOrderPageList())) {
				logger.info("gc");
				previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcCodeInstripePaymentInReviewOrderPage());
				Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
			} {
				
			}
			
			
		}else if(Actionsss.elementSize(reviewOrder.getBrainPaypalPaymentInReviewOrderPageList())) {
			logger.info("brain tree activated");
			if(Actionsss.elementSize(reviewOrder.getCreditCardPaymentBrainTreeBeforeEditList())) {
				logger.info("credit card");
				previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());
				logger.info(previousPaymentInPlaceorderPage);
				Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
			}else if(Actionsss.elementSize(reviewOrder.getpaypalPaymentBeforeEditList())) {
				logger.info("paypal");
				if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());
				logger.info(previousPaymentInPlaceorderPage);
				}
				Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
			}else if(Actionsss.elementSize(reviewOrder.getGcPaymentBeforeEditList())){
				logger.info("gc");
				previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentBeforeEdit());
				logger.info(previousPaymentInPlaceorderPage);
				Actionsss.javascriptClick(reviewOrder.getEditPaymentInPlaceOrderPage());
				PaymentPageTasks.removeAppliedGc();
				PaymentPageTasks.paypal();
				logger.info("edit paypal");			
				
				Thread.sleep(2000);
				//paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(placeOrder.getBrainPaypalPaymentBeforeEdit());
				//logger.info(paymentafterEditInPlaceorderPage);
							
				if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
					logger.info("brain tree activated");
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());
					logger.info(paymentafterEditInPlaceorderPage);
					logger.info("If payment is brain tree then clicked on edit and check the edited payment");
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					WebElement paypal= driver.findElement(By.xpath("//option[@id='braintreePaypalAccount']"));
					getTextOfPaypalInPaymentPage= paypal.getAttribute("value");
					logger.info(getTextOfPaypalInPaymentPage);
					
					PaymentPageTasks.clickReviewOrderButton();
					ReviewOrderPageValidation.editPaymentToPaypalReviewOrderPage();
					placeOrder();
					OrderPageValidation.validatePlacetheOrderPage();
					OrderPageValidation.orderNumberAndOrderDate();
				}else {
					logger.info("");
					placeOrder();
					ReviewOrderPageValidation .editPaymentInReviewOrderPage();
					OrderPageValidation.validatePlacetheOrderPage();
					OrderPageValidation.orderNumberAndOrderDate();
					
				}
			}else {
				test.info("Salesforce payment is activated");
				test.info("No review order page in salesforce payment");
			}
		}
	}
}
