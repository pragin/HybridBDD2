package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductEmailAFriendPage extends Utils{
    By _friendEmailTextBox = By.id("FriendEmail");
    By _messsageTextArea  =By.id("PersonalMessage");
    By _sendEmailButton = By.name("send-email");

    LoadProp loadProp = new LoadProp();

    public void checkUserIsOnTheProductEmailAFriendPage(){
        Assert.assertTrue(driver.getCurrentUrl().contains("productemailafriend"));
    }

    public void checkEmailIsSentSuccessfully(){
        String actualResult = getTextFromElement(By.xpath("//div[@class=\"result\"]"));
//        String expectedResult = "Your message has been sent.";

        Assert.assertEquals(actualResult,loadProp.getProperty("sendEmailExpectedResult"), "Error: Unable to refer the product");
    }

    public void fillEmailAFriendForm(){
        typeText(_friendEmailTextBox, loadProp.getProperty("friendsEmail") );
        typeText(_messsageTextArea,loadProp.getProperty("personalMessage"));
    }

    public void clickOnSendEmailButton(){
        clickOnElement(_sendEmailButton);

    }
}
