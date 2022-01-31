package com.HWvyrack.Tests;

import com.HWvyrack.Pages.CalendarEventsPage;
import com.HWvyrack.Pages.DashboardPage;
import com.HWvyrack.Pages.LoginPage;
import com.WebAppSecurity.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class vyTrack_test extends TestBase {


    CalendarEventsPage calendarEventsPage ;


    @BeforeMethod
    public void preTest(){

        LoginPage login = new LoginPage();

        login.loginAsStoreManager();

        DashboardPage dashboard = new DashboardPage();

        dashboard.navigateToModule("Activities", "Calendar Events");

        calendarEventsPage = new CalendarEventsPage();

        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(5);
    }
    @Test
    public void TC01(){


        Assert.assertTrue(calendarEventsPage.options.isDisplayed(),"verify that option is not displayed");

    }

    @Test
    public void TC02(){

        Assert.assertEquals(calendarEventsPage.pageNumber.getAttribute("Value"),"1","verify that page number is not 1");

    }

    @Test
    public void TC03(){

        Assert.assertEquals(calendarEventsPage.getPageNumber.getText(),"25","Verify");

    }

    @Test
    public void TC04(){

        calendarEventsPage.getPageNumber.click();
        driver.findElement(By.xpath("//a[@data-size='50']")).click();

        BrowserUtils.waitFor(2);

        List<WebElement> rowsNumber = driver.findElements(By.cssSelector(".grid-body>tr"));

        WebElement expectedRows = driver.findElement(By.xpath("//label[@class='dib'][3]"));

        String expectedRowContent =( ( expectedRows.getText()).split(" ") )[2];

        System.out.println("expectedRowContent = " + expectedRowContent);

        Assert.assertEquals(rowsNumber.size(), Integer.parseInt(expectedRowContent), "Verify numbers");


    }

    @Test
    public void TC05(){

        calendarEventsPage.checkAllButton.click();

        BrowserUtils.waitFor(2);

        List<WebElement> rowsCheckbox = driver.findElements(By.cssSelector(".grid-body>tr input"));


        for (WebElement checkbox : rowsCheckbox) {

            Assert.assertTrue(checkbox.isSelected(),"verify checkbox is not selected");

        }
    }

    @Test
    public void TC06(){

        WebElement testerRow = driver.findElement(By.xpath("//td[text()='Testers meeting']"));

        testerRow.click();

        List<WebElement> descriptions = driver.findElements(By.xpath("//div[@class='controls']/div"));

        List<WebElement> titles = driver.findElements(By.xpath("//label[@class='control-label']"));

        Map<String, String> table = new HashMap<>();

        for (int i = 0; i < titles.size(); i++) {

            table.put(titles.get(i).getText(),descriptions.get(i).getText());

        }

        Map<String,String> ExpectedTable = new HashMap<>();

        ExpectedTable.put("Title", "Testers meeting");
        ExpectedTable.put("Description","This is a a weekly testers meeting");
        ExpectedTable.put("Start" ,"Nov 27, 2019, 9:30 AM");
        ExpectedTable.put("End", "Nov 27, 2019, 10:30 AM");
        ExpectedTable.put("All-Day Event" ,"No");
        ExpectedTable.put("Organizer","John Doe");
        ExpectedTable.put("Call Via Hangout", "No");


        Assert.assertEquals(table,ExpectedTable,"Verify tables contents");



    }
}
