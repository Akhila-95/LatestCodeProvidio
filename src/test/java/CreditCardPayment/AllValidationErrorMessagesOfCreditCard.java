package CreditCardPayment;

import com.providio.testcases.baseClass;
import functionality.Actionsss;
import pageObjects.PaymentPageObjects;
import validations.PaymentPageValidation;

public class AllValidationErrorMessagesOfCreditCard extends baseClass {

	private static final PaymentPageObjects paymentPage = new PaymentPageObjects(driver);
    

    // Verify all errors in credit card for guest and registered users
    public static void allErrorsInCreditCard() throws Exception {
        // Check if gift code was already redeemed
        if (Actionsss.elementSize(paymentPage.getPaymentPagecreditCardDivList())) {
            Actionsss.scrollWindowsByPixel(300);

            if (Actionsss.elementSize(paymentPage.getContinueAsAGuest())) {
                test.info("Verifying all the error messages without entering any credit card details in required fields when the user is a guest");
                
                // Check which payment method is available
                if (Actionsss.elementSize(paymentPage.getBrainTree())) {
                    PaymentPageValidation.brainTreeAllPaymentsError();
                } else if (Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
                     PaymentPageValidation.salesforcePaymentAllErrors();
                } else if (Actionsss.elementSize(paymentPage.getStripePayment())) {
                	 PaymentPageValidation.stripePopUpErrorNoDetailsEntered();
                } else if (Actionsss.elementSize(paymentPage.getCyberSourcePayment())) {
                    PaymentPageValidation.getallErrosInCybersource();
                } else {
                    PaymentPageValidation.getallErrorsInAdyen();
                }
            } else {
                test.info("User is checked-in as Registered");
                test.pass("Doing the error validation when the user is checked-in as a guest");
            }
        } else {
            logger.info("Gift code was redeemed already");
            test.info("Gift code was redeemed already");
            test.pass("Gift code was redeemed already");
        }
    }

    // Verify invalid credit card number error
    public static void creditcardNumberInValidError() throws InterruptedException, Exception {
        if (Actionsss.elementSize(paymentPage.getPaymentPagecreditCardDivList())) {
            test.info("Verifying the invalid card number error by entering invalid credit card details");

            Actionsss.scrollWindowsByPixel(400);

            if (Actionsss.elementSize(paymentPage.getContinueAsAGuest())) {
                // Check which payment method is available
                if (Actionsss.elementSize(paymentPage.getBrainTree())) {
                    PaymentPageValidation.brainTreeAllPaymentsError();
                } else if (Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
                    Actionsss.javascriptClick(paymentPage.getSalesforceCreditcardRadioBtn());
                    PaymentPageValidation.salesforceInvalidCardNumber();
                } else if (Actionsss.elementSize(paymentPage.getStripePayment())) {
                    Actionsss.click(paymentPage.getStripeCreditCard());
                    Thread.sleep(1000);
                    PaymentPageValidation.stripeCardInvalidCardError();
                } else if (Actionsss.elementSize(paymentPage.getCyberSourcePayment())) {
                	 PaymentPageValidation.getcreditCardNumberInvalidErrorInCybersource();
                } else {
                	 PaymentPageValidation.getcreditCardNumberInvalidErrorInAdyen();
                }
            } else {
                test.info("User is checked-in as Registered");
                test.pass("Doing the error validation when the user is checked-in as a guest");
            }
        } else {
            logger.info("Gift code was redeemed already");
            test.info("Gift code was redeemed already");
            test.pass("Gift code was redeemed already");
        }
    }

