package com.troweprice.automation;

import com.troweprice.automation.pages.Sample;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class sampleSteps {


    @When("^I navigate to facebook login page and enter \"([^\"]*)\", \"([^\"]*)\"$")
    public void iNavigateToFacebookLoginPageAndEnter(String username, String pass) {
        Sample sample = new Sample();
        sample.login(username, pass);
    }

    @Then("^I validate the login is sucessful$")
    public void iValidateTheLoginIsSucessful() {

    }
}
