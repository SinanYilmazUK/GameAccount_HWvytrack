package com.AmazonTask.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CartPage extends BasePageAmazon{

    @FindBy(xpath = "//p[@class='a-spacing-mini']/span")
    public WebElement singleItemPrice;

    @FindBy(name="quantity")
    public WebElement quantityCart;

    @FindBy(css = "#sc-subtotal-amount-activecart>span")
    public  WebElement totalCart;

    public String getQuantity(){
        Select qSelect = new Select(quantityCart);
        return qSelect.getFirstSelectedOption().getText();
    }
    public void setQuantity(String q) {
        Select quantitySelect = new Select(quantityCart);
        quantitySelect.selectByValue(q);
    }
}