    // Verify invalid expiry month/year error
    public static void creditCardExpMonthInValid() throws Exception {
        if (Actionsss.elementSize(paymentPage.getPaymentPagecreditCardDivList())) {
            test.info("Verifying the invalid expiry month/year error by entering the invalid month/year in credit card");

            Actionsss.scrollWindowsByPixel(300);

            if (Actionsss.elementSize(paymentPage.getContinueAsAGuest())) {
                // Check which payment method is available
                if (Actionsss.elementSize(paymentPage.getBrainTree())) {
                     PaymentPageValidation.brainTreeAllPaymentsError();
                } else if (Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
                    Actionsss.javascriptClick(paymentPage.getSalesforceCreditcardRadioBtn());
                     PaymentPageValidation.salesforceInvalidExpYear();
                } else if (Actionsss.elementSize(paymentPage.getStripePayment())) {
                    Actionsss.click(paymentPage.getStripeCreditCard());
                     PaymentPageValidation.stripeCardInvalidExpDate();
                } else if (Actionsss.elementSize(paymentPage.getCyberSourcePayment())) {
                    test.pass("No validation for invalid expiry year/month for cybersource");
                } else {
                     PaymentPageValidation.getcreditCardExpMonthInValidInAdyen();
                }
            } else {
                test.info("User is checked-in as Registered");
                test.pass("Doing the error validation when the user is checked-in as a guest");
            }
        } else {
            logger.info("Gift code was redeemed already");
            test.info("Gift code was redeemed already");
            test.pass("Gift code was redeemed already");
        }
    }

    // Verify incomplete card number error
    public static void creditCardNumberInCompleteError() throws Exception {
        if (Actionsss.elementSize(paymentPage.getPaymentPagecreditCardDivList())) {
            test.info("Verifying the incomplete card number error by entering incomplete card number in credit card");
            Actionsss.scrollWindowsByPixel(300);

            if (Actionsss.elementSize(paymentPage.getContinueAsAGuest())) {
                // Check which payment method is available
                if (Actionsss.elementSize(paymentPage.getBrainTree())) {
                     PaymentPageValidation.brainTreeAllPaymentsError();
                } else if (Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
                    Actionsss.javascriptClick(paymentPage.getSalesforceCreditcardRadioBtn());
                     PaymentPageValidation.salesforceCvvAndExpError();
                } else if (Actionsss.elementSize(paymentPage.getStripePayment())) {
                    Actionsss.click(paymentPage.getStripeCreditCard());
                     PaymentPageValidation.stripeIncompleteCardError();
                } else if (Actionsss.elementSize(paymentPage.getCyberSourcePayment())) {
                     PaymentPageValidation.getcreditCardNumberInCompleteErrorInCybersource();
                } else {
                     PaymentPageValidation.getCreditCardNumberInCompleteErrorInAdyen();
                }
            } else {
                test.info("User is checked-in as Registered");
                test.pass("Doing the error validation when the user is checked-in as a guest");
            }
        } else {
            logger.info("Gift code was redeemed already");
            test.info("Gift code was redeemed already");
            test.pass("Gift code was redeemed already");
        }
    }

 // Verify incomplete expiry year error
    public static void creditCardNumberInCompleteExpYearError() throws Exception {
        if (Actionsss.elementSize(paymentPage.getPaymentPagecreditCardDivList())) {
            test.info("Verifying the incomplete expiry year error by entering the incomplete expiry year in credit card");

            if (Actionsss.elementSize(paymentPage.getContinueAsAGuest())) {
                // Check which payment method is available
                if (Actionsss.elementSize(paymentPage.getBrainTree())) {
                     PaymentPageValidation.brainTreeAllPaymentsError();
                } else if (Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
                    Actionsss.javascriptClick(paymentPage.getSalesforceCreditcardRadioBtn());
                     PaymentPageValidation.salesforceCvvAndExpError();
                } else if (Actionsss.elementSize(paymentPage.getStripePayment())) {
                    Actionsss.click(paymentPage.getStripeCreditCard());
                     PaymentPageValidation.stripeIncompleteExpYearError();
                } else if (Actionsss.elementSize(paymentPage.getCyberSourcePayment())) {
                    test.pass("No validation for incomplete expiry year/month for cybersource");
                } else {
                    // adyen
                }
            } else {
                test.info("User is checked-in as Registered");
                test.pass("Doing the  error validation when user is checked-in  as guest");
            }
        } else {
            logger.info("Gift code was redeemed already");
            test.info("Gift code was redeemed already");
            test.pass("Gift code was redeemed already");
        }
    }

