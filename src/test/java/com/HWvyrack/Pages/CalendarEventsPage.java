package com.HWvyrack.Pages;

import com.HWvyrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//div[@href='#']")
    public WebElement options;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement pageNumber;

    @FindBy(xpath = "(//button[@data-toggle='dropdown'])[1]")
    public WebElement getPageNumber;

    @FindBy(xpath = "//tr[@class='grid-header-row']//input[@type='checkbox']")
    public WebElement checkAllButton;


}