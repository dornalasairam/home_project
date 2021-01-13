package com.troweprice.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FluentDriver {

    private WebDriver driver;


    public FluentDriver(WebDriver driver) {
        this.driver = driver;
    }

    public FluentElement element(final By by) {
        return new FluentElement(by, driver);
    }

    public void get(String url) {
        driver.navigate().to(url);
    }

    public void quit() {
    }
}
