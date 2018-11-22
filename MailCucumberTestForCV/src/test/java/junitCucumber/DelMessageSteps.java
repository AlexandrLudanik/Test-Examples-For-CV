package junitCucumber;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class DelMessageSteps extends WebDriverSettings{

    @Given("^I am on main application page2$")
    public void loadMainPage()
    {
        driver.get(MAIN_URL);
    }

    @When("^I login as correct user2$")
    public void loginAsCorrectUser()
    {
        loginPage.register(LOGIN, PASSWORD);
    }

    @Then("^I click checkBox$")
    public void clickCheckBox()
    {
        delMessagePage.clickCheckboxMessage();
    }

    @Then("^I click button delete$")
    public void clickButtonDelete()
    {
       delMessagePage.ClickButtonDelete();
    }


    @Then("^I see message what letter delete$")
    public void infoLinkDelete()
    {
        Assert.assertTrue(delMessagePage.infoLinkPresents());
    }

    @Then("^close browser2$")
    public void close(){
        driver.quit();
    }

}
