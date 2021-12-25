package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class Footer extends Utils{

    public void clickOnSocialIcon(String social){
        clickOnElement(By.linkText(social));
    }

    public void windowHandle(String URL){
        String mainWindow = driver.getWindowHandle();

        //To handle all new opened window
        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> iterator = allWindows.iterator();
        System.out.println(allWindows.size());
        while(iterator.hasNext()){
            String childWindow = iterator.next();
            System.out.println(childWindow);
            if(!mainWindow.equalsIgnoreCase(childWindow)){
                //Switching to child window
                driver.switchTo().window(childWindow);
                System.out.println(driver.getCurrentUrl());
                Assert.assertTrue(driver.getCurrentUrl().contains("nopCommerce"));

                //closing the child window
                driver.close();
            }
        }

        //switch to main window
        driver.switchTo().window(mainWindow);
   }

   public void verifyUserIsOnSocialMediaPage(String url){
        windowHandle(url);
   }
}

