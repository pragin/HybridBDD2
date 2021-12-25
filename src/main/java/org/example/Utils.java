package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BrowserManager{

    public static void captureScreenshot(String  fileName){
        //convert web driver object to TakeScreenshot
        TakesScreenshot screenshot = ((TakesScreenshot) driver);

        //Call getScreenshotsAs method to create image file
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        File destFile = new File("src/test/screenshots/"+fileName + getCurrentTimeStamp() + ".png");

        //Copy file at destination
        try{
            FileUtils.copyFile(srcFile,destFile);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static void clickOnMenuItem(String category){
        clickOnElement(By.linkText(category));
    }
    public static String getUrl(){
        return driver.getCurrentUrl();
    }

    public static void clickOnElement(By by){
        driver.findElement(by).click();
    }

    public static void typeText(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    public static String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    public static String getCurrentTimeStamp(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyhhmmss");
        return sdf.format(date);
    }
}
