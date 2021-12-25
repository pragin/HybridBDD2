package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage extends Utils{

    static By _genderMaleRadioButton = By.id("gender-male");
    static By _firstNameField = By.id("FirstName");
    static By _lastNameField = By.id("LastName");
    static By _emailField = By.id("Email");
    static By _newsLetterCheckBox = By.id("Newsletter");
    static By _passwordField = By.id("Password");
    static By _confirmPasswordField = By.id("ConfirmPassword");
    static By _clickOnRegisterButton = By.id("register-button");

    LoadProp loadProp = new LoadProp();

    //Check if the user is in register page
    public  void checkUserIsInRegisterPage(){
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));
    }

    public void fillUserDetails(){
        //Click on male radio button
        clickOnElement(_genderMaleRadioButton);
        //Enter first name
        typeText(_firstNameField, loadProp.getProperty("FirstName"));
        //Enter last name
        typeText(_lastNameField,loadProp.getProperty("LastName"));
        //Select Day of birth
        Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        selectDay.selectByValue("5");
        //Select Month of birth
        Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        selectMonth.selectByVisibleText("March");
        //Select year
        Select selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        selectYear.selectByVisibleText("2000");
        //Enter email
        String email = loadProp.getProperty("emailPartOne") + getCurrentTimeStamp() + loadProp.getProperty("emailPartTwo");
        typeText(_emailField,email);
        //Deselect newsletter checkbox
        clickOnElement(_newsLetterCheckBox);
        //Enter password
        typeText(_passwordField, loadProp.getProperty("password"));
        //Enter confirm password
        typeText(_confirmPasswordField,loadProp.getProperty("confirmPassword"));

    }

    public  void clickOnRegisterButton(){
        //Click on register button
//        waitForClickable(By.id("register-button"),20);
        clickOnElement(_clickOnRegisterButton);
    }
}
