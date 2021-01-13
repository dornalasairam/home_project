package com.troweprice.automation.selenium;

import com.troweprice.automation.utilities.PropertyReader;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FluentDriverProvider {

    public FluentDriver fluentDriver;

    public FluentDriver get() {
        if (fluentDriver == null) {
            String browser = PropertyReader.getPropertyValue("browser");
            WebDriver driver = null;
            String downloadFilepath = null;
            try {
                downloadFilepath = new File(".\\Downloads").getCanonicalPath();
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (browser) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
                    String chromeLocation = System.getProperty("webdriver.chrome.driver");
                    if (StringUtils.isEmpty(chromeLocation)) {
                        throw new IllegalArgumentException("webdriver.chrome.driver cannot be null !! ");
                    }

                    Map<String, Object> chromePrefs = new HashMap<>();
                    chromePrefs.put("profile.default_content_settings.popups", 0);
                    chromePrefs.put("download.default_directory", downloadFilepath);
                    ChromeOptions options = new ChromeOptions();
                    options.setExperimentalOption("prefs", chromePrefs);
                    options.addArguments(new String[]{"--start-maximized"});
                    driver = new ChromeDriver(options);
                    break;
                case "ff":
                    System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver\\geckodriver.exe");
                    FirefoxProfile firefoxProfile = new FirefoxProfile();
                    firefoxProfile.setPreference("javascript.options.strict", false);
                    firefoxProfile.setPreference("browser.download.folderList", 2); //Use for the default download directory the last folder specified for a download
                    firefoxProfile.setPreference("browser.download.dir", downloadFilepath); //Set the last directory used for saving a file from the "What should (browser) do with this file?" dialog.
                    firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/pdf,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.openxmlformats-officedocument.wordprocessingml.document"); //list of MIME types to save to disk without asking what to use to open the file
                    firefoxProfile.setPreference("pdfjs.disabled", true);  // disable the built-in PDF viewer

                    FirefoxOptions firefoxOptions = new FirefoxOptions().setProfile(firefoxProfile);
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
            }
            driver.manage().window().setSize(new Dimension(1600, 1032));//maximize();
            fluentDriver = new FluentDriver(driver);
        }
        return fluentDriver;
    }

    public void clear() {
        if (fluentDriver != null) {
            fluentDriver.quit();
            fluentDriver = null;
        }
    }
}
