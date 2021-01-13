package com.troweprice.automation.pages;

import com.troweprice.automation.selenium.FluentDriverProvider;
import com.troweprice.automation.utilities.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {

    private WebDriver driver = null;
    public static FluentDriverProvider fd;

    private By USERNAME = By.xpath("//input[@name = 'email']");
    private By PASSWORD = By.xpath("//input[@name = 'pass']");
    private By LOGIN = By.xpath("//input[@type='submit']");

    public Sample() {
        fd = new FluentDriverProvider();
        fd.get().get(PropertyReader.getPropertyValue("Login_Url"));
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
