package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ComputersPage extends Utils{

    By _desktopHeading = By.xpath("//h2/a[@href=\"/desktops\"]");

    public void checkUserIsInTheComputersPage(){
        Assert.assertTrue(driver.getCurrentUrl().contains("computers"));
    }

    public void clickOnDesktopsHeading(){
        //Click on Desktop heading
        clickOnElement(_desktopHeading);

    }

}
