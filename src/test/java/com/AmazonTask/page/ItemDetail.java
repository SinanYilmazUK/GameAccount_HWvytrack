package com.AmazonTask.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ItemDetail extends BasePageAmazon {

    @FindBy(name = "quantity")
    public WebElement quantity;

    public void setQuantity(String q) {
        Select quantitySelect = new Select(quantity);
        quantitySelect.selectByValue(q);
    }
    @FindBy(id="add-to-cart-button")
    public WebElement addCart;
}
