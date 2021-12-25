package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class NewReleasePage extends Utils {

    By _titleTextField = By.id("AddNewComment_CommentTitle");
    By _commentTextTextArea = By.id("AddNewComment_CommentText");
    By _addCommentButton = By.name("add-comment");

    LoadProp loadProp = new LoadProp();

    public void checkUserIsInTheNewReleasePage(){
        Assert.assertTrue(driver.getCurrentUrl().contains("nopcommerce-new-release"));
    }

    public void checkTheCommentIsPostedSuccessfully(){
        String actualResult = getTextFromElement(By.xpath("//div[@class=\"result\"]")) ;
        String expectedResult = "News comment is successfully added.";

        Assert.assertEquals(actualResult,loadProp.getProperty("newCommentExpectedResult"), "Comment error: error in posting the comment");
    }

    public void fillCommentSection(){
        //Enter title
        typeText(_titleTextField, loadProp.getProperty("title"));
        //Enter comment
        typeText(_commentTextTextArea, loadProp.getProperty("comment"));
    }

    public void clickOnNewCommentButton(){
        //Click on add comment button
        clickOnElement(_addCommentButton);
    }


}
