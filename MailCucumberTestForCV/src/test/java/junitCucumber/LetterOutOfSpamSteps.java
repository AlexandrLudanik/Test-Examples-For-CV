package junitCucumber;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LetterOutOfSpamSteps extends WebDriverSettings {

    @Given("^I am on main application page3$")
    public void loadMainPage()
    {
        driver.get(MAIN_URL);
    }

    @When("^I login as correct user3$")
    public void loginAsCorrectUser()
    {
        loginPage.register(LOGIN, PASSWORD);
    }

    @Then("^I click spam link3$")
    public void clickSpamLink()
    {
        letterOutOfSpamPage.clickSpamLink();
    }

    @Then("^I click checkbox3$")
    public void clickCheckBoxSpam()
    {
        letterOutOfSpamPage.clickCheckBoxSpam();
    }

    @Then("^I click button no spam3$")
    public void clickButtonNoSpam()
    {
        letterOutOfSpamPage.clickNoSpamButton();
    }

    @Then("^I see info message3$")
    public void infoLink()
    {
        Assert.assertTrue(letterOutOfSpamPage.infoLinkPresents());
    }

    @Then("^close browser3$")
    public void close(){
        driver.quit();
    }
}
