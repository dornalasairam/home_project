package com.troweprice.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

import java.util.concurrent.TimeUnit;

public class FluentWait<T> {

    private final int timeout;
    private WaitType waitType;
    private final T fluentElement;
    private final By by;
    private boolean ignoreError;
    private SearchContext searchContext;
    private String message;

    public FluentWait(final int timeout, final By by, final T fluentElement, final SearchContext searchContext) {
        this.timeout = timeout;
        this.by = by;
        this.fluentElement = fluentElement;
        this.searchContext = searchContext;

    }

    private org.openqa.selenium.support.ui.FluentWait getWebDriverWait(final SearchContext searchContext, final int timeout) {
        org.openqa.selenium.support.ui.FluentWait<SearchContext> webdriverWait = new org.openqa.selenium.support.ui.FluentWait<>(searchContext);
        webdriverWait.pollingEvery(1, TimeUnit.MILLISECONDS);
        webdriverWait.withTimeout(timeout, TimeUnit.SECONDS);
        webdriverWait.withMessage(message);
        return webdriverWait;
    }


}
