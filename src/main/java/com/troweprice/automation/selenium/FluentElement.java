package com.troweprice.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class FluentElement {

    private By by;
    private WebElement webElement;
    private SearchContext searchContext;
    private String elementName;

    public FluentElement(By by, SearchContext searchContext) {
        this.by = by;
        this.searchContext = searchContext;
    }

    public FluentElement(WebElement webElement) {
        this.webElement = webElement;
        this.searchContext = webElement;
    }

    public FluentElement name(final String name) {
        this.elementName = name;
        return this;
    }

    //click
    //sendkeys

    // fluentdriver().fluementelement(xpath).waituntill(10).ifelementisnotdisplayed().click();

    // driver.findlemtn(BY.xpath).click();
}
