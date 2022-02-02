package com.AmazonTask.page;

import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePageAmazon {

    public BasePageAmazon(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="nav-cart-count-container")
    public WebElement cart;

    @FindBy(id="nav-logo-sprites")
    public WebElement homeLogo;

    @FindBy(id="twotabsearchtextbox")
    public WebElement searchBar;

    @FindBy(id="nav-search-submit-button")
    public WebElement searchButton;
}
