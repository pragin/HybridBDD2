package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends Utils {

     By _registerLink = By.linkText("Register");
     By _computersMenu = By.xpath("//div[@class=\"header-menu\"]/ul[1]/li[1]/a[@href=\"/computers\"]");
     By _detailsButton = By.xpath("//div[@class=\"buttons\"]/a[@href=\"/nopcommerce-new-release\"]");
     By _voteBtn = By.id("vote-poll-1");
     By _pollAnswerExcellentRadio = By.id("pollanswers-1");
     By _votingError = By.id("block-poll-vote-error-1");

    public void clickOnRegisterLink(){
        clickOnElement(_registerLink);
    }
    public void clickOnComputersMenu(){
        clickOnElement(_computersMenu);
    }

    public void clickOnDetailsButton(){
        clickOnElement(_detailsButton);
    }

    public void clickOnVoteBtn(){
        clickOnElement(_voteBtn);
    }

    public void handleAlertBox(){
//        Alert message
        String alertMsg = driver.switchTo().alert().getText();
        Assert.assertEquals(
                alertMsg,
                loadProp.getProperty("votealertmsg"),
                "Error: Alert message not same"
        );
//        click ok on alert box
        driver.switchTo().alert().accept();
    }

    public void selectAnAnswer(){
        clickOnElement(_pollAnswerExcellentRadio);
    }

    public void handleVotingError(){
        System.out.println(getTextFromElement(_votingError));
        Assert.assertEquals(
                getTextFromElement(_votingError),
                loadProp.getProperty("votingError"),
                "Error: Voting error messages do not match");
    }
}