    // Verify incomplete CVV error
    public static void creditCardInCompleteCvvError() throws Exception {
        if (Actionsss.elementSize(paymentPage.getPaymentPagecreditCardDivList())) {

            test.info("Verifying the incomplete CVV error by entering the incomplete CVV in credit card");
            if (Actionsss.elementSize(paymentPage.getContinueAsAGuest())) {

                if (Actionsss.elementSize(paymentPage.getBrainTree())) {
                    // brain tree negative
                     PaymentPageValidation.brainTreeAllPaymentsError();
                } else if (Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
                    // salesforce negative
                    Actionsss.javascriptClick(paymentPage.getSalesforceCreditcardRadioBtn());
                     PaymentPageValidation.salesforceCvvAndExpError();
                } else if (Actionsss.elementSize(paymentPage.getStripePayment())) {
                    // stripe
                    Actionsss.click(paymentPage.getStripeCreditCard());
                     PaymentPageValidation.getStripeCardSecurityCodeIncompleteError();
                } else if (Actionsss.elementSize(paymentPage.getCyberSourcePayment())) {
                    // cybersource
                     PaymentPageValidation.getIncompleteSecurityCodeErrorInCybersource();
                } else {
                    // adyen
                     PaymentPageValidation.getCreditCardInCompleteCvvError();
                }
            } else {
                test.info("User is checked-in as Registered");
                test.pass("Doing the  error validation when user is checked-in  as guest");
            }
        } else {
            logger.info("Gift code was redeemed already");
            test.info("Gift code was redeemed already");
            test.pass("Gift code was redeemed already");
        }
    }

    // Verify CVV and expiry year error
    public static void creditCardCvvAndExpError() throws Exception {
        if (Actionsss.elementSize(paymentPage.getPaymentPagecreditCardDivList())) {
            test.info("Verifying the CVV and expiry year error without entering the CVV and expiry year by entering credit card number ");
            if (Actionsss.elementSize(paymentPage.getContinueAsAGuest())) {

                if (Actionsss.elementSize(paymentPage.getBrainTree())) {
                    // brain tree negative
                     PaymentPageValidation.brainTreeAllPaymentsError();
                } else if (Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
                    // salesforce negative
                    Actionsss.javascriptClick(paymentPage.getSalesforceCreditcardRadioBtn());
                     PaymentPageValidation.salesforceCvvAndExpError();
                } else if (Actionsss.elementSize(paymentPage.getStripePayment())) {
                	 PaymentPageValidation.stripePopUpErrorCvvAndExpiryEntered();
                } else if (Actionsss.elementSize(paymentPage.getCyberSourcePayment())) {
                    // cybersource
                    //  PaymentPageValidation.getCreditCardCvvAndExpMonthYearErrorInCybersource();
                     PaymentPageValidation.getCreditCardCvvAndExpYearErrorInCybersource();
                } else {
                     PaymentPageValidation.getCreditCardCvvAndExpErrorMessage();
                }
            } else {
                test.info("User is checked-in as Registered");
                test.pass("Doing the  error validation when user is checked-in  as guest");
            }
        } else {
            logger.info("Gift code was redeemed already");
            test.info("Gift code was redeemed already");
            test.pass("Gift code was redeemed already");
        }
    }


 // Verify CVV error
    public static void creditCvvError() throws Exception {
        if (Actionsss.elementSize(paymentPage.getPaymentPagecreditCardDivList())) {
            test.info("Verifying with CVV error without entering CVV by entering the card number, expiry month in credit card");

            if (Actionsss.elementSize(paymentPage.getContinueAsAGuest())) {

                if (Actionsss.elementSize(paymentPage.getBrainTree())) {
                    // brain tree negative 
                     PaymentPageValidation.brainTreeAllPaymentsError();
                } else if (Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
                    // salesforce negative
                    Actionsss.javascriptClick(paymentPage.getSalesforceCreditcardRadioBtn());
                     PaymentPageValidation.salesforceCvvError();
                } else if (Actionsss.elementSize(paymentPage.getStripePayment())) {
                	PaymentPageValidation.stripePopUpErrorNoCvvAndPostalCodeEntered();
                	PaymentPageValidation.stripePopUpErrorNoPostalCodeEntered();
                } else if (Actionsss.elementSize(paymentPage.getCyberSourcePayment())) {
                    // cybersource 
                     PaymentPageValidation.getCreditCardCvvErrorInCybersource();
                } else {
                     PaymentPageValidation.getCreditCardCvvErrorMessage();
                }
            } else {
                test.info("User is checked-in as Registered");
                test.pass("Doing the  error validation when user is checked-in  as guest");
            }
        } else {
            logger.info("Gift code was redeemed already");
            test.info("Gift code was redeemed already");
            test.pass("Gift code was redeemed already");
        }
    } 
}
