package com.troweprice.automation.selenium;

import org.openqa.selenium.SearchContext;

public class WebElementProvider {

    private SearchContext searchContext;

    public WebElementProvider(SearchContext searchContext) {
        this.searchContext = searchContext;
    }

    public static WebElementProvider get(SearchContext context) {
        return new WebElementProvider(context);
    }

}
