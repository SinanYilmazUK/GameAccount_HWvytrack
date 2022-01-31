package com.WebAppSecurity.Tests;

import com.WebAppSecurity.Pages.AccountActivity;
import com.WebAppSecurity.Pages.HomePage;
import com.WebAppSecurity.Pages.LoginPage;
import com.WebAppSecurity.utilities.BrowserUtils;
import com.WebAppSecurity.utilities.ConfigurationReader;
import com.WebAppSecurity.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AppSecurity_Tests extends AppSecurity_TestBase {

    @Test
    public void testCase_01_02() {

        //TestCase_01
        LoginPage login = new LoginPage();

        BrowserUtils.waitForClickablility(login.signInButton, 10);

        login.signInButton.click();

        login.loginTextBox.sendKeys(ConfigurationReader.get("Username"));

        login.passwordBox.sendKeys(ConfigurationReader.get("Password"));

        login.submitButton.click();

        BrowserUtils.handlingSSl();

        String actualPageTitle = Driver.get().getTitle();

        String expectedPageTitle = "Zero - Account Summary";

        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Verify page title");

        //testCase_02

        List<WebElement> accountTypes = driver.findElements(By.xpath("//div//h2"));

        String[] str = {"Cash Accounts", "Investment Accounts", "Credit Accounts", "Loan Accounts"};

        int index =0;
        for (WebElement each : accountTypes) {
            Assert.assertTrue(each.getText().equals(str[index]),"verify " + index+"th account types ");
            index++;
        }

        List<WebElement> tableContents = driver.findElements(By.xpath("//th[text()='Credit Card']/../th"));

        String[] str2 = {"Account", "Credit Card","Balance"};

        index = 0;
        for (WebElement each : tableContents) {
            Assert.assertEquals(each.getText(),str2[index],"verify " + index+ "th table content");
            index++;
        }


        HomePage mouse = new HomePage();
        mouse.navigateToModule("Account Activity");

        AccountActivity pointer = new AccountActivity();

        String expectedFirst = "Savings";

        Assert.assertEquals(pointer.checkFirstOption(),expectedFirst,"verify first option");

        List<String> AllOptions =BrowserUtils.getElementsText(pointer.getAllOptions());

        String[] strExp = {"Savings", "Checking", "Savings","Loan","Credit Card", "Brokerage"};

        index =0;
        for (String each : AllOptions) {

            Assert.assertEquals(each,strExp[index],"verify options");
            index++;
        }

        List<WebElement> trans_table_contents = pointer.trans_table_contents;

        String[] strTrans = {"Date", "Description","Deposit","Withdrawal"};

        index=0;
        for (WebElement each : trans_table_contents) {

            Assert.assertEquals(each.getText(),strTrans[index],"verify transaction content");

            index++;
        }



    }

}


