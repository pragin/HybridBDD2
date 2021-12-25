package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationSuccessPage extends Utils{

    LoadProp loadProp = new LoadProp();

    public void verifyUserIsOnRegisterSuccessPage(){

        Assert.assertTrue(driver.getCurrentUrl().contains(""));
    }

    public void verifyUserHasSuccessfullyRegistered(){
        //Check if the test case passed

        //waitForVisible(By.xpath("//div[@class=\"result\"]"),20);
        String actualResult = getTextFromElement(By.xpath("//div[@class=\"result\"]"));
        Assert.assertEquals(actualResult, loadProp.getProperty("registrationExpectedResult"), "Registration Error: Registration failed!!!");

    }
}
