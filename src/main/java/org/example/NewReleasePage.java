package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class NewReleasePage extends Utils {

    By _titleTextField = By.id("AddNewComment_CommentTitle");
    By _commentTextTextArea = By.id("AddNewComment_CommentText");
    By _addCommentButton = By.name("add-comment");
    By _comments = By.xpath("//div[@class=\"comment news-comment\"]");

    LoadProp loadProp = new LoadProp();

    public void checkUserIsInTheNewReleasePage(){
        Assert.assertTrue(driver.getCurrentUrl().contains("nopcommerce-new-release"));
    }

    public void checkTheCommentIsPostedSuccessfully(){
        String actualResult = getTextFromElement(By.xpath("//div[@class=\"result\"]")) ;
        String expectedResult = "News comment is successfully added.";

        Assert.assertEquals(actualResult,loadProp.getProperty("newCommentExpectedResult"), "Comment error: error in posting the comment");

        List<WebElement> commentsList = driver.findElements(_comments);

        WebElement myComment = commentsList.get(commentsList.size() -1);

        String title = myComment.findElement(By.xpath("//strong[contains(text(),'aaaP')]")).getText();
        String comment = myComment.findElement(By.xpath("//p[contains(text(),'Good product')]")).getText();

        Assert.assertEquals(
                title,
                loadProp.getProperty("title"),
                "Error: comment title does not match");

        Assert.assertEquals(
                comment,
                loadProp.getProperty("comment"),
                "Error: Comment body does not match");

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
