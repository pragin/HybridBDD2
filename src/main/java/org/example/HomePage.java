package org.example;

import org.openqa.selenium.By;

public class HomePage extends Utils {

     By _registerLink = By.linkText("Register");
     By _computersMenu = By.xpath("//div[@class=\"header-menu\"]/ul[1]/li[1]/a[@href=\"/computers\"]");
     By _detailsButton = By.xpath("//div[@class=\"buttons\"]/a[@href=\"/nopcommerce-new-release\"]");

    public void clickOnRegisterLink(){
        clickOnElement(_registerLink);
    }
    public void clickOnComputersMenu(){
        clickOnElement(_computersMenu);
    }

    public void clickOnDetailsButton(){
        clickOnElement(_detailsButton);
    }
}
