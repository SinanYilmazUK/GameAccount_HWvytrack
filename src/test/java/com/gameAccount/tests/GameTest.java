package com.gameAccount.tests;

import com.gameAccount.pagesGameAcc.HomePage;
import com.gameAccount.pagesGameAcc.RegistrationPage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GameTest extends GameAccount_TestBase {

//    @BeforeMethod
//    public void bbb(){
//
//
//        Driver.get().manage().window().maximize();
//
//        Driver.get().manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
//
//        Driver.get().get("https://moneygaming.qa.gameaccount.com/");
//    }



    @Test
    public void GameTest(){

        HomePage director = new HomePage();

        director.joinButton.click();

        RegistrationPage pointer  =new RegistrationPage();

        pointer.setTitleDropDown("Mr");

        Faker fakeCredentials = new Faker();

        pointer.firstname.sendKeys(fakeCredentials.name().firstName());

        pointer.surname.sendKeys(fakeCredentials.name().lastName());

        pointer.JoinNowButtonRes.click();

        String ExpectedRes = "This field is required";

        Assert.assertEquals(pointer.NoticeLabel.getText(),ExpectedRes,"Verify that label is not correct");








    }


}
