package junitCucumber;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SendLetterInSpamSteps extends WebDriverSettings{

    @Given("^I am on main application page6$")
    public void loadMainPage()
    {
        driver.get(MAIN_URL);
    }

    @When("^I login as correct user6$")
    public void loginAsCorrectUser()
    {
        loginPage.register(LOGIN, PASSWORD);
    }

    @Then("^I click checkBox6$")
    public void clickCheckBox()
    {
        delMessagePage.clickCheckboxMessage();
    }

    @Then("^I click button spam6$")
    public void clickButtonSpam()
    {
        sendLetterInSpamPage.clickSpamButton();
    }


    @Then("^I see message what letter send in spam6$")
    public void infoLinkSpam()
    {
        Assert.assertTrue(sendLetterInSpamPage.infoLinkPresents());
    }

    @Then("^close browser6$")
    public void close(){
        driver.quit();
    }
}
