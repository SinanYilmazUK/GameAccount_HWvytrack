package com.AmazonTask.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchedItem extends BasePageAmazon{
    @FindBy(xpath ="(//a/div/img)[1]")
    public WebElement firstItem;

}

