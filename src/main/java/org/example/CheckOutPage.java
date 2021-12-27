package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CheckOutPage extends Utils{
    LoadProp loadProp = new LoadProp();
    By _checkOutHeading = By.xpath("//h1[contains(text(),'Checkout')]");
    By _selectCountry = By.id("BillingNewAddress_CountryId");
    By _cityTextField = By.id("BillingNewAddress_City");
    By _address_1TextField = By.id("BillingNewAddress_Address1");
    By _postCodeTextField = By.id("BillingNewAddress_ZipPostalCode");
    By _phoneNumberTextField = By.id("BillingNewAddress_PhoneNumber");
    By _billingAddressContinueBtn = By.xpath("//div/button[@class=\"button-1 new-address-next-step-button\" and @name=\"save\"]");
    By _radioShippingMethod = By.xpath("//input[@id=\"shippingoption_1\"]");
    By _shippingContinueBtn= By.xpath("//button[@class=\"button-1 shipping-method-next-step-button\"]");
    By _creditCardPaymentRadio = By.id("paymentmethod_1");
    By _paymentContinueBtn = By.xpath("//button[@class=\"button-1 payment-method-next-step-button\"]");

//  Payment information
    By _selectCreditCard = By.id("CreditCardType");
    By _cardHolderNameTextField = By.id("CardholderName");
    By _cardNumber = By.id("CardNumber");
    By _expireMonthSelect = By.id("ExpireMonth");
    By _expiryYearSelect = By.id("ExpireYear");
    By _cardCodeTextField = By.id("CardCode");
    By _paymentInfoContinueBtn = By.xpath("//button[@class=\"button-1 payment-info-next-step-button\"]");
    By _confirmOrderContinueBtn = By.xpath("//button[@class=\"button-1 confirm-order-next-step-button\"]");
    public void verifyUserIsOnCheckOutPage(){
        Assert.assertEquals(
                getTextFromElement(_checkOutHeading),
                loadProp.getProperty("checkoutHeading")
        );
    }

    public void fillBillingAddressForm() {
        selectWithVisibleText(_selectCountry,loadProp.getProperty("country"));
        typeText(_cityTextField, loadProp.getProperty("city"));
        typeText(_address_1TextField, loadProp.getProperty("address1"));
        typeText(_postCodeTextField, loadProp.getProperty("postcode"));
        typeText(_phoneNumberTextField, loadProp.getProperty("phonenumber"));
        clickOnElement(_billingAddressContinueBtn);
    }

    public void fillShippingMethodForm(){
        clickOnElement(_radioShippingMethod);
        clickOnElement(_shippingContinueBtn);
    }

    public void selectPaymentType(){
        clickOnElement(_creditCardPaymentRadio);
        clickOnElement(_paymentContinueBtn);
    }
//  Fills payment information form
    public void fillPaymentInformation() {
        //Select credit card type
        selectWithVisibleText(_selectCreditCard,loadProp.getProperty("creditCardType"));
        //enter card holder name
        typeText(_cardHolderNameTextField, loadProp.getProperty("cardHolderName"));
        //Enter long card number
        typeText(_cardNumber, loadProp.getProperty("cardNumber"));
        //Select credit card expiry month
        selectWithVisibleText(_expireMonthSelect, loadProp.getProperty("expiryMonth"));
        //Select credit card expiry year
        selectWithVisibleText(_expiryYearSelect, loadProp.getProperty("expiryYear"));
        typeText(_cardCodeTextField, loadProp.getProperty("cardCode"));
        //Click on continue button
        clickOnElement(_paymentInfoContinueBtn);
    }
//  confirms the order
    public void confirmOrder() {
        clickOnElement(_confirmOrderContinueBtn);
    }

//    Verifies the order has been successfully placed
    public void verifyOrderSuccess(){
        Assert.assertEquals(
                getTextFromElement(By.xpath("//div[@class=\"title\"]/strong[contains(text(),\"order has been successfull\")]")),
                loadProp.getProperty("orderConfirmationMsg"),
                "ERROR: Error in placing your order"
        );
    }
}
