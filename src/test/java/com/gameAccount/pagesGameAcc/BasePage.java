package com.gameAccount.pagesGameAcc;

import com.gameAccount.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }


    @FindBy(xpath = "//div[@class='login_links']/a[2]")
    public WebElement joinButton;



}
