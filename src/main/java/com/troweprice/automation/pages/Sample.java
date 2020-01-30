package com.troweprice.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {

    private WebDriver driver;

    private By USERNAME = By.xpath("//input[@name = 'email']");
    private By PASSWORD = By.xpath("//input[@name = 'pass']");
    private By LOGIN = By.xpath("//input[@type='submit']");

    public Sample() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
    }

    public void login(String username, String pass) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(USERNAME).sendKeys(username);
        driver.findElement(PASSWORD).sendKeys(pass);
        driver.findElement(LOGIN).click();
    }
}
