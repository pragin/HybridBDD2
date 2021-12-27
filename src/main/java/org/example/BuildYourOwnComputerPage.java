package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class BuildYourOwnComputerPage extends Utils {
    By _emailAFriendButton = By.xpath("//div[@class=\"email-a-friend\"]/button");
    By _processor = By.id("product_attribute_1");
    By _ram = By.id("product_attribute_2");
    By _radioHDD = By.id("product_attribute_3_6");
    By _radioOS = By.id("product_attribute_4_8");
    By _addToCartBtn = By.id("add-to-cart-button-1");
    By _barNotificationSuccess = By.xpath("//div[@class=\"bar-notification success\"]");
    By _shoppingCartBtn = By.xpath("//span[@class=\"cart-label\"]");
    By _barNotificationCloseBtn = By.xpath("//span[@class=\"close\"]");

    public void checkUserIsOnThisPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("build-your-own-computer"));
    }

    public void clickOnEmailAFriendButton() {
        clickOnElement(_emailAFriendButton);
    }

    public void selectProcessor() {
        selectWithVisibleText(_processor, "2.2 GHz Intel Pentium Dual-Core E2200");
    }

    public void selectRAM() {
        selectWithVisibleText(_ram, "8GB [+$60.00]");
    }

    public void selectHDD() {
        clickOnElement(_radioHDD);
    }

    public void chooseOS() {
        clickOnElement(_radioOS);
    }

    public void chooseSoftware() {
        List<WebElement> chkBoxList = driver.findElements(By.name("product_attribute_5"));
        for (WebElement checkBox : chkBoxList) {
            if (!checkBox.isSelected()) {
                checkBox.click();
            }
        }
    }
    public void verifyProductHasBeenAddedSuccessfully() {
        Assert.assertEquals(
                getTextFromElement(_barNotificationSuccess),
                loadProp.getProperty("productAddedSuccessMsg"),
                "Error: Product has NOT been added successfully!!!"
        );
        clickOnElement(_barNotificationCloseBtn);
    }

    public void clickOnAddToCartBtn(){
        clickOnElement(_addToCartBtn);
    }

    public void clickOnShoppingCartBtn() {
        Utils.waitForVisible(By.xpath("//span[@class=\"cart-label\"]"),20);
        clickOnElement(_shoppingCartBtn);
    }
}
