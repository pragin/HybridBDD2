package org.example;

import org.openqa.selenium.By;

public class Cart extends Utils {
    By _termsChkBox = By.id("termsofservice");
    By _checkOutBtn = By.id("checkout");

    public void acceptTermsAndConditions(){
        clickOnElement(_termsChkBox);
    }

    public void clickOnCheckOutBtn(){
        clickOnElement(_checkOutBtn);
    }

}
