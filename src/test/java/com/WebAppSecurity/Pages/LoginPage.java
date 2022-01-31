package com.WebAppSecurity.Pages;

import com.WebAppSecurity.utilities.ConfigurationReader;
import com.WebAppSecurity.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//button[@id='signin_button']/i")
    public WebElement signInButton;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement loginTextBox;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement passwordBox;

    @FindBy(name = "submit")
    public WebElement submitButton;





}
