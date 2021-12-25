package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class DesktopPage extends Utils{

    By _buildYourOwnComputerLink = By.linkText("Build your own computer");

    public void checkUserIsInTheDesktopPage(){
        Assert.assertTrue(driver.getCurrentUrl().contains("desktops"));
    }
    public void clickOnAProduct(){
        clickOnElement(_buildYourOwnComputerLink);
    }
}
