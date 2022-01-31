package com.gameAccount.pagesGameAcc;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {


    @FindBy(id = "title")
    public WebElement titleDropDown;

    @FindBy(id = "forename")
    public WebElement firstname;

    @FindBy(name="map(lastName)")
    public WebElement surname;

    @FindBy(name="map(terms)")
    public WebElement checkbox;

    @FindBy(xpath = "//input[@value='Join Now!']")
    public WebElement JoinNowButtonRes;


    @FindBy(xpath = "//label[@for='dob']")
    public WebElement NoticeLabel;


    public void setTitleDropDown(String Title){

        Select action = new Select(titleDropDown);

        action.selectByVisibleText(Title);


    }
}
