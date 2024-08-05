package com.troweprice.automation;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepHooks {

    private  WebDriver driver;
    @Before
    public void login(){
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
    }

    @After
    public void logOut() {
        driver.quit();
    }
}
