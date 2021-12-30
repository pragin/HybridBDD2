package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        WebElement mainMenu = getElement(By.linkText(category));
        //Print the font color before hover
        System.out.println("Colour before hover: " + mainMenu.getCssValue("color"));
        Assert.assertEquals(
                mainMenu.getCssValue("color"),
                loadProp.getProperty("mainMenuColorBeforeHover"),
                "Error: menu colour do not match before hover");

        //Mouse hover on main manu
        actions.moveToElement(mainMenu).perform();
        //Print the font colour after hover
        System.out.println("Colour after hover: " + mainMenu.getCssValue("color"));
        Assert.assertEquals(
                mainMenu.getCssValue("color"),
                loadProp.getProperty("mainMenuColorAfterHover"),
                "Error: menu colour do not match after hover");
    }

    //Clicks on sub menu items
    public void clickOnSubMenu(String subMenu){
        actions.moveToElement(getElement(By.linkText(subMenu))).click().perform();
    }
}
