package com.WebAppSecurity.Pages;

import com.WebAppSecurity.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage_Security {

    public BasePage_Security(){

        PageFactory.initElements(Driver.get(),this);
    }

    public void navigateToModule(String moduleName){

        String path = "//a[text()='"+moduleName+"']";

        Driver.get().findElement(By.xpath(path)).click();

    }




}
