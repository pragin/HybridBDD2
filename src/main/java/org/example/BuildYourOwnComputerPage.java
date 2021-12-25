package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class BuildYourOwnComputerPage extends Utils{

    By _emailAFriendButton = By.xpath("//div[@class=\"email-a-friend\"]/button");
    public void checkUserIsOnThisPage(){
        Assert.assertTrue(driver.getCurrentUrl().contains("build-your-own-computer"));
    }

    public void clickOnEmailAFriendButton(){
        clickOnElement(_emailAFriendButton);
    }
}
