package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

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
        WebElement mainMenu = getElement(By.linkText(category));
        System.out.println("Colour before hover: " + mainMenu.getCssValue("color"));
        Assert.assertEquals(
                mainMenu.getCssValue("color"),
                loadProp.getProperty("mainMenuColorBeforeHover"),
                "Error: menu colour do not match before hover");

        actions.moveToElement(mainMenu).perform();
        System.out.println("Colour after hover: " + mainMenu.getCssValue("color"));
        Assert.assertEquals(
                mainMenu.getCssValue("color"),
                loadProp.getProperty("mainMenuColorAfterHover"),
                "Error: menu colour do not match after hover");



//        List<WebElement> subMenus =
//                mainMenu.findElements(By.xpath("//ul[@class=\"sublist first-level\"]/li/a"));

//        System.out.println(subMenus.size());




    }

    public void clickOnSubMenu(String subMenu){
        actions.moveToElement(getElement(By.linkText(subMenu))).click().perform();

    }
}
