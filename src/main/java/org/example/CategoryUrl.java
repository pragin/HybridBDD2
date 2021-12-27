package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class CategoryUrl extends Utils {
    By _pageTitle = By.xpath("//h1");

    Actions actions = new Actions(driver);


    public void verifyUrl(String pageURL) {
        Assert.assertTrue(getUrl().equals(pageURL));
    }
    public void verifyPageTitle(String pageTitle) {
        Assert.assertEquals(getTextFromElement(_pageTitle), pageTitle);
    }

    public void hoverOverMainMenu(String category){
        actions.moveToElement(getElement(By.linkText(category))).perform();
    }

    public void clickOnSubMenu(String subMenu){
        actions.moveToElement(getElement(By.linkText(subMenu))).click().perform();

    }
}
