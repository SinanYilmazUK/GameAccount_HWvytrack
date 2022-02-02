package com.AmazonTask.test;

import com.amazon.page.*;
import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class amazonTest extends TestBase {


    @Test
    public void SearchTest(){
        Home home = new Home();
        home.searchBar.sendKeys(ConfigurationReader.get("item"));
        home.searchButton.click();


        SearchedItem searchedItem = new SearchedItem();

        BrowserUtils.waitForClickablility(searchedItem.firstItem,8);
        Actions action = new Actions(Driver.get());
        action.moveToElement(searchedItem.firstItem).doubleClick().perform();

        ItemDetail itemDetail = new ItemDetail();

        String quantity = "2";
        itemDetail.setQuantity(quantity);
        itemDetail.addCart.click();
        itemDetail.cart.click();

        CartPage cartPage = new CartPage();
        Assert.assertEquals(cartPage.getQuantity(),quantity,"Sinancım hepsi doğru");
        double actual = Double.parseDouble(cartPage.getQuantity())*Double.parseDouble(cartPage.singleItemPrice.getText().substring(1));
        double expected = Double.parseDouble(cartPage.totalCart.getText().substring(1));
        Assert.assertEquals(actual,expected,"total value is true.");

        cartPage.setQuantity("1");
        BrowserUtils.waitFor(3);
        quantity="1";
        Assert.assertEquals(cartPage.getQuantity(),quantity,"Sinancım hepsi doğru");
        double actual2 = Double.parseDouble(cartPage.getQuantity())*Double.parseDouble(cartPage.singleItemPrice.getText().substring(1));
        double expected2 = Double.parseDouble(cartPage.totalCart.getText().substring(1));

        Assert.assertEquals(actual2,expected2,"total value is true.");

    }
}
