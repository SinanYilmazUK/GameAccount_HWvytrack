package com.AmazonTask.test;

import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    //this class is used for starting and building reports
    protected static ExtentReports report;
    //this class is used to create HTML report file
    protected static ExtentHtmlReporter htmlReporter;
    //this will  define a test, enables adding logs, authors, test steps
    protected static ExtentTest extentLogger;

    //env set up
   protected  String url;



    @BeforeMethod
    @Parameters("env")
    public void setUp(@Optional String env){

        System.out.println("env== " + env);
        if (env==null){
            url =ConfigurationReader.get("url");
        }else{

            url = ConfigurationReader.get(env+"_url");
        }
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);
        driver.get(url);

    }
    //ITestResult class describes the result of a test in TestNG
    @AfterMethod
    public void tearDown()  {

        Driver.closeDriver();
    }





}
