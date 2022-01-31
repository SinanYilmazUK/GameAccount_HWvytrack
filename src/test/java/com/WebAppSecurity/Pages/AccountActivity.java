package com.WebAppSecurity.Pages;

import com.WebAppSecurity.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountActivity extends BasePage_Security{

    @FindBy(css = "#aa_accountId")
    public WebElement AccountOptions;

    @FindBy(xpath = "//th[text()='Date']/../th")
    public List<WebElement> trans_table_contents;




    public String checkFirstOption(){

        Select select = new Select(AccountOptions);

        return select.getFirstSelectedOption().getText();
    }

    public List<WebElement> getAllOptions(){

        Select select = new Select(AccountOptions);

        List<WebElement> options = select.getOptions();

        return options;

    }


}
